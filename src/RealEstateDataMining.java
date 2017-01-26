/**
 * @author Brett Allen, Jay Early, Antwan Wilson
 * @created 1/13/2017 at 12:32 PM
 * */

package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RealEstateDataMining extends Application{
	
	/**
	 * Setting the IDs and FXML file associations to be used in the controller classes
	 * All IDs and FXML file associations should be reference like so. This makes it easier
	 * to change IDs and associations in the future as the changes will only be required in
	 * these private static final variables
	 * */ 
	public static final String LOGIN_ID = "login";
	public static final String LOGIN_FILE = "Login.fxml";
	
	public static final String SIGN_UP_ID = "signUp";
	public static final String SIGN_UP_FILE = "SignUp.fxml";	
	
	public static final String MAIN_ID = "main";
	public static final String MAIN_FILE = "Main.fxml";	

	@Override
	public void start(Stage primaryStage) throws Exception {		
		ScreensController formsContainer = new ScreensController();	
		
		//Load in all the FXML files into a stack (hash table)
		formsContainer.loadScreen(LOGIN_ID, LOGIN_FILE);
		formsContainer.loadScreen(SIGN_UP_ID, SIGN_UP_FILE);
		formsContainer.loadScreen(MAIN_ID, MAIN_FILE);
		
		//Load the login screen
		formsContainer.setScreen(LOGIN_ID);
		
		Group root = new Group();
        root.getChildren().addAll(formsContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Real Estate Data Mining");
        primaryStage.setResizable(false);
        
        primaryStage.show();
	}	
	
	/**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		launch(args);
	}
}