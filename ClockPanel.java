import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClockPanel extends JPanel implements ActionListener {

	int hourTime;
	int minuteTime;
    int i = 0;
    int pointer = 0x000;
    Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.GREEN, Color.WHITE};
    private boolean active = false;

	JTextField timeIsHere;

	public ClockPanel(JTextField timeField) {
		timeIsHere = timeField;
		this.setPreferredSize(new Dimension(400,400));
	}
    
    public ClockPanel(JTextField timeField, boolean awake) {
		timeIsHere = timeField;
		this.setPreferredSize(new Dimension(400,400));
        active = awake;
	}
    
    
	public void bumpTime() {
        if(active){
		minuteTime++;
		if (minuteTime == 60) {
			minuteTime =0;
			hourTime++;
			if (hourTime == 13)
				hourTime =1;
		}
        
        repaint();
        }
	}

	public void actionPerformed(ActionEvent e) {

        
        if(active){
        
		String time = timeIsHere.getText();
		int colon = time.indexOf(':');

		String hours = time.substring(0,colon);
		String minutes = time.substring(colon+1);

		hourTime = Integer.parseInt(hours);
		minuteTime = Integer.parseInt(minutes);

		System.out.println(hourTime+" "+minuteTime);

		repaint();
        }
	}

    
    public void paint(Graphics g)
    {paintComponent(g); paintBorder(g);}
    
    
	public void paintComponent(Graphics g) {
        Color invis = new Color(255, 0, 0, 100);
		//super.paintComponent(g);
        this.setBackground(invis);
        g.setColor(colors[pointer]);
        
		g.fillOval(110,110,80,80);

		double hour = hourTime;
		if (hour == 12)
			hour = 0;

		drawHand(g, hour, 70, 12, 0.2);

		drawHand(g, minuteTime, 100, 60, 0.1);
        


	}
    
    public void paintBorder(Graphics g)
    {//super.paintBorder(g);
        g.drawOval(0,0,300,300);
        
    }

	private void drawHand(Graphics g, double hour, int length, int max, double width) {

		double hourAngle = hour/max*2.0*Math.PI- Math.PI/2;
		int[] hourHandX = new int[3];
		int[] hourHandY = new int[3];

		hourHandX[0] = 150;
		hourHandY[0] = 150;

		hourHandX[1] = (int) (150 + length*Math.cos(hourAngle+width));
		hourHandY[1] = (int) (150 + length*Math.sin(hourAngle+width));

		hourHandX[2] = (int) (150 + length*Math.cos(hourAngle-width));
		hourHandY[2] = (int) (150 + length*Math.sin(hourAngle-width));

		g.fillPolygon(hourHandX,hourHandY,3);
	}

        public void changeState(int c){
        active = !active;
            if(active){if(pointer < 7){pointer = c | pointer;}else pointer = 0;}
    }

}
