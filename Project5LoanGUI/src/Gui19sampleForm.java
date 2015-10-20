//==============================================================================
// Demo Gui19: Example data entry form.
// Provides info on managers, alignment and other things.
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui19sampleForm
{
  public static void main( String args[] )
  {

    Gui19sampleFormClass myWindow = new Gui19sampleFormClass();
    myWindow.setSize(500,400);
    myWindow.setLocation(100,50);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
//------------------------------- class ----------------------------------------
@SuppressWarnings("serial")
class Gui19sampleFormClass extends JFrame
{
  private JLabel       lbl1;
  private JLabel       lbl2;
  private JLabel       lbl3;
  private JLabel       lbl4;
  private JTextField   tf1;
  private JTextField   tf2;
  private JTextField   tf3;
  private JTextField   tf4;
  private JRadioButton rbtn1;
  private JRadioButton rbtn2;
  private JRadioButton rbtn3;
  private JRadioButton rbtn4;
  private JCheckBox    ckbox1;
  private JCheckBox    ckbox2;
  private JCheckBox    ckbox3;
  private JCheckBox    ckbox4;
  private JButton      btnProcess;
  private JButton      btnClearLeft;
  private JButton      btnClearRight;
  private JTextArea    txtArea;
//------------------------------------------------------------------------------
  public Gui19sampleFormClass()                               // constructor
  {
    super("Form with three handlers");

    setLayout(new GridLayout(13,2));

    lbl1   = new JLabel("  First Name");
    lbl2   = new JLabel("   Last Name");
    lbl3   = new JLabel(" Street Addr");
    lbl4   = new JLabel("City, ST Zip");
    lbl1.setFont(new Font("Courier", Font.BOLD, 14));
    lbl2.setFont(new Font("Courier", Font.BOLD, 14));
    lbl3.setFont(new Font("Courier", Font.PLAIN, 14));
    lbl4.setFont(new Font("Courier", Font.PLAIN, 14));
    tf1    = new JTextField(10);
    tf2    = new JTextField(10);
    tf3    = new JTextField(10);
    tf4    = new JTextField(10);
    JPanel pnlName1 = new JPanel();
//  pnlName1.setLayout(new FlowLayout()); //see difference
    pnlName1.setLayout(new BoxLayout(pnlName1, BoxLayout.LINE_AXIS));
    pnlName1.add(lbl1);
    pnlName1.add(tf1);
    JPanel pnlName2 = new JPanel();
//  pnlName2.setLayout(new FlowLayout()); //see difference
    pnlName2.setLayout(new BoxLayout(pnlName2, BoxLayout.LINE_AXIS));
    pnlName2.add(lbl2);
    pnlName2.add(tf2);
    JPanel pnlName3 = new JPanel();
//  pnlName3.setLayout(new FlowLayout()); //see difference
    pnlName3.setLayout(new BoxLayout(pnlName3, BoxLayout.LINE_AXIS));
    pnlName3.add(lbl3);
    pnlName3.add(tf3);
    JPanel pnlName4 = new JPanel();
//  pnlName4.setLayout(new FlowLayout()); //see difference
    pnlName4.setLayout(new BoxLayout(pnlName4, BoxLayout.LINE_AXIS));
    pnlName4.add(lbl4);
    pnlName4.add(tf4);

    rbtn1  = new JRadioButton("Fresh");
    rbtn2  = new JRadioButton("Soph");
    rbtn3  = new JRadioButton("Jr");
    rbtn4  = new JRadioButton("Sr");
    ButtonGroup  btnGrp1 = new ButtonGroup();  //not a panel
    btnGrp1.add(rbtn1);
    btnGrp1.add(rbtn2);
    btnGrp1.add(rbtn3);
    btnGrp1.add(rbtn4);
    rbtn1.setSelected(true);
    JPanel pnlRB = new JPanel();
    pnlRB.setLayout(new FlowLayout());
    pnlRB.add(rbtn1);
    pnlRB.add(rbtn2);
    pnlRB.add(rbtn3);
    pnlRB.add(rbtn4);

    ckbox1 = new JCheckBox("AR Resident");
    ckbox2 = new JCheckBox("Pell Grant");
    ckbox3 = new JCheckBox("Scholarship");
    ckbox4 = new JCheckBox("Non-credit");

    btnProcess        = new JButton("Process");
    JPanel pnlBtnProc = new JPanel();   //to get smaller button
    pnlBtnProc.setLayout(new FlowLayout());
    pnlBtnProc.add(btnProcess);

    btnClearLeft         = new JButton("Clear Left");
    JPanel pnlBtnClrLeft = new JPanel();
    pnlBtnClrLeft.setLayout(new FlowLayout());
    pnlBtnClrLeft.add(btnClearLeft);

    btnClearRight         = new JButton("Clear Right");
    JPanel pnlBtnClrRight = new JPanel();
    pnlBtnClrRight.setLayout(new FlowLayout());
    pnlBtnClrRight.add(btnClearRight);

    JPanel pnlClrBtns = new JPanel();
    pnlClrBtns.setLayout(new GridLayout(1,2));
    pnlClrBtns.add(pnlBtnClrLeft);
    pnlClrBtns.add(pnlBtnClrRight);

    JPanel pnlLeft = new JPanel();
    pnlLeft.setLayout(new GridLayout(11,1));
    pnlLeft.add(pnlName1);
    pnlLeft.add(pnlName2);
    pnlLeft.add(pnlName3);
    pnlLeft.add(pnlName4);
    pnlLeft.add(pnlRB);
    pnlLeft.add(ckbox1);
    pnlLeft.add(ckbox2);
    pnlLeft.add(ckbox3);
    pnlLeft.add(ckbox4);
    pnlLeft.add(pnlBtnProc);
    pnlLeft.add(pnlClrBtns);

    txtArea = new JTextArea();

    setLayout(new GridLayout(1,2));
    add(pnlLeft);
    add(txtArea);

    TxtFldHdlr tfHdlr = new TxtFldHdlr();
    tf1.addActionListener(tfHdlr);
    tf2.addActionListener(tfHdlr);
    tf3.addActionListener(tfHdlr);
    tf4.addActionListener(tfHdlr);

    ProcessFormHdlr formHdlr = new ProcessFormHdlr();
    btnProcess.addActionListener(formHdlr);

    ClearLeftHdlr clh = new ClearLeftHdlr();
    btnClearLeft.addActionListener(clh);

    ClearRightHdlr crh = new ClearRightHdlr();
    btnClearRight.addActionListener(crh);
  }                                                              //inner classes
//-----------------Handler to advance focus for text fields---------------------
  private class TxtFldHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      if(tf1.hasFocus())
        tf2.requestFocus();
      else
      if(tf2.hasFocus())
        tf3.requestFocus();
      else
      if(tf3.hasFocus())
        tf4.requestFocus();
      else
        tf1.requestFocus();
    }
  }
//------------------Handler to process form when Process button pressed---------
  private class ProcessFormHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      int    i;
      String fname;
      String lname;
      String name;
      String street;
      String csz;
      String yr = "";
      String resStat;
      String ageStat;
      String hsStat;
      String crStat;
      String msg;

      fname  = tf1.getText();
      lname  = tf2.getText();
      name   = lname + ", " + fname;
      street = tf3.getText();
      csz    = tf4.getText();

      if(rbtn1.isSelected())
        yr = "Freshman";
      else
      if(rbtn2.isSelected())
        yr = "Sophomore";
      else
      if(rbtn3.isSelected())
        yr = "Junior";
      else
      if(rbtn4.isSelected())
        yr = "Senior";

      if(ckbox1.isSelected())
        resStat = "In-state tuition rates apply";
      else
        resStat = "Non-resident rates apply";

      if(ckbox2.isSelected())
        ageStat = "Grant funds applied";
      else
        ageStat = "";

      if(ckbox3.isSelected())
        hsStat = "Scholarship applied";
      else
        hsStat = "";

      if(ckbox4.isSelected())
        crStat = "Not transcripted";
      else
        crStat = "Will be transcripted";

      msg  = name    + "\n";
      msg += street  + "\n";
      msg += csz     + "\n";
      msg += "_______________________\n";
      msg += yr      + "\n";
      msg += resStat + "\n";
      msg += ageStat + "\n";
      msg += hsStat  + "\n";
      msg += crStat;

      tf1.setEditable(false); //very light gray

      Color myKakhi = new Color(255,246,143);
      tf3.setBackground(myKakhi);
      tf4.setBackground(Color.lightGray);

      txtArea.setText(msg);
      txtArea.setBackground(Color.YELLOW);
      txtArea.setFont(new Font("Courier", Font.PLAIN, 14));
    }
  }
