package Models;

import MyCollections.AppArray;
import MyCollections.AppBag;

public class User {
	//Authentication level
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private String securityQuestion;
	private String answer;
	
	//Application level;
	private AppBag<JobApplication> JobApplications ;
	private AppBag<JobDocument> Resumes;
	private AppBag<JobDocument> CoverLetters;
	
	public User() {
		//Invoke a function where it generates a random userID and sets it 
	}
	
	public User(String firstName, String lastName, String email, String username, String password, String SecurityQuestion, String answer) {
		firstName = firstName;
		lastName = lastName;
		email = email;
		username = username;
		password = password;
		SecurityQuestion = SecurityQuestion;
		answer = answer;
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

    // Getter and setter for securityQuestion
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * Sets the security question.
     * @param securityQuestion the security question to set
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    // Getter and setter for answer
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer.
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
