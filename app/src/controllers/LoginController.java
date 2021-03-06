package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.LoginModel;
import objects.Users;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class LoginController extends ControllerHelper{
	public static Users currentUser;
	
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button login;
	@FXML
	private Button createUserButton;
	
	@FXML
	public void onEnter() throws IOException, NoSuchAlgorithmException{
		login();
	}
	@FXML
	public void login() throws IOException, NoSuchAlgorithmException {
		String username = this.username.getText();
		String password = this.password.getText();
		
		LoginModel l= new LoginModel();
		currentUser = l.getUserAccount(username);
		
		if (currentUser == null || !l.verifyUser(username,password)){
			System.out.println("Incorrect username or password");
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("Invalid username or password.");
			alert.showAndWait();
			return;
		}else{
			Stage stage = (Stage) login.getScene().getWindow();
			String view = "/views/MainView.fxml";
			changeScene(stage,view);
		}
	}
	
	@FXML
	public void createUser() {
		Stage stage = (Stage) createUserButton.getScene().getWindow();
		String view = "/views/UserView.fxml";
		changeScene(stage,view);
	}
}
