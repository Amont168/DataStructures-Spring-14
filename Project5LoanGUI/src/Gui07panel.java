//==========================================================================================
// Demo Gui07: Adding a panel container to control the layout.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui07panel
{
  public static void main(String[] args)
  {
    JFrame     myFrame     = new JFrame("Lower set of components are in a panel");
    JPanel     myPanel     = new JPanel();

    JButton       myButton1      = new JButton      ("My Button 1");
    JLabel        myLabel1       = new JLabel       ("My Label 1");
    JTextField    myTextField1   = new JTextField   ("My Text Field 1");
    JTextArea     myTextArea1    = new JTextArea    ("My Text Area 1 line 1\nMy Text 1 Area line 2");
    JCheckBox     myCheckBox1    = new JCheckBox    ("My Check Box 1");
    JRadioButton  myRadioButton1 = new JRadioButton ("My Radio Button 1");

    JButton       myButton2      = new JButton      ("My Button 2");
    JLabel        myLabel2       = new JLabel       ("My Label 2");
    JTextField    myTextField2   = new JTextField   ("My Text Field 2");
    JTextArea     myTextArea2    = new JTextArea    ("My Text Area 2 line 1\nMy Text Area 2 line 2");
    JCheckBox     myCheckBox2    = new JCheckBox    ("My Check Box 2");
    JRadioButton  myRadioButton2 = new JRadioButton ("My Radio Button 2");

//    FlowLayout myLayout = new FlowLayout();     two-step version
//    myFrame.setLayout(myLayout);

    myFrame.setLayout(new FlowLayout());

    myFrame.add(myButton1);        //add 1st set of components directly to frame
    myFrame.add(myLabel1);
    myFrame.add(myTextField1);
    myFrame.add(myTextArea1);
    myFrame.add(myCheckBox1);
    myFrame.add(myRadioButton1);

    myPanel.setLayout(new FlowLayout());  //shows a panel will not flow

    myPanel.add(myButton2);        //add 2nd set of components to panel first...
    myPanel.add(myLabel2);
    myPanel.add(myTextField2);
    myPanel.add(myTextArea2);
    myPanel.add(myCheckBox2);
    myPanel.add(myRadioButton2);
    myFrame.add(myPanel);          //then add the panel to frame

    myFrame.setSize(700,200);
    myFrame.setLocation(100,100);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
  }
}