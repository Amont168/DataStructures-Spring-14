//==========================================================================================
// Demo Gui05: BorderLayout layout manager
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui05buttonsBorderLayout
{
  public static void main(String[] args)
  {
    JFrame  myFrame     = new JFrame("One button in each region");
    JButton myButtonE   = new JButton("East Button");
    JButton myButtonS   = new JButton("South Button");
    JButton myButtonW   = new JButton("West Button");
    JButton myButtonN   = new JButton("North Button");
    JButton myButtonC   = new JButton("Center Button");

    myButtonN.setFocusPainted(false); //removes focus (until turned back on)

    myFrame.setLayout(new BorderLayout(5,10) ); //horiz gap 5, vert gap 10

    myFrame.add(myButtonE,BorderLayout.EAST);
    myFrame.add(myButtonS,BorderLayout.SOUTH);
    myFrame.add(myButtonW,BorderLayout.WEST);
    myFrame.add(myButtonN,BorderLayout.NORTH);
    myFrame.add(myButtonC,BorderLayout.CENTER);

    myFrame.setSize(400,200);
    myFrame.setLocation(400,200);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
  }
}