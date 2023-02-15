package algorithms;
	
import java.io.*;
import java.util.*;

import elements.Square;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class OPR extends PRAlgorithm {
	
	private int[] pageFrame;

	public OPR(int[] pageReferences, int frameSize, Pane inputPane) {
		super();
		this.pageReferences = pageReferences;
		this.frameSize = frameSize;
		this.PRLength = pageReferences.length;
		pane = inputPane;
		pageFrame = new int[frameSize];
		for (int i = 0; i < frameSize; i++) {
			pageFrame[i] = -1;
		}
	

	}

	private boolean search(int key)
    {
        for (int i = 0; i < frameSize; i++)
            if (pageFrame[i] == key)
                return true;
        return false;
    }
 
    // Function to find the frame that will not be used recently in future after given index in pg[0..pn-1]
    private int predict(int index)
    {
        // Store the index of pages which are going to be used recently in future
        int res = -1, farthest = index;
        for (int i = 0; i < frameSize; i++) {
            int j;
            for (j = index; j < PRLength; j++) {
                if (pageFrame[i] == pageReferences[j]) {
                    if (j > farthest) {
                        farthest = j;
                        res = i;
                    }
                    break;
                }
            }
 
            // If a page is never referenced in future, return it.
            if (j == PRLength)
                return i;
        }
 
        // If all of the frames were not in future, return any of them, we return 0. Otherwise we return res.
        return (res == -1) ? 0 : res;
    }
 
    @Override
    public int pageFaults()
    {

 
        // Traverse through page reference array and check for miss and hit.
        int hit = 0;
        int index = 0;
        for (int i = 0; i < PRLength; i++) {
        	
        	int hitID = 0;
            // Page found in a frame : HIT
            if (search(pageReferences[i])) {
                hit++; hitID = 1;
                Square PR;
    			PR = new Square(Integer.toString(pageReferences[i]), 60 + 100*i, 5);
    			pane.getChildren().add(PR);
    			
    			drawPageFrames(pageFrame, frameSize, initColor, 60 + 100*i, 65);
    			
    			Square Label;
    			Label = new Square(hitID == 0 ? "Miss" : "Hit", 60 + 100*i, 70 + frameSize*60);
    			pane.getChildren().add(Label);
                continue;
            }
 
            // Page not found in a frame : MISS
 
            // If there is space available in frames.
            if (index < frameSize)
                pageFrame[index++] = pageReferences[i];
 
            // Find the page to be replaced.
            else {
                int j = predict(i + 1);
                pageFrame[j] = pageReferences[i];
            }
	    			
	        Square PR;
			PR = new Square(Integer.toString(pageReferences[i]), 60 + 100*i, 5);
			pane.getChildren().add(PR);
			
			drawPageFrames(pageFrame, frameSize, initColor, 60 + 100*i, 65);
			
			Square Label;
			Label = new Square(hitID == 0 ? "Miss" : "Hit", 60 + 100*i, 70 + frameSize*60);
			pane.getChildren().add(Label);
            
        }
        
        return PRLength - hit;
	}

	
	 
	
	public void drawPageFrames(int[] frame, int frameSize, Color[] c, double startX, double startY) {
		
		int i = 0; 
		
		for (Integer item: frame) {
            Square s;
			s = new Square(item, startX, startY + i * 60, c[0], c[1]);
			pane.getChildren().add(s);
			i++;
        }
		
	}
	 
	   
	 
    /*public static void main(String[] args)
    {
 
        int pages[]
            = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        int capacity = 4;
        OPR testOPR = new OPR(pages, capacity, null);
        testOPR.pageFaults();
        //pageFault is 6
    } */
	
}
