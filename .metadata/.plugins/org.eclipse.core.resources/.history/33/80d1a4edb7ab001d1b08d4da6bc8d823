package sortingalgorithms;

import elements.Square;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public abstract class SortingAlgo implements Visualizable {
	public static final int MAX_INPUT_SIZE = 1 << 28;
	protected int[] array_og;
	protected int[] array;
	protected int arr_length;
	protected int curr_step;
	protected int total_step;
	protected static Pane pane;
	protected static TextArea text_area;
	protected static Label lb;
	

	public int getCurr_step() {
		return curr_step;
	}

	public int getTotal_step() {
		return total_step;
	}

	public SortingAlgo(int[] input_array, Pane input_pane, TextArea input_progress_area) {
		array_og = input_array;
		arr_length = 8;
		pane = input_pane;
		text_area = input_progress_area;
		array = array_og.clone();
		Check_valid_value(input_array);
        isSuitableForInputSize(input_array.length);
	}
	
	public SortingAlgo(int[] input_array, Pane input_pane, TextArea input_progress_area, Label input_lb) {
		array_og = input_array;
		arr_length = 8;
		pane = input_pane;
		text_area = input_progress_area;
		array = array_og.clone();
		lb = input_lb;
		Check_valid_value(input_array);
        isSuitableForInputSize(input_array.length);
	}
	
	public static Square drawSquare(int value) {
		Square square = new Square(value);
		return square;
	}
	
	public void drawArray(int start, int end, double startX, double startY) {
		for (int i = start; i < end + 1; i++) {
			Square s;
			s = drawSquare(array[i]);
			s.setAxis(startX+65*i, startY);
			pane.getChildren().add(s);
		}
	}
	
	
	
	public void Check_valid_value(int[] elements) {
		int MAX_VALUE_TO_SORT = Integer.MAX_VALUE;
		int MIN_VALUE_TO_SORT = Integer.MIN_VALUE;
		for (int element : elements) {
		  if (element > MAX_VALUE_TO_SORT) {
		    throw new IllegalArgumentException(
			"Element " + element + " is greater than maximum " + MAX_VALUE_TO_SORT);
		  }
		  if (element < MIN_VALUE_TO_SORT) {
		    throw new IllegalArgumentException(
			"Element " + element + " is less than minimum " + MIN_VALUE_TO_SORT);
		  }
		}}

	public void isSuitableForInputSize(int size) {
		  if (size > MAX_INPUT_SIZE){
		    throw new IllegalArgumentException(
			"Too Much Values in Array.Please Try Again !");
		  };
	}
	
	
	
	
	
}