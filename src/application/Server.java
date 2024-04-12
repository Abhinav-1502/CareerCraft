package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.client.MongoDatabase;

import DataHandlers.DbConnection;
import Models.JobApplication;
import Models.User;
import MyCollections.AppArray;
import MyCollections.AppBag;
import Pages.LoginPage;

public class Server {
	private DbConnection appToken;
	private MongoDatabase sessionDatabaseToken;
	
	public void startApp() {
		appToken = new DbConnection();
		sessionDatabaseToken = appToken.getDatabase();
		
		authenticateUser();
		appToken.endConnection();
	}
	
	private void authenticateUser() {
		LoginPage lp = new LoginPage(sessionDatabaseToken);
		Object getSession = LoginPage.start();
		if(getSession instanceof User) {
			goToDashboard();
		}
	}
	
	private void goToDashboard() {
		System.out.println("\nYou've been redirected to dashboard");
	}
	
	public static void main(String[] args) {
		Server sr = new Server();
		sr.startApp();
	}
	
}
