module CareerCraft {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires org.mongodb.driver.core;
	requires org.mongodb.bson;
	requires org.mongodb.driver.sync.client;
	
	opens application to javafx.graphics, javafx.fxml;
}
