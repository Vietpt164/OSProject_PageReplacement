package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import elements.Square;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class PRAlgorithm {
	protected int[] pageReferences;
	protected int frameSize;
	public static Pane pane;
	protected int PRLength;
	protected Color[] initColor = {Color.LIGHTBLUE, Color.BLACK };
	
	
	
	public void drawPageFrames(Queue<Integer> pageFrame, Color[] c, double startX, double startY) {
		
		List<Integer> frame = new ArrayList<Integer>(pageFrame);
		int i = 0; 
		while (frame.size() < frameSize) {
			frame.add(-1);
		}
		
		for (Integer item: frame) {
            Square s;
			s = new Square(item, startX, startY + i * 60, c[0], c[1]);
			pane.getChildren().add(s);
			i++;
        }
		
	}

	public abstract int pageFaults();
	
	
}
