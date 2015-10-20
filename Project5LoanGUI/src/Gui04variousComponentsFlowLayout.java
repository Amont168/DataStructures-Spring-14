//==========================================================================================
// Demo Gui04: Various Components (just a few of those that are available)
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui04variousComponentsFlowLayout
{
  public static void main(String[] args)
  {
    String        aMessage       = "My Text Area line 1\nMy Text Area line 2\nnext line";

    JFrame        myFrame        = new JFrame    ("Misc Components with FlowLayout");

    JButton       myButton       = new JButton      ("My Button");
    JLabel        myLabel        = new JLabel       ("My Label");
    JTextField    myTextField    = new JTextField   ("My Text Field");
    JTextArea     myTextArea     = new JTextArea    (aMessage);
    JCheckBox     myCheckBox     = new JCheckBox    ("My Check Box");
    JRadioButton  myRadioButton  = new JRadioButton ("My Radio Button");

    myFrame.setLayout(new FlowLayout() );

    myFrame.add(myButton);
    myFrame.add(myLabel);
    myFrame.add(myTextField);
    myFrame.add(myTextArea);
    myFrame.add(myCheckBox);
    myFrame.add(myRadioButton);

    myFrame.setSize(400,200);
    myFrame.setLocation(400,200);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
  }
}