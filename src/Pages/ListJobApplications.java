package Pages;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.mongodb.client.MongoDatabase;

import Alogrithms.AppQuickSort;
import DataHandlers.DocumentHandler;
import DataHandlers.JobApplicationHandler;
import DataHandlers.UserHandler;
import Models.JobApplication;
import Models.JobDocument;
import Models.User;
import MyCollections.AppArray;
import MyCollections.AppBag;
import MyCollections.JobApplicationBinaryTree;

public class ListJobApplications {
	private static User sessionUser;
	private static MongoDatabase sessionDb;
	
	private static DocumentHandler docHandler;
	private static UserHandler userHandler;
	private static JobApplicationHandler jobHandler;
	static Scanner inp = new Scanner(System.in);
	
	private static AppBag<JobApplication> appliedJobs;
	private static AppBag<JobDocument> userDocs;
	
	//Constructor
	public ListJobApplications(User user, MongoDatabase sessionDb) {
		this.sessionDb = sessionDb;
		this.sessionUser = user;
		
		userHandler = new UserHandler(sessionDb);
		jobHandler = new JobApplicationHandler(sessionDb);
		docHandler = new DocumentHandler(sessionDb);
		
		appliedJobs = new AppArray<>();
		userDocs = new AppArray<>();
		
		System.out.println("------------------------ Job Applications Page -------------------------");
		System.out.println(user.getFullName()+"'s Applciations");
	}
	
	public static void start() {
		setObjectDataToJobs();
		System.out.println("Select One:\n"
				+ "1) List Applications\n"
				+ "2) Add an application\n"
				+ "3) Select Application\n"
				+ "4) Search For an Application");
		
		int userChoice = inp.nextInt();
		while(userChoice<1 || userChoice >4) {
			System.out.println("invalid choice, try again:");
			userChoice = inp.nextInt();
		}
		switch(userChoice) {
		case 1:
			listAllApplications();
			break;
		case 2:
			addJobApplication();
			break;
		case 3:
			selectApplication();
			break;
		case 4:
			searchApplication();
			break;
		}
		
	}

	private static void searchApplication() {
		// TODO Auto-generated method stub
		System.out.println("Search Parameters:");
		String searchParams = inp.next();
		
		JobApplicationBinaryTree jobs = new JobApplicationBinaryTree();
		for(int i =0; i< appliedJobs.getCurrentSize(); i++) {
			jobs.insert(appliedJobs.get(i));
		}
		
		listApplications(jobs.search(searchParams));
		
	}

	private static void addJobApplication() {
		System.out.print("\n-------------------New Application");
		JobApplication newJob = new JobApplication();
		newJob.setApplicationID(appliedJobs.getCurrentSize()+2001);
		 
		System.out.println("Enter Company name");
		newJob.setCompanyName(inp.nextLine());
		
		System.out.println("Enter Job Title");
		newJob.setJobTitle(inp.nextLine());
		
		System.out.println("Enter applied Date (yyyy-MM-dd HH:mm):");
		newJob.setAppliedDate(inp.nextLine());
		
		System.out.println("Enter applicaiton Status");
		newJob.setApplicationStatus(inp.nextLine());
		
		if(!userDocs.isEmpty()) {
			System.out.println("Enter a doc id from following docs");
			System.out.println(userDocs.toString());
			newJob.addDocument(inp.nextInt());
		}
		
		String insertStatus = jobHandler.postJobApplication(newJob);
		System.out.println(insertStatus);
		if(insertStatus == "Job Application Added Successfully") {
			sessionUser.addJobApplication(newJob.getApplicationID());
			String updateStatus = userHandler.updateUser(sessionUser.getUsername(), sessionUser);
			System.out.println(updateStatus);
		}
	}

	private static void selectApplication() {
		System.out.println("----------------Select Application");
		System.out.println("Enter Application Id:");
		int selectedJobId = inp.nextInt();
		
		
	}

	private static void listAllApplications() {
		// TODO Auto-generated method stub
		System.out.println("Sort them Base on?\n"
				+ "1) Company Name\n"
				+ "2) Job role\n"
				+ "3) Applied Date");
		int userChoice = inp.nextInt();
		switch(userChoice) {
		case 1:
			AppQuickSort.quickSort(appliedJobs, "companyName");
			break;
		case 2:
			AppQuickSort.quickSort(appliedJobs, "jobTitle");
			break;
		case 3:
			AppQuickSort.quickSort(appliedJobs, "appliedDate");
			break;
		}
		
		if(!appliedJobs.isEmpty()) {
			for(int i =0; i<appliedJobs.getCurrentSize(); i++) {
				System.out.println(appliedJobs.get(i)+"\n");
			}
		}else {
			System.out.println(sessionUser.getFirstName()+" didn't apply to any jobs");
		}
	}
	private static void listApplications(AppBag<JobApplication> jobs) {
		if(!jobs.isEmpty()) {
			for(int i =0; i<jobs.getCurrentSize(); i++) {
				System.out.println(jobs.get(i)+"\n");
			}
		}else {
			System.out.println(sessionUser.getFirstName()+" didn't apply to searched jobs");
		}
	}

	private static void setObjectDataToJobs() {
		// TODO Auto-generated method stub
		List<Integer> jobIds = sessionUser.getApplicationIds();
		for(int i=0; i<jobIds.size(); i++) {
			JobApplication job = jobHandler.getJobApplication(jobIds.get(i));
			appliedJobs.add(job);
		}
		
		List<Integer> resumeIds = sessionUser.getResumeIDs();
		for(int i=0; i<resumeIds.size();i++) {
			JobDocument doc = docHandler.getDocument(resumeIds.get(i));
			userDocs.add(doc);
		}
		
		List<Integer> coverLetterIds = sessionUser.getCoverLetterIDs();
		for(int i=0; i<coverLetterIds.size(); i++) {
			JobDocument doc = docHandler.getDocument(coverLetterIds.get(i));
			userDocs.add(doc);
		}
	}
}