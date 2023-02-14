package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import elements.Square;
import javafx.scene.layout.Pane;

public class LRU extends PRAlgorithm {
	
	private Queue<Integer> pageFrame;
	
	public LRU(int[] pageReferences, int frameSize, Pane inputPane) {
		super();
		this.pageReferences = pageReferences;
		this.frameSize = frameSize;
		this.PRLength = pageReferences.length;
		pane = inputPane;
		pageFrame = new LinkedList<>();
		for (int i = 0; i < frameSize; i++) {
			pageFrame.add(-1);
		}

	}

	public int pageFaults () {
		int pageFault = 0;
		
		for (int i = 0; i < PRLength; i++) {
			int hit = 1;
			if (pageFrame.isEmpty() || !pageFrame.contains(pageReferences[i]))
		    	{
		        if (pageFrame.size() == frameSize) // if frame is full we remove the least recently used page
		        	pageFrame.poll(); // removing the front element which is not replaced for long time
		 
		        pageFrame.add(pageReferences[i]); // now we add the page to frame
		        pageFault++; hit = 0; // incrementing page faults
		      }
		      else
		      {
		    	// if the page already exists we'll remove it from previous position and add it to the end of the queue
		        pageFrame.remove(pageReferences[i]); 
		        pageFrame.add(pageReferences[i]);
				
			}
			
			Square PR;
			PR = new Square(Integer.toString(pageReferences[i]), 60 + 100*i, 5);
			pane.getChildren().add(PR);
			
			drawPageFrames(pageFrame, initColor, 60 + 100*i, 65);
			
			Square Label;
			Label = new Square(hit == 1 ? "Hit" : "Miss", 60 + 100*i, 70 + frameSize*60);
			pane.getChildren().add(Label);
			
		}
		
		return pageFault;
	}

	/*public static void main(String[] args) {
		int pages[] = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        int capacity = 4;
        LRU testLRU = new LRU(pages, capacity, null);
        System.out.println(testLRU.pageFaults());
	} */

}
