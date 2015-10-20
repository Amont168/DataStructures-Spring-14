//==============================================================================
// Demo Gui14: How to group radio buttons.                 (driver)
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.accessibility.*;
public class Gui14radioButtons
{
  public static void main( String args[] )
  {
    Gui14radioButtonsClass myWindow = new Gui14radioButtonsClass();
    myWindow.setSize(325,300);
    myWindow.setLocation(200,100);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
//==============================================================================
// Demo Gui14: Class for gui
//==============================================================================
@SuppressWarnings("serial")
class Gui14radioButtonsClass extends JFrame
{
  private JRadioButton rbtn1;                                         //fields
  private JRadioButton rbtn2;
  private JRadioButton rbtn3;
  private JRadioButton rbtnA;
  private JRadioButton rbtnB;
  private JRadioButton rbtnC;
  private JRadioButton rbOvernight;
  private JRadioButton rb3rdDay;
  private JRadioButton rbRegular;
  private JTextField   fldPmt;
  private JTextField   fldShip;
  private JTextField   fldDeliv;

  public Gui14radioButtonsClass()                                  // constructor
  {
    super("Radio Buttons Demo");

    setLayout(new GridLayout(5,1));

    rbtn1 = new JRadioButton("VISA");
    rbtn2 = new JRadioButton("MC");
    rbtn3 = new JRadioButton("Amex");
    ButtonGroup  btnGrp1 = new ButtonGroup(); //makes buttons mutually exclusive
    btnGrp1.add(rbtn1);
    btnGrp1.add(rbtn2);
    btnGrp1.add(rbtn3);
    JPanel       pnlA    = new JPanel();
    pnlA.add(rbtn1);
    pnlA.add(rbtn2);
    pnlA.add(rbtn3);
    add(pnlA);

    rbtnA = new JRadioButton("FEDEX");
    rbtnB = new JRadioButton("UPS");
    rbtnC = new JRadioButton("USPS");
    ButtonGroup  btnGrp2 = new ButtonGroup();
    btnGrp2.add(rbtnA);
    btnGrp2.add(rbtnB);
    btnGrp2.add(rbtnC);
    JPanel       pnlB    = new JPanel();
    pnlB.add(rbtnA);
    pnlB.add(rbtnB);
    pnlB.add(rbtnC);
    add(pnlB);

    rbOvernight = new JRadioButton("Overnight");
    rb3rdDay    = new JRadioButton("3rd Day");
    rbRegular   = new JRadioButton("Regular");
    ButtonGroup  btnGrp3 = new ButtonGroup();
    btnGrp3.add(rbOvernight);
    btnGrp3.add(rb3rdDay);
    btnGrp3.add(rbRegular);
    JPanel       pnlC    = new JPanel();
    pnlC.add(rbOvernight);
    pnlC.add(rb3rdDay);
    pnlC.add(rbRegular);
    add(pnlC);

    fldPmt   = new JTextField(10);
    fldShip  = new JTextField(10);
    fldDeliv = new JTextField(10);
    JPanel     pnlMsg   = new JPanel();
    pnlMsg.setLayout(new FlowLayout());
    pnlMsg.add(fldPmt);
    pnlMsg.add(fldShip);
    pnlMsg.add(fldDeliv);
    add(pnlMsg);

    JButton    btnProc  = new JButton("Process Request");
    add(btnProc);

    HdlrVISA  visaHdlr  = new HdlrVISA();
    HdlrMC    mcHdlr    = new HdlrMC();
    HdlrAmex  amexHdlr  = new HdlrAmex();
    rbtn1.addActionListener(visaHdlr);
    rbtn2.addActionListener(mcHdlr);
    rbtn3.addActionListener(amexHdlr);

    HdlrShip  shipHdlr  = new HdlrShip();
    rbtnA.addActionListener(shipHdlr);
    rbtnB.addActionListener(shipHdlr);
    rbtnC.addActionListener(shipHdlr);

    HdlrBtn   btnHdlr   = new HdlrBtn();
    btnProc.addActionListener(btnHdlr);
  }
//------------------------------------------------------------------------------
  private class HdlrVISA implements ActionListener     // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      fldPmt.setText("Pmt: VISA");
    }
  }//end inner class
//------------------------------------------------------------------------------
  private class HdlrMC implements ActionListener       // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      fldPmt.setText("Pmt: MasterCard");
    }
  }//end inner class
//------------------------------------------------------------------------------
  private class HdlrAmex implements ActionListener     // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      fldPmt.setText("Pmt: Amex");
    }
  }//end inner class
//------------------------------------------------------------------------------





//------------------------------------------------------------------------------
  private class HdlrShip implements ActionListener     // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      if(rbtnA.isSelected())
        fldShip.setText("Ship: FedEx");
      else
      if(rbtnB.isSelected())
        fldShip.setText("Ship: UPS");
      else
      if(rbtnC.isSelected())
        fldShip.setText("Ship: USPS");
    }
  }//end inner class
//------------------------------------------------------------------------------
  private class HdlrBtn implements ActionListener      // inner class
  {
    public void actionPerformed( ActionEvent event )
    {
      if(rbOvernight.isSelected())
        fldDeliv.setText("Ship: Overnight");
      else
      if(rb3rdDay.isSelected())
        fldDeliv.setText("Ship: 3rd Day");
      else
      if(rbRegular.isSelected())
        fldDeliv.setText("Ship: Regular");
    }
  }//end inner class
//------------------------------------------------------------------------------
}//end outer class
