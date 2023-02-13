package sortingalgorithms;
import java.util.*;
import java.io.*;
import java.lang.Math;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

import elements.Square;

public class RadixSort extends SortingAlgo{
	//private static int n;
	//Exception
	public RadixSort(int[] input_array, Pane input_pane, TextArea input_text_area, Label input_lb) {
		super(input_array, input_pane, input_text_area, input_lb);
		Check_valid_value(input_array);
        	isSuitableForInputSize(input_array.length);

		final int m = getMax(array, arr_length);
		for (int i =0; i<8;i++) {
			Square bruh = drawSquare(array[i]);
			bruh.setAxis(100+65*i, 25);
			pane.getChildren().add(bruh);
		}
			countingSort(arr_length, 1);
			text_area.setText("Count sorting the 1 time !!!!");
			curr_step = 0;
			 
	}

	@Override
	public void nextStep() {
		if (curr_step < 4) {
			curr_step = curr_step+1;
		} 
		for (int i = 0; i < curr_step; i+=1) { 
			countingSort(8,(int) Math.pow(10, i));}
		}
	
	@Override
	public void previousStep() {
		if (curr_step > 0) {
			curr_step = curr_step-1;
		} for (int i = 0; i < curr_step; i+=1) { 
			countingSort(8,(int) Math.pow(10, i));}
		
	}
	
	int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	void countingSort(int n, int exp) {
		int b = (int)Math.log10(exp) + 1;
		text_area.setText("Count sorting the "+ b + " time !!!!");
		//lb.setText(b + "/" + 4);
		pane.getChildren().clear();
		for (int i = 0 ; i < 10; i++) {
			Square bruh = drawSquare(i);
			bruh.setFill("#e8e8e8");
			bruh.setAxis(200 + 65*i, 400);
			pane.getChildren().add(bruh);
		}
	 
		int output[] = new int[n]; 
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++){
			count[(array[i] / exp) % 10]++;
			Square bruh = drawSquare(array[i]);
			bruh.setAxis(200 + ((array[i] / exp) % 10)*65,400 - 65*count[(array[i] / exp) % 10]);
			pane.getChildren().add(bruh);
		} 

		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];}

		for (i = n - 1; i >= 0; i--) {
			output[count[(array[i] / exp) % 10] - 1] = array[i];
			count[(array[i] / exp) % 10]--;
		
		}

		
		for (i = 0; i < n; i++) {
			array[i] = output[i];}
		
		
	
		for (int k =0; k<8;k++) {
			Square bruh = drawSquare(array[k]);
			bruh.setAxis(250+65*k, 25);
			pane.getChildren().add(bruh);
		}
	}

	
	@Override
	public int getTotal_step() {
		if (getMax(array, arr_length) < 10) {
			return 1;
		} else if (getMax(array, arr_length) < 100 && getMax(array, arr_length) >= 10) {
			return 2;
		}else if (getMax(array, arr_length) < 1000 && getMax(array, arr_length) >= 100) {
			return 3;
	} else {
		return 4;
	}
	}

	@Override
	public void displayInitialArray() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void displaySortedArray() {
		// TODO Auto-generated method stub
		
	}
	
	
}

