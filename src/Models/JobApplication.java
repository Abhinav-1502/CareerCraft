package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

import MyCollections.AppArray;
import MyCollections.AppBag;

public class JobApplication {
	private int applicationID;
	private String companyName;
	private String jobTitle;
	private Date appliedDate;
	private String applicationStatus;
	private AppBag<Schedule> schedules;
	private AppBag<JobDocument> attachedDocs;
		
	//Creates a job application instance with random applicationID which is not equal to any existing IDs.
	public JobApplication() {
		// invoke a function which returns random number for ID, which is not already in DB
	}
	
	// Creates job application class instance with all the given data
	public JobApplication(int applicationID, String companyName, String jobTitle, Date appliedDate, String applicationStatus ) {
		this.applicationID = applicationID;
		this.companyName = companyName;
		this.jobTitle = jobTitle;
		this.appliedDate = appliedDate;
		this.applicationStatus= applicationStatus;
		schedules = new AppArray<>();
		attachedDocs = new AppArray<>();
	}
	
	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
	
	/**Sets the company name for the job application instance
	 * @param String representing the company name
	 * */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**Sets the jobTitle name for the job application instance
	 * @param String representing the job title 
	 * */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**Sets the applied date for the job application instance
	 * @param Date object representing the applied date
	 * */
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	
	/**Sets the applicationStatus for the job application instance
	 * @param String representing the applicationStatus
	 * */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	
	
	/**Adds a schedule  for the job application instance
	 * @param Schedule object representing the schedule, it can be an interview, follow up or even an email
	 * @return True if adding was successful, and false if not
	 * */
	public boolean addSchedule(Schedule schedule) {
		return schedules.add(schedule);
	}
	
	/**removes the interview from the job application instance
	 * @param Schedule object representing the schedule
	 * @return True if removing was successful, and false if not
	 * */
	public boolean removeSchedule(Schedule schedule) {
		return schedules.remove(schedule);
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
	public String getAllSchedules() {
		return schedules.toString();
	}

	@Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(appliedDate);

        StringBuilder sb = new StringBuilder();
        sb.append("Company Name: ").append(companyName).append("\n");
        sb.append("Job Title: ").append(jobTitle).append("\n");
        sb.append("Applied Date: ").append(formattedDate).append("\n");
        sb.append("Status: ").append(applicationStatus).append("\n");

        // Append schedules
        sb.append("Schedules:\n");
        sb.append(schedules.toString()).append("\n");

        // Append attached documents
        sb.append("Attached Documents:\n");
        sb.append(attachedDocs.toString());

        return sb.toString();
    }
}
  