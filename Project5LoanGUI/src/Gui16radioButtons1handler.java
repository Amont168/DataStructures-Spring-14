//==============================================================================
// Demo Gui16: How to group radio buttons.
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui16radioButtons1handler
{
  public static void main( String args[] )
  {
    Gui16radioButtons1handlerClass myWindow = new Gui16radioButtons1handlerClass();
    myWindow.setSize(450,100);
    myWindow.setLocation(300,200);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
//------------------------------------------------------------------------------
@SuppressWarnings("serial")
class Gui16radioButtons1handlerClass extends JFrame
{
  private JRadioButton button1;                                    //fields
  private JRadioButton button2;
  private JRadioButton button3;
  private JRadioButton button4;
  private JTextField   scrnMsg;

  public Gui16radioButtons1handlerClass()                          //constructor
  {
    super("Radio Buttons Demo");
    setLayout(new FlowLayout());

    button1 = new JRadioButton("Button 1");
    button2 = new JRadioButton("Button 2");
    button3 = new JRadioButton("Button 3");
    button4 = new JRadioButton("Button 4");
    ButtonGroup  btnGrp1 = new ButtonGroup(); //note: this is not a panel
    btnGrp1.add(button1);
    btnGrp1.add(button2);
    btnGrp1.add(button3);
    btnGrp1.add(button4);

    scrnMsg = new JTextField(10);
    scrnMsg.setEditable(false);

    JPanel pnl = new JPanel();
    pnl.setLayout(new FlowLayout());
    pnl.add(button1);
    pnl.add(button2);
    pnl.add(button3);
    pnl.add(button4);
    pnl.add(scrnMsg);
    add(pnl);

    ButtonHdlr btnHdlr = new ButtonHdlr();
    button1.addActionListener(btnHdlr);
    button2.addActionListener(btnHdlr);
    button3.addActionListener(btnHdlr);
    button4.addActionListener(btnHdlr);
  }
//------------------------------------------------------------------------------
  private class ButtonHdlr implements ActionListener             // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      if(button1.isSelected())
        scrnMsg.setText("Button 1 selected");
      if(button2.isSelected())
        scrnMsg.setText("Button 2 selected");
      if(button3.isSelected())
        scrnMsg.setText("Button 3 selected");
      if(button4.isSelected())
        scrnMsg.setText("Button 4 selected");
    }
  }//end inner class
//------------------------------------------------------------------------------
}//end outer class