package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable, ControlledScreen{
	
	private ScreensController controller;
	
	private Customer customer;
	
	@FXML
	TextField txtHomePhone;
	
	/**
	 * Create a new instance of a customer and load it into the customer table of a database
	 * */
	public SignUpController() {
		System.out.println("An instance of the SignUpController has been created");	
		customer = new Customer();
	}

	@Override
	public void setScreenParent(ScreensController screenPage) {
		controller = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}	
	
	/**
	 * Go back to the login screen if the back button is pressed.
	 * 
	 * @param event the event handler of the calling widget
	 * */
	@FXML
	private void goBack(ActionEvent event){
		controller.setScreen(RealEstateDataMining.LOGIN_ID);
	}
	
	/**
	 * Setting a mask for the phone/fax number textfields
	 * */
	@FXML
	private void validatePhoneMask(){
		//TODO apply a mask for each of the text fields
	}
	
}