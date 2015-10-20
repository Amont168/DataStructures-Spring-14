//==========================================================================================
// Demo Gui09: Panel with GridLayout manager
//==========================================================================================
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Gui09panel2filesGridLayout extends JFrame
{
  public Gui09panel2filesGridLayout() //constructor
  {
    super("Panel with GridLayout");

    JPanel myPanel = new JPanel();

    String aLabelLiteral   = "Frame label";
    String aButtonLiteral  = "Frame button";
    String aTxtFldLiteral  = "Frame text field";
    String aTxtAreaLiteral = "Frame text area line 1\nFrame text area line 2";
    String aCkBoxLiteral   = "Frame check box";
    String aRadBtnLiteral  = "Frame radio button";

    String bLabelLiteral   = "Panel label";
    String bButtonLiteral  = "Panel button";
    String bTxtFldLiteral  = "Panel text field";
    String bTxtAreaLiteral = "Panel text area line 1\nPanel text area line 2";
    String bCkBoxLiteral   = "Panel check box";
    String bRadBtnLiteral  = "Panel radio button";

    JLabel        label1    = new JLabel       (aLabelLiteral);
    JButton       button1   = new JButton      (aButtonLiteral);
    JTextField    txtFld1   = new JTextField   (aTxtFldLiteral);
    JTextArea     txtArea1  = new JTextArea    (aTxtAreaLiteral);
    JCheckBox     ckBox1    = new JCheckBox    (aCkBoxLiteral);
    JRadioButton  radioBtn1 = new JRadioButton (aRadBtnLiteral);

    JLabel        label2    = new JLabel       (bLabelLiteral);
    JButton       button2   = new JButton      (bButtonLiteral);
    JTextField    txtFld2   = new JTextField   (bTxtFldLiteral);
    JTextArea     txtArea2  = new JTextArea    (bTxtAreaLiteral);
    JCheckBox     ckBox2    = new JCheckBox    (bCkBoxLiteral);
    JRadioButton  radioBtn2 = new JRadioButton (bRadBtnLiteral);

    setLayout(new FlowLayout()); //layout for frame (comment out to see effect)

    add(label1);                             //add components to frame
    add(button1);
    add(txtFld1);
    add(txtArea1);
    add(ckBox1);
    add(radioBtn1);

    myPanel.setLayout(new GridLayout(100,2) ); // layout for the panel
                                             // RxC,  rows control layout
                                             // (change numbers to see effect)

    myPanel.add(label2);                     //add components to panel
    myPanel.add(button2);                    //left to right, then down
    myPanel.add(txtFld2);
    myPanel.add(txtArea2);
    myPanel.add(ckBox2);
    myPanel.add(radioBtn2);

    add(myPanel);                            //add panel to frame
  }
}