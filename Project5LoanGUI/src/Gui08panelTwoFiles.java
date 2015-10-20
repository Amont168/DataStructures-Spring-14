//==========================================================================================
// Demo Gui08: Changes demo Gui07 to driver/class configuration.
// Alternate coding style.
// Also has code to center the window.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Gui08panelTwoFiles extends JFrame   // this class "is" a frame
{
  public Gui08panelTwoFiles() //constructor
  {
    super("Uses driver/class two files design"); // sends title to JFrame constructor

    String labelAstr       = "Frame label";
    String labelBstr       = "Panel label";
    String buttonAstr      = "Frame button";
    String buttonBstr      = "Panel button";
    String textFieldAstr   = "Frame text field";
    String textFieldBstr   = "Panel text field";
    String textAreaAstr    = "Frame text area line 1\nFrame text area line 2";
    String textAreaBstr    = "Panel text area line 1\nPanel text area line 2";
    String checkBoxAstr    = "Frame check box";
    String checkBoxBstr    = "Panel check box";
    String radioButtonAstr = "Frame radio button";
    String radioButtonBstr = "Panel radio button";

    JLabel        labelA       = new JLabel       (labelAstr);     //Note: local varibles
    JLabel        labelB       = new JLabel       (labelBstr);     //used since there are no
    JButton       buttonA      = new JButton      (buttonAstr);    //methods these are
    JButton       buttonB      = new JButton      (buttonBstr);    //needed in.
    JTextField    textFieldA   = new JTextField   (textFieldAstr);
    JTextField    textFieldB   = new JTextField   (textFieldBstr);
    JTextArea     textAreaA    = new JTextArea    (textAreaAstr);
    JTextArea     textAreaB    = new JTextArea    (textAreaBstr);
    JCheckBox     checkBoxA    = new JCheckBox    (checkBoxAstr);
    JCheckBox     checkBoxB    = new JCheckBox    (checkBoxBstr);
    JRadioButton  radioButtonA = new JRadioButton (radioButtonAstr);
    JRadioButton  radioButtonB = new JRadioButton (radioButtonBstr);

    JPanel        myPanel      = new JPanel();

    setLayout(new FlowLayout()); //set layout manager of this object (the frame)

    add(labelA);                 //add components to frame
    add(buttonA);
    add(textFieldA);             //Note  add(xxx)   instead of   identifier.add(xxx)
    add(textAreaA);              //Since object name was not specified it defaults
    add(checkBoxA);              //to the current object which is the frame.
    add(radioButtonA);           // (see class header line 6, this class "is" a frame)

    myPanel.add(labelB);
    myPanel.add(buttonB);
    myPanel.add(textFieldB);     //This has   identifier.add(xxx)
    myPanel.add(textAreaB);      //so it identifies which object to attach to.
    myPanel.add(checkBoxB);
    myPanel.add(radioButtonB);

    add(myPanel);                //add panel to frame
  }
}
