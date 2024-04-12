package Models;

import java.util.ArrayList;
import java.util.List;

import MyCollections.AppArray;
import MyCollections.AppBag;

public class User {
	//Authentication level
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String username;
	private String password;
	private String securityQuestion;
	private String answer;
	
	//Application level;
	private AppBag<JobApplication> JobApplications;
	private AppBag<Schedule> Schedules;
	private AppBag<JobDocument> Resumes;
	private AppBag<JobDocument> CoverLetters;
	
	public User() {
		//Invoke a function where it generates a random userID and sets it
		JobApplications = new AppArray<>();
		Resumes = new AppArray<>();
		CoverLetters = new AppArray<>();
		Schedules = new AppArray<>();
	}
	
	public User(int userID, String firstName, String lastName, String email, String username, String password, String SecurityQuestion, String answer) {
		this.setUserID(userID);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.securityQuestion = SecurityQuestion;
		this.answer = answer;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	// Getter and setter for firstName
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for lastName
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName() {
    	return this.firstName +" "+ this.lastName;
    }

    // Getter and setter for email
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username.
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    /**
     * Sets the security question.
     * @param securityQuestion the security question to set
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }
    
    
    
 // Getter and setter for securityQuestion
    public String getSecurityQuestion() {
        return securityQuestion;
    }
    
    /**
     * Sets the answer.
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    // Getter and setter for answer
    public String getAnswer() {
        return answer;
    }
    
    /**
     * Add a job applicationID to user.
     * @param Job application object representing Job application ID
     */
    public void addJobApplication(JobApplication application) {
    	JobApplications.add(application);
    }
    
    /**
     * remove a job applicationID from user.
     * @return returns TRUE if removed, or false if failed.
     */
    public boolean removeJobApplication(JobApplication application) {
    	return JobApplications.remove(application);
    }
    
    public String getAllUsersApplications() {
    	return JobApplications.toString();
    }
    
    /**
     * Add a resume  to user.
     * @param Document object representing resume document
     */
    public void addResume(JobDocument resume) {
    	Resumes.add(resume);
    }
    
    /**
     * remove a resume from user.
     * @return returns TRUE if removed, or false if failed.
     */
    public boolean removeResume(JobDocument resume) {
    	return Resumes.remove(resume);
    }
    
    public String getAllUsersResumes() {
    	return Resumes.toString();
    }
    
    /**
     * Adds a cover letter to user.
     * @param JobDocument object representing cover letter
     */
    public void addCoverLetter(JobDocument coverLetter) {
    	CoverLetters.add(coverLetter);
    }
    
    /**
     * remove a cover letter from user.
     * @return returns TRUE if removed, or false if failed.
     */
    public boolean removeCoverLetter(JobDocument coverLetter) {
    	return CoverLetters.remove(coverLetter);
    }
    
    public String getAllCoverLetters() {
    	return CoverLetters.toString();
    }
    
    /**
     * Adds a schedules to user.
     * @param JobDocument object representing cover letter
     */
    public void addSchedule(Schedule schedule) {
    	Schedules.add(schedule);
    }
    
    /**
     * remove a schedules from user.
     * @return returns TRUE if removed, or false if failed.
     */
    public boolean removeSchedule(Schedule schedule) {
    	return Schedules.remove(schedule);
    }
    
    public String getAllSchedules() {
    	return Schedules.toString();
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Integer> getApplicationIds(){
		List<Integer> IDs = new ArrayList<>();
		if(this.JobApplications.isEmpty()) {
			return IDs;
		}
		Object[] JobAppsArr = this.JobApplications.toArray();
		for(int i=0; i<=JobAppsArr.length; i++) {
			JobApplication jobApp = (JobApplication) JobAppsArr[i];
			IDs.add(jobApp.getApplicationID());
		}
		return IDs;
	}	
	
	public List<Integer> getScheduleIDs(){
		List<Integer> IDs = new ArrayList<>();
		if(this.Schedules.isEmpty()) {
			return IDs;
		}
		Object[] scheduleArr = this.Schedules.toArray();
		for(int i=0; i<=scheduleArr.length; i++) {
			Schedule sched = (Schedule) scheduleArr[i];
			IDs.add(sched.getScheduleID());
		}
		return IDs;
	}
	
	public List<Integer> getResumeIDs(){
		List<Integer> IDs = new ArrayList<>();
		if(this.Resumes.isEmpty()) {
			return IDs;
		}
		Object[] resumes = this.Resumes.toArray();
		for(int i=0; i<=resumes.length; i++) {
			JobDocument jd = (JobDocument) resumes[i];
			IDs.add(jd.getDocumentID());
		}
		return IDs;
	}
	
	public List<Integer> getCoverLetterIDs(){
		List<Integer> IDs = new ArrayList<>();
		if(this.CoverLetters.isEmpty()) {
			return IDs;
		}
		Object[] CVs = this.CoverLetters.toArray();
		for(int i=0; i<=CVs.length; i++) {
			JobDocument jd = (JobDocument) CVs[i];
			IDs.add(jd.getDocumentID());
		}
		return IDs;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder("\n");
	        sb.append("Full Name: ").append(firstName).append(" ").append(lastName).append("\n");
	        sb.append("Email: ").append(email).append("\n");
	        sb.append("Phone: ").append(phone).append("\n");
	        sb.append("Username: ").append(username).append("\n");
	        sb.append("Job Applications: ").append(JobApplications.toString()).append("\n");
	        sb.append("Schedules: ").append(Schedules.toString()).append("\n");
	        sb.append("Resumes: ").append(Resumes.toString()).append("\n");
	        sb.append("Cover Letters: ").append(CoverLetters.toString()).append("\n");

	        return sb.toString();
	    }
}