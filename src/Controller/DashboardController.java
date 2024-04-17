package Controller;

import com.mongodb.client.MongoDatabase;

import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController {
	private static User sessionUser;
	private static MongoDatabase sessionDb;
	
	public void initialize(User user, MongoDatabase db){
		sessionUser = user;
		sessionDb = db;
		sessionUserLabel.setText(sessionUser.getFirstName());
		
		System.out.println("\n User Details"+ sessionUser);
	}
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="accountBtn"
    private Button accountBtn; // Value injected by FXMLLoader

    @FXML // fx:id="applicationsBtn"
    private Button applicationsBtn; // Value injected by FXMLLoader

    @FXML // fx:id="documentsBtn"
    private Button documentsBtn; // Value injected by FXMLLoader

    @FXML // fx:id="schedulesBtn"
    private Button schedulesBtn; // Value injected by FXMLLoader

    @FXML // fx:id="sessionUserLabel"
    private Label sessionUserLabel; // Value injected by FXMLLoader
    
    @FXML
    private Button logoutBtn;

    @FXML
    void openAccount(ActionEvent event) {
    	accountBtn.getScene().getWindow().hide();
    	Stage stage = new Stage();
    	try {
    		FXMLLoader fxmlloader = new FXMLLoader();
    		fxmlloader.setLocation(getClass().getResource("/FXML/Account.fxml"));
    		
    		Parent root = fxmlloader.load();
    		
    		//Load Controller and initialize sessionUser and MongoDB database
    		
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void logoutUser(ActionEvent event) {
    	logoutBtn.getScene().getWindow().hide();
    	Stage stage = new Stage();
    	try {
			FXMLLoader fxmlloader = new FXMLLoader();
			fxmlloader.setLocation(getClass().getResource("/fxml/LoginPage.fxml"));
			
			Parent root = fxmlloader.load();
			
			LoginController loginController = fxmlloader.getController();
			
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void openApplications(ActionEvent event) {
    	applicationsBtn.getScene().getWindow().hide();
    	Stage stage = new Stage();
    	try {
    		FXMLLoader fxmlloader = new FXMLLoader();
    		fxmlloader.setLocation(getClass().getResource("/FXML/Applications.fxml"));
    		
    		Parent root = fxmlloader.load();
    		
    		//Load Controller and initialize sessionUser and MongoDB database
    		ApplicationsController appCont = fxmlloader.getController();
    		appCont.start(sessionUser, sessionDb);
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    @FXML
    void openDocuments(ActionEvent event) {
    	documentsBtn.getScene().getWindow().hide();
    	Stage stage = new Stage();
    	try {
    		FXMLLoader fxmlloader = new FXMLLoader();
    		fxmlloader.setLocation(getClass().getResource("/FXML/Documents.fxml"));
    		
    		Parent root = fxmlloader.load();
    		
    		//Load Controller and initialize sessionUser and MongoDB database
    		DocumentController docController = fxmlloader.getController();
    		docController.start(sessionUser, sessionDb);
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    @FXML
    void openSchedules(ActionEvent event) {
    	schedulesBtn.getScene().getWindow().hide();
    	Stage stage = new Stage();
    	try {
    		FXMLLoader fxmlloader = new FXMLLoader();
    		fxmlloader.setLocation(getClass().getResource("/FXML/Schedule.fxml"));
    		
    		Parent root = fxmlloader.load();
    		
    		//Load Controller and initialize sessionUser and MongoDB database
    		SchedulesController schedCont = fxmlloader.getController();
    		schedCont.start(sessionUser, sessionDb);
    		Scene scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert accountBtn != null : "fx:id=\"accountBtn\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert applicationsBtn != null : "fx:id=\"applicationsBtn\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert documentsBtn != null : "fx:id=\"documentsBtn\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert schedulesBtn != null : "fx:id=\"schedulesBtn\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert sessionUserLabel != null : "fx:id=\"sessionUserLabel\" was not injected: check your FXML file 'Dashboard.fxml'.";
        
    }
}
