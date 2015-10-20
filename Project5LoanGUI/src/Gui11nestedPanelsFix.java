//==========================================================================================
// Demo Gui11: Combines two class files and uses nested panels.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui11nestedPanelsFix
{
  public static void main(String[] args)
  {
    Gui11nestedPanelsFixClass myWindow;
    myWindow = new Gui11nestedPanelsFixClass();
    myWindow.setSize    (700,200);
    myWindow.setLocation(200,100);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setVisible(true);
  }
}
//------------------------------------------------------------------------------------------
@SuppressWarnings("serial")
class Gui11nestedPanelsFixClass extends JFrame  //can't be "public"
{
  public Gui11nestedPanelsFixClass() //constructor
  {
    super("Nested Panels Fixed");
    JPanel        panelNACSZ     = new JPanel();  //left half of window
    JPanel        panelSZ        = new JPanel();  //right half of bottom row of left half
    JPanel        panelAll       = new JPanel();

    JLabel        fnameLabel     = new JLabel("First Name");
    JTextField    fnameTxtFld    = new JTextField();
    JLabel        lnameLabel     = new JLabel("Last Name");
    JTextField    lnameTxtFld    = new JTextField();
    JLabel        addrLabel      = new JLabel("Address");
    JTextField    addrTxtFld     = new JTextField();
    JLabel        cityLabel      = new JLabel("City");
    JTextField    cityTxtFld     = new JTextField();
    JLabel        stLabel        = new JLabel("State");
    JTextField    stTxtFld       = new JTextField();
    JLabel        zipLabel       = new JLabel("Zip");
    JTextField    zipTxtFld      = new JTextField();
    JTextArea     miscNotes      = new JTextArea    ("Enter notes here");

    panelSZ.setLayout(new GridLayout(1,3));      //panel for st, zip label & zip
    panelSZ.add(stTxtFld);
    panelSZ.add(zipLabel);
    panelSZ.add(zipTxtFld);

    panelNACSZ.setLayout(new GridLayout(5,2));   // name,address,city,st,zip panel
    panelNACSZ.add(fnameLabel);   //row 1 label and field
    panelNACSZ.add(fnameTxtFld);
    panelNACSZ.add(lnameLabel);   //row 2 label and field
    panelNACSZ.add(lnameTxtFld);
    panelNACSZ.add(addrLabel);    //row 3 label and field
    panelNACSZ.add(addrTxtFld);
    panelNACSZ.add(cityLabel);    //row 4 label and field
    panelNACSZ.add(cityTxtFld);
    panelNACSZ.add(stLabel);      //row 5 label and panel
    panelNACSZ.add(panelSZ);

    panelAll.setLayout(new GridLayout(1,2));     // the big outter panel
    panelAll.add(panelNACSZ);
    panelAll.add(miscNotes);
    add(panelAll);                               // add panel to frame
  }
}