package algorithms;

import java.util.*;

import elements.Square;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class FIFO extends PRAlgorithm {
	
	private Queue<Integer> pageFrame;
	
	
	public FIFO(int[] pageReferences, int frameSize, Pane inputPane) {
		super();
		this.pageReferences = pageReferences;
		this.frameSize = frameSize;
		this.PRLength = pageReferences.length;
		pane = inputPane;
		pageFrame = new LinkedList<>();


	}

	public int pageFaults() {
		
		int pageFaults = 0;
		
		for (int i = 0; i < PRLength; i++) {
			int hit = 1;
			if (pageFrame.size() < frameSize) {
    		   if (!pageFrame.contains(pageReferences[i])) {
    			   pageFrame.add(pageReferences[i]);
    			   pageFaults++; hit = 0;
    		   }
			}
			else {
				if (!pageFrame.contains(pageReferences[i])) {
					pageFrame.poll();
					pageFrame.add(pageReferences[i]);
					pageFaults++; hit = 0;
				}
			}
    	   
			Square PR;
			PR = new Square(Integer.toString(pageReferences[i]), 60 + 100*i, 5);
			pane.getChildren().add(PR);
			
			drawPageFrames(pageFrame, initColor, 60 + 100*i, 65);
			
			Square Label;
			Label = new Square(hit == 1 ? "Hit" : "Miss", 60 + 100*i, 70 + frameSize*60);
			pane.getChildren().add(Label);
			
		}
			
			return pageFaults;
    }
	
	
	
	/*public static void main(String args[])
	{
		int pages[] = {0, 1, 2, 3, 0, 1, 4, 0, 1, 2, 3, 4};
        int capacity = 3;
        FIFO test1 = new FIFO(pages, capacity, null);
        test1.pageFaults();
	} */
}

