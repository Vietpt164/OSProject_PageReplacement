package sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;

import elements.Square;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class MergeSort extends SortingAlgo{
	private int[] cloneArr;
	private double startX, startY;
	private double[][] steps;
	private Color[] initColor = {Color.LIGHTBLUE, Color.BLACK };
	private final String[] instructions;
	
	//exception's already in the parent class
	public MergeSort(int[] input_array, Pane inputPane, TextArea input_progress_area) {
		super(input_array, inputPane, input_progress_area);
		this.array = input_array;
        
		Check_valid_value(input_array);
		isSuitableForInputSize(input_array.length);
		steps = new double[6][160];
		this.startX = 0;
		this.startY = 60;
		cloneArr = array.clone();
		curr_step = total_step = 0;
		assignStep(0, arr_length - 1, pane.getWidth() / 2 - (arr_length/2) * 60, startY, 0, 0);
		//sort the array beforehand
		sort(0, arr_length - 1, startX, pane.getWidth(), startY); 
		
		instructions = new String[5];
		instructions[0] = "Split the selected array (green)\n(as evenly as possible)";
		instructions[1] = "Array of length 1 cannot be split,\nready for merge";
		instructions[2] = "Put the minimum\nof the two selected value (yellow)\ninto the sorted array";
		instructions[3] = "Left array is empty,\ncopy all values from the remaining array\ninto the sorted array";
		instructions[4] = "Right array is empty,\ncopy all values from the remaining array\ninto the sorted array";
	}

	private void merge(int left, int right, int mid, double midX, double leftOy, double leftLeftOx, double leftRightOx) {
		int[] tempArr = new int[right - left + 1];

		int left_index = left;
		int right_index = mid + 1;
		assignStep(left, right, midX, leftOy, 3, 2);

		for (int i = 0; i < (right - left + 1); ++i) {
			if (left_index > mid) {
				// all element from left array has been taken.
				tempArr[i] = this.array[right_index++];
				assignStep(-1, -1, leftRightOx, leftOy + 100, 3, 3);
				assignStep(-1, tempArr[i], midX + (i) * 60, leftOy, 2, 3);
				if (right_index < right + 1) {
					leftRightOx += 60;
					assignStep(-1, this.array[right_index], leftRightOx, leftOy + 100, 1, 3);
				}
			} else if (right_index > right) {
				// all element from right array has been taken.
				tempArr[i] = this.array[left_index++];
				assignStep(-1, -1, leftLeftOx, leftOy + 100, 3, 4);
				assignStep(-1, tempArr[i], midX + (i) * 60, leftOy, 2, 4);
				if (left_index < mid + 1) {
					leftLeftOx += 60;
					assignStep(-1, this.array[left_index], leftLeftOx, leftOy + 100, 1, 4);
				}
			} else if (this.array[left_index] < this.array[right_index]) {
				tempArr[i] = this.array[left_index++];
				assignStep(-1, -1, leftLeftOx, leftOy + 100, 3, 2);
				assignStep(-1, tempArr[i], midX + (i) * 60, leftOy, 2, 2);
				if (left_index < mid + 1) {
					leftLeftOx += 60;
					assignStep(-1, this.array[left_index], leftLeftOx, leftOy + 100, 1, 2);
				}
			} else if (this.array[left_index] >= this.array[right_index]) {
				tempArr[i] = this.array[right_index++];
				assignStep(-1, -1, leftRightOx, leftOy + 100, 3, 2);
				assignStep(-1, tempArr[i], midX + (i) * 60, leftOy, 2, 2);
				if (right_index < right + 1) {
					leftRightOx += 60;
					assignStep(-1, this.array[right_index], leftRightOx, leftOy + 100, 1, 2);
				}
			}
		}
		int j = 0;
		for (int i = left; i <= right; ++i)
			this.array[i] = tempArr[j++];

	}

	private void sort(int left, int right, double leftX, double rightX, double leftY) {
		if (left < right) {
			int mid = (left + right) / 2;
			double midX = (leftX + rightX) / 2;

			assignStep(left, right, midX - (right - left + 1) * 30, leftY, 4, 0);
			assignStep(left, mid, (leftX + midX) / 2 - (mid - left + 1) * 30, leftY + 100, 0, 0);
			assignStep(mid + 1, right, (midX + rightX) / 2 - (right - mid) * 30, leftY + 100, 0, 0);
			sort(left, mid, leftX, midX, leftY + 100);

			sort(mid + 1, right, midX, rightX, leftY + 100);
			double startLeftX = (leftX + midX) / 2 - (mid - left + 1) * 30;
			double startRightX = (midX + rightX) / 2 - (right - mid) * 30;
			
			// select and ready to merge
			assignStep(-1, this.array[left], startLeftX, leftY + 100, 1, 1); 
			assignStep(-1, this.array[mid + 1], startRightX, leftY + 100, 1, 1); 

			merge(left, right, mid, midX - (right - left + 1) * 30, leftY, startLeftX, startRightX);
		}
	}

	private void assignStep(double args1, double args2, double args3, double args4, int color, int instruction) {
		this.steps[0][total_step] = args1;
		this.steps[1][total_step] = args2;
		this.steps[2][total_step] = args3;
		this.steps[3][total_step] = args4;
		this.steps[4][total_step] = color;
		this.steps[5][total_step] = instruction;
		total_step++;
	}

	public void displayInitialArray() {
		pane.getChildren().clear();
		curr_step = 0;
		displayStep(curr_step++);
	}

	public void nextStep() {
		if (curr_step == total_step) {
			displaySortedArray();
			return;
		}
		displayStep(curr_step);
		curr_step++;
	}

	public void previousStep() {
		pane.getChildren().clear();
		int tmp = curr_step;
		for (curr_step = 0; curr_step <= tmp - 2; ++curr_step) {
			displayStep(curr_step);
		}
	}

	public void displaySortedArray() {
		pane.getChildren().clear();
		drawArray(this.array, initColor, pane.getWidth() / 2 - arr_length * 30, startY);
		text_area.setText("Done sorting!");
		curr_step = total_step;
	}

	private void drawArray(int arr[], Color[] c, double startX, double startY) {
		for (int i = 0; i < arr.length; i++) {
			Square s;
			s = new Square(arr[i], startX + i * 60, startY, c[0], c[1]);
			pane.getChildren().add(s);
		}
	}

	private void displayStep(int stepNum) {
		Color[] c = initColor.clone();
		int tmp = (int) steps[4][stepNum];
		// color:
		// 0: light blue
		// 1: yellow: selected and ready to merge
		// 2: blue: merged
		// 3: white: vanished
		// 4: green: selected and ready to split
		if (tmp == 0)
			c[0] = Color.LIGHTBLUE;
		else if (tmp == 1)
			c[0] = Color.YELLOW;
		else if (tmp == 2)
			c[0] = Color.DEEPSKYBLUE;
		else if (tmp == 3)
			c[0] = Color.WHITE;
		else if (tmp == 4)
			c[0] = Color.LIMEGREEN;

		if (steps[0][stepNum] == -1) {
			int[] tmp2 = new int[1];
			tmp2[0] = (int) steps[1][stepNum];
			drawArray(tmp2, c, steps[2][stepNum], steps[3][stepNum]);
		} else {
			if (steps[4][curr_step] != 3) {
				drawArray(Arrays.copyOfRange(cloneArr, (int) steps[0][stepNum], (int) steps[1][stepNum] + 1), c,
						steps[2][stepNum], steps[3][stepNum]);
			} else {
				int len = (int) (steps[1][stepNum] - steps[0][stepNum] + 1);
				int[] tmp3 = new int[len];
				for (int i = 0; i < (len); ++i)
					tmp3[i] = -1; // create array with full of -1 to draw white square.
				drawArray(tmp3, c, steps[2][stepNum], steps[3][stepNum]);
			}
		}
		text_area.setText(instructions[(int) steps[5][curr_step]]);
		text_area.setFont(Font.font("verdana", FontPosture.REGULAR, 14));
	}
}



