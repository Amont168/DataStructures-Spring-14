//==========================================================================================
// Demo Gui10: Demo of nested panels.
// Note: This example will have textareas with undesirable sizes.
//       Later examples will fix this.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Gui10nestedPanels extends JFrame
{
  public Gui10nestedPanels() //constructor
  {
    super("Nested Panels");

    JPanel        panelNAC       = new JPanel();  //holds components: name, address, city
    JPanel        panelSZ        = new JPanel();  //holds components: state, zip
    JPanel        panelNACSZ     = new JPanel();  //holds both of the above panels
    JPanel        panelAll       = new JPanel();  //everything

    JLabel        fnameLabel     = new JLabel("First Name");
    JTextField    fnameTxtFld    = new JTextField();
    JLabel        lnameLabel     = new JLabel("Last Name");
    JTextField    lnameTxtFld    = new JTextField();
    JLabel        addrLabel      = new JLabel("Address");
    JTextField    addrTxtFld     = new JTextField();
    JLabel        cityLabel      = new JLabel("City");
    JTextField    cityTxtFld     = new JTextField();

    panelNAC.setLayout(new GridLayout(4,2));  // name/address/city panel
    panelNAC.add(fnameLabel);
    panelNAC.add(fnameTxtFld);
    panelNAC.add(lnameLabel);
    panelNAC.add(lnameTxtFld);
    panelNAC.add(addrLabel);
    panelNAC.add(addrTxtFld);
    panelNAC.add(cityLabel);
    panelNAC.add(cityTxtFld);

    JLabel     stLabel   = new JLabel("State");
    JTextField stTxtFld  = new JTextField ();
    JLabel     zipLabel  = new JLabel("Zip");
    JTextField zipTxtFld = new JTextField ();

    panelSZ.setLayout(new GridLayout(1,4));   // st/zip panel
    panelSZ.add(stLabel);
    panelSZ.add(stTxtFld);
    panelSZ.add(zipLabel);
    panelSZ.add(zipTxtFld);

    panelNACSZ.setLayout(new GridLayout(2,1));// name/address/city/st/zip panel
    panelNACSZ.add(panelNAC);  //top half of left half
    panelNACSZ.add(panelSZ);   //bottom half of left half
                               //Result not desirable. Fixed in next program.

    JTextArea miscNotes = new JTextArea("Enter notes here");

    panelAll.setLayout(new GridLayout(1,2)); // the big outter panel
    panelAll.add(panelNACSZ);
    panelAll.add(miscNotes);

    add(panelAll);                           // add panel to frame
  }                                          // this.add(panelAll); alternative
}
