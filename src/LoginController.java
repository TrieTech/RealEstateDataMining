package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class LoginController implements Initializable, ControlledScreen{
	
	//Protected to share with extended forms
	private static final String USERNAME = "username";
	private static final String EMAIL = "johndoe@example.com";
	private static final String PASSWORD = "password";
	
	private ScreensController controller;
	
	@FXML
	private TextField txtUser;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private Button btnExit;
	
	@FXML
	private Hyperlink hlkForgotPassword;
	
	@FXML
	private Hyperlink hlkSignUp;
	
	@FXML
	private Hyperlink hlkGuest;
	
	@FXML
	private Label lblErrorMsg;
	
	/**
	 * The customer that will be passed/shared across all controller forms
	 * When logging in, the customer should be validated against customers within the
	 * customer table of a database
	 * */
	private Customer customer;
	
	public LoginController() {
		System.out.println("LoginController loaded.");		
		customer = new Customer();
	}

	private boolean isValidUser(){
		return (txtUser.getText().equals(EMAIL) || txtUser.getText().equals(USERNAME)) && txtPassword.getText().equals(PASSWORD);
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		controller = screenPage;		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}	
	
	/**
	 * Called by the login button
	 * Validates the user-name and password to a database
	 * 
	 * @param event the event raised by the calling widget
	 * */
	@FXML
	private void login(ActionEvent event){
		if(txtUser.getText().isEmpty() && txtPassword.getText().isEmpty()){
			System.err.println("Must enter a username or email, and a password.");
			lblErrorMsg.setText("Must enter a username or email, and a password.");
		}else if(txtUser.getText().isEmpty() ^ txtPassword.getText().isEmpty()){
			if(txtUser.getText().isEmpty()){
				System.err.println("Must enter a username or email.");
				lblErrorMsg.setText("Must enter a username or email.");
			}else{
				System.err.println("Must enter a password.");
				lblErrorMsg.setText("Must enter a password.");
			}
		}else{
			if(isValidUser()){			
				
				//Set the email and password to be accessible from the other forms
				customer.setEmail(EMAIL);
				customer.setUsername(USERNAME);
				customer.setPassword(txtPassword.getText());
				
				System.out.println("User logged in...");
				lblErrorMsg.setText("");
				
				txtUser.clear();
				txtPassword.clear();
				
				//Pass the customer to the controller so other forms can use the customer's information
				controller.updateCustomer(customer);				
				
				//Load the Main GUI				
				controller.setScreen(RealEstateDataMining.MAIN_ID);				
				
			}else{
				if(!txtUser.getText().equals(EMAIL) && !txtUser.getText().equals(USERNAME)){
					System.err.println("Invalid username or email.");
					lblErrorMsg.setText("Invalid username or email.");	
					
					txtUser.clear();
					txtPassword.clear();
					
					return;
				}
				
				if(!txtUser.getText().equals(PASSWORD)){
					System.err.println("Invalid password.");
					lblErrorMsg.setText("Invalid password.");
					
					shake(txtPassword);
					txtPassword.clear();
				}				
			}
		}
	}
	
	/**
	 * 
	 * */
	@FXML
	private void enter(KeyEvent event){
		if(event.getCode().toString() == "ENTER"){
			login(null);
		}
	}
	
	/**
	 * Applies a shake animation to a given node (meant to be validated text fields)
	 * 
	 * @param node the widget that the shake animation is to be applied to
	 * */
	private void shake(Node node){
		long transRate = 50; //50
		float transOffset = 10f; //10f
		int cycleCount = 6; //6
		
		TranslateTransition transition = new TranslateTransition(Duration.millis(transRate), node); 
		
		transition.setByX(transOffset);
		transition.setCycleCount(cycleCount); 
		transition.setAutoReverse(true);
		transition.playFromStart();
	}
	
	/**
	 * Go to the sign up page if the sign-up hyper-link is clicked
	 * 
	 * @param event the event handler for the calling widget
	 * */
	@FXML
	private void signUp(ActionEvent event){		
		controller.setScreen(RealEstateDataMining.SIGN_UP_ID);
	}
	
	/**
	 * Exit the program if the exit button is clicked
	 * 
	 * @param event the event handler for the calling widget
	 * */
	@FXML
	private void exit(ActionEvent event){
		System.out.println("Exiting...");
		System.exit(0);
	}
}