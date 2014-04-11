import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class SimpleAnimationExample extends JFrame{

	java.util.Random r = new java.util.Random();
    Image bg = null;
    
	
	public void init() throws InterruptedException, IOException {
        bg = ImageIO.read(new File("blurmastermind.jpg"));
        JPanel hah = new JPanel(){public void paintComponent(Graphics g){
            g.drawImage(bg,0,0,800,800,null);
        
        }};
        hah.setOpaque(false);
        this.setContentPane(hah);
		Container contentPane = this.getContentPane();
        

        
        repaint();
        //catch(Exception x){System.out.println("Cannot find file; ");}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("Time:"));

		JTextField timeField = new JTextField(20);
		contentPane.add(timeField);

		JButton jb = new JButton("update time");
		this.getContentPane().add(jb);

		ClockPanel cp = new ClockPanel(timeField, true);
        cp.setOpaque(false);
        ClockPanel cp2 = new ClockPanel(timeField, false);
        cp2.setOpaque(false);
        System.out.println(contentPane.getBackground());
		contentPane.add(cp);
        contentPane.add(cp2);
		jb.addActionListener(cp);
        jb.addActionListener(cp2);
        
        ColorCLKButton red = new ColorCLKButton(cp, cp2, 1);
        ColorCLKButton blue = new ColorCLKButton(cp, cp2, 2);
        ColorCLKButton yellow = new ColorCLKButton(cp, cp2, 4);
        contentPane.add(red);
        contentPane.add(blue);
        contentPane.add(yellow);

		int howManyThreads = 1;
		int timeToPause = 1;
		
        
        
        
		for (int i=0; i<howManyThreads; i++) {
			ClockAnimateThread cat = new ClockAnimateThread(cp,1000*random(timeToPause));
                    cat.start();
            ClockAnimateThread cat2 = new ClockAnimateThread(cp2,1000*random(timeToPause));
                cat2.start();
            SaveRoom sound = new SaveRoom(); sound.start();

		}
        
	}
	
	/* returns an int between 1 and top, inclusive */

	private int random(int top) {
		return 1+r.nextInt(top);
	}
	
    public void paint(Graphics g)
    {   super.paint(g);
        g.drawImage(bg, 0, 0, 800,800,null);
        paintChildren();
    }
   
    public void paintChildren()
    {Container cp = this.getContentPane();
        cp.setBackground(null);
        Component[] array = cp.getComponents();
        for(Component x: array)
            x.repaint();
        
    }
    
}


