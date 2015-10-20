//==============================================================================
// Demo Gui13: Driver for multiple components/handlers demo
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui13multipleHandlers
{
   public static void main( String args[] )
   {

      Gui13multipleHandlersWindow myWindow = new Gui13multipleHandlersWindow();
      myWindow.setSize(400,200);
      myWindow.setLocation(150,150);
      myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      myWindow.setVisible( true );
   }
}
//==========================================================================================
// Demo Gui13: Multiple components with action listeners.
//==========================================================================================
@SuppressWarnings("serial")
class Gui13multipleHandlersWindow extends JFrame
{
  private JLabel     txtLbl1;                                                       //fields
  private JLabel     txtLbl2;
  private JLabel     txtLbl3;   //components are fields so they can be accessed by
  private JLabel     txtLbl4;   //several members (ie: constructor, methods, inner classes)
  private JTextField txtFld1;
  private JTextField txtFld2;
  private JTextField txtFld3;
  private JTextField txtFld4;
  private JButton    btn;

  public Gui13multipleHandlersWindow()                                     //constructor
  {
    super("Multiple TextFields and Handlers");
    setLayout(new GridLayout(5,2));

    txtLbl1 = new JLabel("1st Field");
    txtLbl2 = new JLabel("2nd Field");
    txtLbl3 = new JLabel("3rd Field");
    txtLbl4 = new JLabel("4th Field");
    txtFld1 = new JTextField(10);
    txtFld2 = new JTextField(10);
    txtFld3 = new JTextField(10);
    txtFld4 = new JTextField(10);

    btn     = new JButton("Me Me, Click Me");

    add(txtLbl1);
    add(txtFld1);
    add(txtLbl2);
    add(txtFld2);
    add(txtLbl3);
    add(txtFld3);
    add(txtLbl4);
    add(txtFld4);
    add(btn);

    TxtFldHdlr1 tfHdlr1 = new TxtFldHdlr1();
    TxtFldHdlr2 tfHdlr2 = new TxtFldHdlr2();
    TxtFldHdlr3 tfHdlr3 = new TxtFldHdlr3();
    BtnHdlr     btnHdlr = new BtnHdlr();

    txtFld1.addActionListener(tfHdlr1);
    txtFld2.addActionListener(tfHdlr2);
    txtFld3.addActionListener(tfHdlr3);
    btn.addActionListener(btnHdlr);
  }// end constructor

  //===================== private inner classes for event handling =========================

  private class TxtFldHdlr1 implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String svar;
      svar =  event.getActionCommand();  // One way to get the text
      JOptionPane.showMessageDialog( null, "1st Handler:  " + svar );
    }
  }
  //----------------------------------------------------------------------------------------
  private class TxtFldHdlr2 implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String svar;
      svar = txtFld2.getText();          // Another way get the text
      txtFld4.setText(svar);             // 3 different outputs
      System.out.println("2nd handler " + svar);
      JOptionPane.showMessageDialog( null, "2nd Handler:  " + svar );
    }
  }
  //----------------------------------------------------------------------------------------
  private class TxtFldHdlr3 implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String svar;
      svar = txtFld3.getText();
      txtFld1.setText(svar);     //copy to another field
      txtFld2.setText("");       //clear out fields
      txtFld3.setText("");
      txtFld4.setText("");
    }
  }
  //----------------------------------------------------------------------------------------
  private class BtnHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String svarx;
      String svary;
      svarx =  event.getActionCommand();  // One way to get the text
      System.out.println("from getActionCommand() method = " + svarx);
      svary = btn.getText();
      System.out.println("from getText() method = " + svary);
      String svar1;
      String svar2;
      String svar3;
      String svar4;
      svar1 = txtFld1.getText();
      svar2 = txtFld2.getText();
      svar3 = txtFld3.getText();
      svar4 = txtFld4.getText();
      System.out.println("----button output------");
      System.out.println("Field 1: " + svar1);
      System.out.println("Field 2: " + svar2);
      System.out.println("Field 3: " + svar3);
      System.out.println("Field 4: " + svar4);
      System.out.println("-----------------------");
    }
  }
  //----------------------------------------------------------------------------------------
}//end outer class
