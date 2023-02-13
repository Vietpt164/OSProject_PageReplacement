package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScreenController {
	@FXML
	BorderPane myborderpane;
	@FXML
	MenuBar mymenubar;
	@FXML
	Menu myhelpmenu;
	@FXML
	public static Pane mypane1;
	@FXML
	Pane mypane2;
	@FXML
	Button logout;
	@FXML
	VBox myvbox;
	@FXML
	MenuItem helpmenuitem;
	
	Stage stage;
	
	@FXML
	public void exitButtonPressed(ActionEvent event){	
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Quit");
		alert.setHeaderText("You're about to exit!");
		alert.setContentText("Do you want to save before exiting?: ");
		
		if(alert.showAndWait().get() == ButtonType.OK){
		stage = (Stage) myborderpane.getScene().getWindow();
			stage.close();}
		}
	public void btnHelpPressed(ActionEvent event) {
		new HelpController();
	}
	@FXML
	public void mergesortPressed(ActionEvent event) {
		SortAlgoController.sort = "MergeSort" ;
		try {
		
			final String CART_FXML_FILE_PATH = "/screens/SortAlgoScreen.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
			fxmlLoader.setController(new SortAlgoController());
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.centerOnScreen();
			stage.setTitle("Sorting Algorithm");
			
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void radixsortPressed(ActionEvent event) {
		SortAlgoController.sort = "RadixSort" ;
		try {
			final String CART_FXML_FILE_PATH = "/screens/SortAlgoScreen.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
			fxmlLoader.setController(new SortAlgoController());
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.centerOnScreen();
			stage.setTitle("Sorting Algorithm");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public void countingsortPressed(ActionEvent event) {
		SortAlgoController.sort = "CountingSort" ;
		try {
			final String CART_FXML_FILE_PATH = "/screens/SortAlgoScreen.fxml";
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
			fxmlLoader.setController(new SortAlgoController());
			Parent root = fxmlLoader.load();
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.centerOnScreen();
			stage.setTitle("Sorting Algorithm");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}

