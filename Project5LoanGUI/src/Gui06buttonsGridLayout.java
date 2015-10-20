//==========================================================================================
// Demo Gui06: GridLayout layout manager
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui06buttonsGridLayout
{
  public static void main(String[] args)
  {
    JFrame  myFrame     = new JFrame("One button in each cell");
    JButton myButtonA   = new JButton("A");
    JButton myButtonB   = new JButton("B");
    JButton myButtonC   = new JButton("C");
    JButton myButtonD   = new JButton("D");
    JButton myButtonE   = new JButton("E");
    JButton myButtonF   = new JButton("F");

    myFrame.setLayout(new GridLayout(2,3) );

    myFrame.add(myButtonA);
    myFrame.add(myButtonB);
    myFrame.add(myButtonC);
    myFrame.add(myButtonD);
    myFrame.add(myButtonE);
    myFrame.add(myButtonF);

    myFrame.setSize(400,200);
    myFrame.setLocation(400,200);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
  }
}