//------------------Handler to clear data entry fields on left----------------
  private class ClearLeftHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      tf1.setText("");
      tf2.setText("");
      tf3.setText("");
      tf4.setText("");
      tf1.setEditable(true);
      tf3.setBackground(Color.white);
      tf4.setBackground(Color.white);
      rbtn1.setSelected(true);
      ckbox1.setSelected(false);
      ckbox2.setSelected(false);
      ckbox3.setSelected(false);
      ckbox4.setSelected(false);
      tf1.requestFocus();
    }
  }
//------------------------------------------------------------------------------











//------------------Handler to clear the large text area on the right-----------
  private class ClearRightHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      txtArea.setText("");
      txtArea.setBackground(Color.WHITE);
    }
  }
}//end outer class
//------------------------------notes-------------------------------------------
//Helpful methods when trying to decide on a window size.
//    System.out.println(getWidth());   //provides current width of window
//    System.out.println(getHeight());  //provides current height of window

//Good reference:
//http://www.leepoint.net/notes-java/index.html
//http://www.leepoint.net/notes-java/GUI/components/30textfield/11textfield.html

//Looks like a good layout manager for forms, if only it worked.
//http://java.sun.com/docs/books/tutorial/uiswing/layout/spring.html (compile error)

// Color chart
//http://www.pitt.edu/~nisg/cis/web/cgi/rgb.html
//255 246 143 khaki1
