package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import algorithms.FIFO;
import algorithms.LRU;
import algorithms.OPR;
import algorithms.PRAlgorithm;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainScreenController implements Initializable{
	
	public static String sort;
	PRAlgorithm algo;
	Stage stage;
	private String currentAlgo;
	private String[] algoList = {"First In First Out (FIFO)","Least Recently Used (LRU)","Optimal Page Replacement"};
	private int[] pageReferences;
	private int frameSize;
	
	
	@FXML
    private TextArea pageFaultArea;
	
	@FXML
	private ChoiceBox<String> algoChoiceBox;
	
	@FXML
	private Pane mainPane;
	
	@FXML
    private TextField noFramesField;

    @FXML
    private TextField pageReferencesField;
	
    @FXML
    private Button exitButton;

    @FXML
    private Button helpButton;

    @FXML
    private BorderPane myborderpane;

    @FXML
    private Button startButton;


    @FXML
    void exitButtonPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout!");
		alert.setContentText("See you next time  !!!");
		
		if(alert.showAndWait().get() == ButtonType.OK){
		stage = (Stage) myborderpane.getScene().getWindow();
			stage.close();}
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
    	new HelpController();
    }


    @FXML
    void startButtonPressed(ActionEvent event) {
    	mainPane.getChildren().clear();
    	
    	Label PFLabel = new Label("Page Frames");
    	PFLabel.setLayoutX(-30); PFLabel.setLayoutY(150); 
    	PFLabel.setRotate(90);
    	PFLabel.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
    	mainPane.getChildren().add(PFLabel);
    	
    	currentAlgo = algoChoiceBox.getValue();
    	frameSize = Integer.parseInt(noFramesField.getText()); 
    	String strPR = pageReferencesField.getText().trim();
    	String[] PRArray = strPR.split(",");
    	
    	try {
    		pageReferences = new int[PRArray.length];
    		for (int i = 0; i < PRArray.length; i++) {
    			pageReferences[i] = Integer.parseInt(PRArray[i].trim());
    		}
    		
    		if (currentAlgo.equals("First In First Out (FIFO)")) {
    			algo = new FIFO(pageReferences, frameSize, mainPane);
    		}
    		else if (currentAlgo.equals("Least Recently Used (LRU)")) {
    			algo = new LRU(pageReferences, frameSize, mainPane);
    		}
    		else if (currentAlgo.equals("Optimal Page Replacement")) {
    			algo = new OPR(pageReferences, frameSize, mainPane);
    		}
    		else {
    			throw new Exception("Please choose an algorithm to begin");
    		}
    		
    		
    		
    		int pageFault = algo.pageFaults();
    		pageFaultArea.setText("Total Page Faults = " + pageFault);
    		
			
    	} catch (Exception e) {
    		Alert input_error = new Alert(AlertType.ERROR);
    		input_error.setTitle("ERROR");
    		input_error.setHeaderText("Invalid input");
    		input_error.setContentText(e.getMessage());
    		input_error.show();
    		e.printStackTrace();
    	}
		
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		algoChoiceBox.getItems().addAll(algoList);
		algoChoiceBox.setOnAction(this::getAlgo);
		Label PFLabel = new Label("Page Frames");
    	PFLabel.setLayoutX(-30); PFLabel.setLayoutY(150); 
    	PFLabel.setRotate(90);
    	PFLabel.setFont(Font.font("verdana", FontPosture.REGULAR, 20));
    	mainPane.getChildren().add(PFLabel);
		
	}
	
	public String getAlgo(ActionEvent event) {
		return algoChoiceBox.getValue();
	}
		
	}

   






