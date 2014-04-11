import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;


public class ColorCLKButton extends JButton implements ActionListener
{
    private ClockPanel one;
    private ClockPanel two;
    private int value;

    public ColorCLKButton(ClockPanel left, ClockPanel right, int val)
    {
        one = left;
        two = right;
        value = val;
        this.addActionListener(this);
        setPreferredSize(new Dimension(30,30));
        
    }

    
    public void paintComponent(Graphics g)
    {super.paintComponent(g);
        
        if(value == 1)g.setColor(Color.RED);
        if(value == 2)g.setColor(Color.BLUE);
        if(value == 4)g.setColor(Color.YELLOW);
        g.fillOval(0,0,30,30);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        one.changeState(value); two.changeState(value);
        
    }


}