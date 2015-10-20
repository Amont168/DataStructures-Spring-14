//==============================================================================
// Demo Gui15: Using icons and one action handler.
// www.java2s.com/Code/Java/Swing-JFC/DisplayingaButtonwithanIconLabel.htm
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui15radioButtonsIcons
{
  public static void main( String args[] )
  {

    Gui15radioButtonsIconsClass myWindow = new Gui15radioButtonsIconsClass();
    myWindow.setSize(450,350);
    myWindow.setLocation(350,250);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
@SuppressWarnings("serial")
class Gui15radioButtonsIconsClass extends JFrame
{
  private String    deliveryPromptStr = "Preferred method of delivery: ";          // fields
  private JLabel    deliveryPrompt    = new JLabel(deliveryPromptStr);
  private JTextArea orderSummary;
  private char      shipType;
  private int       payType;

  public Gui15radioButtonsIconsClass()                              // constructor
  {
    super("Radio Buttons Demo");

    JRadioButton rbShip1 = new JRadioButton("cd"      ,new ImageIcon("cdrom.gif"));
    JRadioButton rbShip2 = new JRadioButton("diskette",new ImageIcon("disk1red.gif"));
    JRadioButton rbShip3 = new JRadioButton("email"   ,new ImageIcon("connec.gif"));
    JRadioButton rbShip4 = new JRadioButton("fax"     ,new ImageIcon("fax.gif"));
    ButtonGroup  btnGrp1 = new ButtonGroup();
    btnGrp1.add(rbShip1);
    btnGrp1.add(rbShip2);
    btnGrp1.add(rbShip3);
    btnGrp1.add(rbShip4);
    JPanel       pnlA    = new JPanel();
    pnlA.add(rbShip1);
    pnlA.add(rbShip2);
    pnlA.add(rbShip3);
    pnlA.add(rbShip4);

    JRadioButton payBtn1 = new JRadioButton("VISA");
    JRadioButton payBtn2 = new JRadioButton("MC");
    ButtonGroup  btnGrp2 = new ButtonGroup();
    btnGrp2.add(payBtn1);
    btnGrp2.add(payBtn2);
    JPanel       pnlB    = new JPanel();
    pnlB.add(payBtn1);
    pnlB.add(payBtn2);

    JButton  processOrderBtn  = new JButton("Process Order");
    JPanel   pob              = new JPanel();
    pob.add(processOrderBtn);

    JPanel pnl4          = new JPanel();
    pnl4.setLayout(new GridLayout(4,1));
    pnl4.add(deliveryPrompt);
    pnl4.add(pnlA);
    pnl4.add(pnlB);
    pnl4.add(pob);

    orderSummary = new JTextArea("Order Summary");
    orderSummary.setEditable(false);

    setLayout(new GridLayout(2,1));
    add(pnl4);
    add(orderSummary);

    ButtonHdlrShipA bhShipA = new ButtonHdlrShipA();
    ButtonHdlrShipB bhShipB = new ButtonHdlrShipB();
    ButtonHdlrShipC bhShipC = new ButtonHdlrShipC();
    ButtonHdlrShipD bhShipD = new ButtonHdlrShipD();

    ButtonHdlrPayA bhPayA = new ButtonHdlrPayA();
    ButtonHdlrPayB bhPayB = new ButtonHdlrPayB();

    ButtonHdlrProcOrd bhProcOrd = new ButtonHdlrProcOrd();

    rbShip1.addActionListener(bhShipA);
    rbShip2.addActionListener(bhShipB);
    rbShip3.addActionListener(bhShipC);
    rbShip4.addActionListener(bhShipD);

    payBtn1.addActionListener(bhPayA);
    payBtn2.addActionListener(bhPayB);

    processOrderBtn.addActionListener(bhProcOrd);
  }
//------------------------inner classes-----------------------------------------
  private class ButtonHdlrShipA implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      shipType = 'c';
      deliveryPrompt.setText(deliveryPromptStr + "CD-ROM");
    }     //deliveryPrompt and deliveryPromptStr must be defined as fields
  }                                                 //to be accessible here.
//------------------------------------------------------------------------------
  private class ButtonHdlrShipB implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      shipType = 'd';
      deliveryPrompt.setText(deliveryPromptStr + "diskette");
    }
  }
//------------------------------------------------------------------------------
  private class ButtonHdlrShipC implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      shipType = 'e';
      deliveryPrompt.setText(deliveryPromptStr + "e-mail");
    }
  }
//------------------------------------------------------------------------------
  private class ButtonHdlrShipD implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      shipType = 'f';
      deliveryPrompt.setText(deliveryPromptStr + "fax");
    }
  }
//------------------------------------------------------------------------------
  private class ButtonHdlrPayA implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      payType = 1; //1=visa
    }
  }
//------------------------------------------------------------------------------




//------------------------------------------------------------------------------
  private class ButtonHdlrPayB implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      payType = 2; //2=mastercard
    }
  }
//------------------------------------------------------------------------------
  private class ButtonHdlrProcOrd implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String msg = "Order Processed\n\n";
      String ship;
      String pay;
      switch(shipType)
      {
        case 'c': ship = "CD-ROM"  ; break;
        case 'd': ship = "diskette"; break;
        case 'e': ship = "email"   ; break;
        case 'f': ship = "fax"     ; break;
        default : ship = "not selected";
      }
      if(payType==1)
        pay = "VISA";
      else
      if(payType==2)
        pay = "MC";
      else
        pay = "not selected";

      msg += "Delivery Method: " + ship;
      msg += "\nPayment Option: " + pay;

      orderSummary.setText(msg);
      orderSummary.setFont(new Font("Serif", Font.PLAIN, 18));
      orderSummary.setForeground(Color.RED);
    }
  }
//------------------------------------------------------------------------------
}//end outer class
