package algorithms;

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
	//protected List<Integer> pageFrame;
	protected Color[] initColor = {Color.LIGHTBLUE, Color.BLACK };
	
	public void drawPageFrames(Queue<Integer> pageFrame , Color[] c, double startX, double startY) {
		int i = 0; 
		
		for (Integer item: pageFrame) {
            Square s;
			s = new Square(item, startX, startY + i * 60, c[0], c[1]);
			pane.getChildren().add(s);
			i++;
        }
		
	}

	public abstract int pageFaults();
	
	
}
