//==============================================================================
// Gui18: Simple calculator demo
//==============================================================================
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gui18calculator
{
  public static void main( String args[] )
  {
    Gui18calculatorClass myWindow = new Gui18calculatorClass();
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setSize(450,100 );
    myWindow.setLocation(200,100);
    myWindow.setVisible(true);
  }
}
//------------------------------------------------------------------------------
@SuppressWarnings("serial")
class 


extends JFrame
{
  private JTextField num1;                            // fields
  private JTextField num2;
  private JTextField answ;
  private JButton    addBtn;
  private JButton    subBtn;
  private JButton    mulBtn;
  private JButton    divBtn;
  private JLabel     opSum;
  private JLabel     eqlSgn;

  public Gui18calculatorClass()                         // constructor
  {
    super("Simple calculator");
    setLayout(new FlowLayout());
    num1   = new JTextField( 10 );
    num2   = new JTextField( 10 );
    answ   = new JTextField( 10 );
    addBtn = new JButton   ("Add");
    subBtn = new JButton   ("Subtract");
    mulBtn = new JButton   ("Multiply");
    divBtn = new JButton   ("Divide");
    opSum  = new JLabel    (" op ");
    eqlSgn = new JLabel    (" = ");
    add( num1   );
    add( opSum  );
    add( num2   );
    add( eqlSgn );
    add( answ   );
    add( addBtn );
    add( subBtn );
    add( mulBtn );
    add( divBtn );
    AddHdlr handlerA = new AddHdlr();
    SubHdlr handlerS = new SubHdlr();
    MulHdlr handlerM = new MulHdlr();
    DivHdlr handlerD = new DivHdlr();
    addBtn.addActionListener( handlerA );
    subBtn.addActionListener( handlerS );
    mulBtn.addActionListener( handlerM );
    divBtn.addActionListener( handlerD );
  }
//------------------------------------------------------------------------------










//------------------------------------------------------------------------------
  private class AddHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String x, y;
      int    a, b, c;
      x = num1.getText();
      y = num2.getText();
      a = Integer.parseInt(x);
      b = Integer.parseInt(y);
      c = a + b;
      opSum.setText(" + ");
      answ.setText(c + "");
    }
  }
//------------------------------------------------------------------------------
  private class SubHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String x, y;
      int    a, b, c;
      x = num1.getText();
      y = num2.getText();
      a = Integer.parseInt(x);
      b = Integer.parseInt(y);
      c = a - b;
      opSum.setText(" - ");
      answ.setText(c + "");
    }
  }
//------------------------------------------------------------------------------
  private class MulHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String x, y;
      int    a, b, c;
      x = num1.getText();
      y = num2.getText();
      a = Integer.parseInt(x);
      b = Integer.parseInt(y);
      c = a * b;
      opSum.setText(" * ");
      answ.setText(c + "");
    }
  }
//------------------------------------------------------------------------------
  private class DivHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String x, y, z;
      int    a, b;
      double c;

      x = num1.getText();
      y = num2.getText();
      a = Integer.parseInt(x);
      b = Integer.parseInt(y);
      c = a * 1.0 / b;
      opSum.setText(" / ");
      z = String.format("%6.4f",c);
      answ.setText(z);
    }
  }
//------------------------------------------------------------------------------
}