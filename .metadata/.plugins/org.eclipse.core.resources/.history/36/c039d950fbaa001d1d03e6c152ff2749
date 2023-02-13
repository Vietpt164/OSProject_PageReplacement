package screens;
import controller.MainScreenController;
import controller.SortAlgoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SortAlgoScreen extends Application{
	
	@Override
	public void start(Stage stage) {

	try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/screens/SortAlgoScreen.fxml"));
		loader.setController(new SortAlgoController());
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		 
		 
		stage.setOnCloseRequest(event -> {
			event.consume();
			logoutPressed(stage);	
		});stage.show();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
}	

public void logoutPressed(Stage stage){	
	
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Logout");
	alert.setHeaderText("You're about to logout!");
	alert.setContentText("See you next time !!!");
	
	if (alert.showAndWait().get() == ButtonType.OK){
		stage.close();
	} 
}
	public static void main(String[] args) {
		launch(args);
	}
}