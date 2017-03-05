package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MainController implements Initializable, ControlledScreen{

	private ScreensController controller;
	
	private Customer customer;
	
	private boolean isUpdated = false;
	
	@FXML
	private Button btnLogOut;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtFirstName;
	
	@FXML
	private TextField txtLastName;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtStreetAddress;
	
	@FXML
	private TextField txtCity;
	
	@FXML
	private TextField txtHomePhone;
	
	@FXML
	private TextField txtMobilePhone;
	
	@FXML
	private TextField txtWorkPhone;
	
	@FXML
	private TextField txtFaxNumber;
	
	@FXML
	private CheckBox cbxEditFields;
	
	@FXML
	private ComboBox<String> cboTimeZone;
	
	@FXML
	private ComboBox<String> cboFormat;
	
	@FXML
	private ComboBox<String> cboState;
	
	@FXML
	private ComboBox<String> cboCountry;
	
	public MainController(){
		System.out.println("MainController loaded.");		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cboTimeZone.getItems().addAll("Eastern", "Central", "Mountain", "Pacific");
		cboTimeZone.getSelectionModel().select(0);
		
		cboState.getItems().addAll("Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
								   "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
								   "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
								   "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
								   "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
		cboState.getSelectionModel().select("Maryland");
	}
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		controller = screenPage;		
	}		
	
	/**
	 * Go back to the login screen once the back button is pressed
	 * 
	 * @param event the raised by the calling widget
	 * */
	@FXML
	private void backToLogin(ActionEvent event){
		customer.reset();
		
		controller.setScreen(RealEstateDataMining.LOGIN_ID);
		System.out.println("Customer logged out");
	}	
	
	/**
	 * Loads customer data into the designated text fields once the screen is visible
	 * 
	 * @param event the raised by the calling widget
	 * */
	@FXML
	private void loadCustomerData(){
		//Load in customer data
		if(!isUpdated){
			customer = controller.getCustomer();
			
			txtUsername.setText(customer.getUsername());
			txtFirstName.setText(customer.getFirstName());
			txtLastName.setText(customer.getLastName());				
			
			txtEmail.setText(customer.getEmail());
			
			txtStreetAddress.setText(customer.getStreetAddress());
			txtCity.setText(customer.getCity());
			
			txtHomePhone.setText(customer.getHomePhone());
			txtMobilePhone.setText(customer.getMobilePhone());
			txtWorkPhone.setText(customer.getWorkPhone());
			txtFaxNumber.setText(customer.getFaxNumber());
			
			toggleTextFieldColors();
			
			isUpdated = true;
		}
	}
	
	/**
	 * Toggles the color of the text fields based on the selected state of the edit-fields checkbox
	 * */
	private void toggleTextFieldColors(){	
		
		//Gray if false; white if true
		String[] grayscale = {"-fx-control-inner-background: #cccccc;", "-fx-control-inner-background: #ffffff;"};
		int color = cbxEditFields.isSelected() ? 1 : 0;
		
		txtUsername.setStyle(grayscale[color]);
		txtFirstName.setStyle(grayscale[color]);
		txtLastName.setStyle(grayscale[color]);
		txtEmail.setStyle(grayscale[color]);
		txtStreetAddress.setStyle(grayscale[color]);
		txtCity.setStyle(grayscale[color]);
		txtHomePhone.setStyle(grayscale[color]);
		txtMobilePhone.setStyle(grayscale[color]);
		txtWorkPhone.setStyle(grayscale[color]);
		txtFaxNumber.setStyle(grayscale[color]);
	}
	
	/**
	 * Updates the changes that are applied by the user if the user prefers to adjust their
	 * account information and save it to the database
	 * 
	 * @param event the raised by the calling widget
	 * */
	@FXML
	private void updateChanges(ActionEvent event){
		System.out.println("Changes Updated.");
	}
	
	/**
	 * Gives the user the option to make changes to their account. This provides a means of
	 * saving a search query
	 * 
	 * @param event the raised by the calling widget
	 * */
	@FXML
	private void editPreloadedFields(ActionEvent event){
		
		toggleTextFieldColors();
		
		txtUsername.setEditable(cbxEditFields.isSelected());
		txtFirstName.setEditable(cbxEditFields.isSelected());
		txtLastName.setEditable(cbxEditFields.isSelected());
		txtEmail.setEditable(cbxEditFields.isSelected());
		txtStreetAddress.setEditable(cbxEditFields.isSelected());
		txtCity.setEditable(cbxEditFields.isSelected());
		txtHomePhone.setEditable(cbxEditFields.isSelected());
		txtMobilePhone.setEditable(cbxEditFields.isSelected());
		txtWorkPhone.setEditable(cbxEditFields.isSelected());
		txtFaxNumber.setEditable(cbxEditFields.isSelected());
	}	
}