package controller;

import java.io.IOException;
import java.util.Random;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.stage.Stage;
import javafx.util.Duration;
import sortingalgorithms.CountingSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.RadixSort;
import sortingalgorithms.SortingAlgo;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SortAlgoController {
	
	SortingAlgo sortingAlgo;
	public static String sort;
	Stage stage;

    @FXML
    private TextField array_text_field;

    @FXML
    private Label arraylengthtext;

    @FXML
    private Label arraylengthtext1;

    @FXML
    private Label arraytext;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button finishButton;

    @FXML
    private Button helpButton;

    @FXML
    private TextArea instructfield;

    @FXML
    private BorderPane myborderpane;

    @FXML
    private Pane mypane1;

    @FXML
    private Pane mypane2;

    @FXML
    private VBox myvbox1;

    @FXML
    private Button nextButton;

    @FXML
    private Button previousButton;

    @FXML
    private ToggleGroup random;

    @FXML
    private RadioButton randomButton;

    @FXML
    private Button resetButton;

    @FXML
    private RadioButton selfCreateButton;

    @FXML
    private Button startButton;
    
    @FXML
    private Label stepLabel;
    
    @FXML
    private Button runButton;
    
    @FXML
    private Button stopButton;
	
    private boolean runFlag = true;

    @FXML
    void backBtnPressed(ActionEvent event) {
    	try {
			Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/screens/MainScreen.fxml"));
			loader.setController(new MainScreenController());
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setTitle("Sorting Visualization");
			stage.setScene(scene);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

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
    void finishButtonPressed(ActionEvent event) {
    	sortingAlgo.displaySortedArray();
		stepLabel.setText("" + sortingAlgo.getCurr_step() + "/" + sortingAlgo.getTotal_step());
    }

    @FXML
    void helpButtonPressed(ActionEvent event) {
    	new HelpController();
    }

    @FXML
    void nextButtonPressed(ActionEvent event) {
    	sortingAlgo.nextStep();
    	stepLabel.setText("" + sortingAlgo.getCurr_step() + "/" + sortingAlgo.getTotal_step());
    }

    @FXML
    void previousButtonPressed(ActionEvent event) {
    	sortingAlgo.previousStep();
		stepLabel.setText("" + sortingAlgo.getCurr_step() + "/" + sortingAlgo.getTotal_step());
	}
    

    @FXML
    void resetButtonPressed(ActionEvent event) {
    	sortingAlgo.displayInitialArray();
		stepLabel.setText("" + sortingAlgo.getCurr_step() + "/" + sortingAlgo.getTotal_step());
		runFlag = false;
    }

    @FXML
    void startButtonPressed(ActionEvent event) {
    	int[] array= new int[8];
    	try {
		
			if (selfCreateButton.isSelected()) {
				String db = array_text_field.getText().trim();
				if (db.isEmpty()) {
					throw new NullPointerException("Please input your array to start the visualization");
				}
				String[] strArray = db.split(",");
				
				
				for (int i = 0; i < strArray.length ; i++) {
					try {
						array[i] = Integer.parseInt(strArray[i].trim());
						if (array[i] < 0)
							throw new NumberFormatException("Array element have to be non-negative");
					} catch (NumberFormatException e) {
						throw e;
					}
				}
				
				if (sort.equals("CountingSort")) {
					for (int i = 0; i < strArray.length ; i++) {
						try {
							array[i] = Integer.parseInt(strArray[i].trim());
							if (array[i] > 9)
								throw new NumberFormatException("Array element have to be less than or equals 9");
						} catch (NumberFormatException e) {
							throw e;
						}
					}
					
				}
				
				if (strArray.length != 8) {
					throw new Exception("Please input an array of size 8");
				}
				
				
			} else if (randomButton.isSelected()) {
				Random rand = new Random();
				for (int i = 0; i < 8; i++) {
					if (sort.equals("RadixSort")) {
						array[i] = rand.nextInt(10000);
					} else if (sort.equals("MergeSort")) {
						array[i] = rand.nextInt(100);
					} else if (sort.equals("CountingSort")){
						array[i] = rand.nextInt(10);
					}
				}
			}
			
			if (sort == "RadixSort") {
				sortingAlgo = new RadixSort(array,mypane1,instructfield, stepLabel);
				instructfield.setText("Count sorting the first time !!!!");
				stepLabel.setText(1 + "/" + sortingAlgo.getTotal_step());
			} else if (sort == "MergeSort") {
				sortingAlgo = new MergeSort(array,mypane1,instructfield);
			} else {
				sortingAlgo = new CountingSort(array,mypane1,instructfield, stepLabel);
			}
			
			stepLabel.setText("" + (sortingAlgo.getCurr_step()+1)  + "/" + sortingAlgo.getTotal_step());
			sortingAlgo.displayInitialArray();
    	} catch (Exception e) {
    		Alert input_error = new Alert(AlertType.ERROR);
    		input_error.setTitle("ERROR");
    		input_error.setHeaderText("Invalid input array");
    		input_error.setContentText(e.getMessage());
    		input_error.show();
    		e.printStackTrace();
    	}
		
    }
    
    @FXML
    void runButtonPressed(ActionEvent event) {
		if (sortingAlgo.getCurr_step() == sortingAlgo.getTotal_step()) {
			sortingAlgo.displaySortedArray();
			return;
		}
		if (!runFlag) {
			runFlag = true;
			return;
		}
		nextButtonPressed(new ActionEvent());
		Circle s = new Circle(0, 0, 3);
		s.setFill(Color.WHITE);
		s.setStroke(Color.WHITE);
		mypane1.getChildren().add(s);

		Path path = new Path();
		path.getElements().add(new MoveTo(0, 0));
		path.getElements().add(new LineTo(mypane1.getWidth(), 0));

		PathTransition delay = new PathTransition();
		delay.setDelay(Duration.seconds(0));
		delay.setDuration(Duration.seconds(0.5));
		delay.setNode(s);
		delay.setPath(path);
		delay.setOnFinished((EventHandler<ActionEvent>)new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent actionEvent) {
				runButtonPressed(new ActionEvent());
			}
		});
		delay.play();
	}
    
    @FXML
    void stopButtonPressed(ActionEvent event) {
    	runFlag = false;
    }

   

}




