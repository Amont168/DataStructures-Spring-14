//==============================================================================
// Demo Gui17: Using checkboxs with one handler.
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui17checkBox
{
  public static void main( String args[] )
  {

    Gui17checkBoxClass myWindow = new Gui17checkBoxClass();
    myWindow.setSize(450,150);
    myWindow.setLocation(400,200);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
@SuppressWarnings("serial")
class 

extends JFrame
{
  private JCheckBox checkbox1;                            // fields
  private JCheckBox checkbox2;
  private JCheckBox checkbox3;
  private JCheckBox checkbox4;

  public Gui17checkBoxClass()                               // constructor
  {
    super("Radio CheckBoxs Demo");

    setLayout(new FlowLayout());

    checkbox1 = new JCheckBox("CheckBox 1");
    checkbox2 = new JCheckBox("CheckBox 2");
    checkbox3 = new JCheckBox("CheckBox 3");
    checkbox4 = new JCheckBox("CheckBox 4");

    JPanel pnl = new JPanel();
    pnl.add(checkbox1);
    pnl.add(checkbox2);
    pnl.add(checkbox3);
    pnl.add(checkbox4);
    add(pnl);

    CheckBoxHdlr ckBoxHdlr = new CheckBoxHdlr();

    checkbox1.addActionListener(ckBoxHdlr);
    checkbox2.addActionListener(ckBoxHdlr);
    checkbox3.addActionListener(ckBoxHdlr);
    checkbox4.addActionListener(ckBoxHdlr);
  }
//------------------------------------------------------------------------------
  private class CheckBoxHdlr implements ActionListener     // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      System.out.println("--------------------------");
      if(checkbox1.isSelected())
        System.out.println("CheckBox 1 selected");
      if(checkbox2.isSelected())
        System.out.println("CheckBox 2 selected");
      if(checkbox3.isSelected())
        System.out.println("CheckBox 3 selected");
      if(checkbox4.isSelected())
        System.out.println("CheckBox 4 selected");
    }
  }//end inner class
//------------------------------------------------------------------------------
}//end outer class
