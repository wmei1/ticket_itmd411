package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import models.LoginModel;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {
	@FXML
	private TextField username;
	@FXML
	private TextField password;

	// Event Listener on Button.onAction
	@FXML
	public void login(ActionEvent event) throws IOException {
		// TODO Autogenerated
		String username = this.username.getText();
		String password = this.password.getText();
		
		LoginModel l= new LoginModel();
		/*
		boolean blnUser = l.findByUser(username);
		l.close()
		
		if (blnUser == false){
			System.out.println("Username cannot be found");
			return;
		}
		try{
			
			
		}
		*/
	}
}