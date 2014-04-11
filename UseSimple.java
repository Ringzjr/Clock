import java.awt.*;
import javax.swing.*;


// Madison Burke; Tieren Costello

public class UseSimple extends JFrame {



	public static void main(String[] args) throws InterruptedException {

		SimpleAnimationExample thisOne = new SimpleAnimationExample();
		try{thisOne.init();}
        catch(Exception e) {e.printStackTrace();}
        
        thisOne.setSize(new Dimension(800,800));
       
		//thisOne.pack();
        
		thisOne.setVisible(true);
		
	}
}
