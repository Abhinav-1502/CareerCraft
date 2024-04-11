package Models;

import java.util.Date;

import MyCollections.AppArray;
import MyCollections.AppBag;

public class JobApplication {
	private int applicatinID;
	private String companyName;
	private String jobTitle;
	private Date appliedDate;
	private String applicationStatus;
	private AppBag<Schedule> interviews;
	private AppBag<JobDocument> attachedDocs;
		
	//Creates a job application instance with random applicationID which is not equal to any existing IDs.
	public JobApplication() {
		// invoke a function which returns random number for ID, which is not already in DB
	}
	
	// Creates job application class instance with all the given data
	public JobApplication(int applicationID, String companyName, String jobTitle, Date appliedDate, String applicationStatus ) {
		applicationID = applicationID;
		companyName = companyName;
		jobTitle = jobTitle;
		appliedDate = appliedDate;
		applicationStatus= applicationStatus;
	}
	
	/**Sets the company name for the job application instance
	 * @param String representing the company name
	 * */
	public void setCompanyName(String companyName) {
		companyName = companyName;
	}
	
	/**Sets the jobTitle name for the job application instance
	 * @param String representing the job title 
	 * */
	public void setJobTitle(String jobTitle) {
		jobTitle = jobTitle;
	}
	
	/**Sets the applied date for the job application instance
	 * @param Date object representing the applied date
	 * */
	public void setAppliedDate(Date appliedDate) {
		appliedDate = appliedDate;
	}
	
	/**Sets the applicationStatus for the job application instance
	 * @param String representing the applicationStatus
	 * */
	public void setApplicationStatus(String applicationStatus) {
		applicationStatus = applicationStatus;
	}
	
	
	/**Adds the interview to for the job application instance
	 * @param Schedule object representing the interview
	 * @return True if adding was successful, and false if not
	 * */
	public boolean addInterview(Schedule interview) {
		return interviews.add(interview);
	}
	
	/**removes the interview from the job application instance
	 * @param Schedule object representing the interview
	 * @return True if removing was successful, and false if not
	 * */
	public boolean removeInterview(Schedule interview) {
		return interviews.remove(interview);
	}
	
	/**Adds the document to for the job application instance
	 * @param JobDocument object representing the document
	 * @return True if adding was successful, and false if not
	 * */
	public void addDocument(JobDocument doc) {
		attachedDocs.add(doc);
	}
	
	/**removes the document from the job application instance
	 * @param JobDocument object representing the document
	 * @return True if adding was successful, and false if not
	 * */
	public void remove(JobDocument doc) {
		attachedDocs.add(doc);
	}
	
	/**Returns the company name from the job application instance
	 * @return String representing the company name
	 * */
	public String getCompanyName() {
		return companyName;
	} 
	
	/**Returns the job title from the job application instance
	 * @return String representing the job title
	 * */
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**Returns the applied date of the job application instance
	 * @return Date representing the applied date
	 * */
	public Date getAppliedDate() {
		return appliedDate;
	}
	
	/**Returns the application status of the job application instance
	 * @return String representing the status of job application
	 * */
	public String getStatus() {
		return applicationStatus;
	}
	
	/**Returns the company name from the job application instance
	 * @return String representing all the schedules interview
	 * */
	public String getAllInterview() {
		return interviews.toString();
	}
}
  