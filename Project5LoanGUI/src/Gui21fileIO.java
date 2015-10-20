//==========================================================================================
// Gui21 GUI with simple file i/o       (Revised 04/20/12)
// Constructor: Reads a list of names from a file and puts them in left text area.
// Copy Button: Gets names from left text area, converts them to upper case,
//              puts them into right text area.
// Save Button: Gets contents of right text area and writes it to a file.
//
// A data file named gui21dataIn.txt is required. You can copy/paste these or create your own.
/*
Anna
Betty
Cindy
Debbie
Eva
Fran
Gina
Heidi
Ida
Jeannie
*/
//==========================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Gui21fileIO
{
  public static void main( String args[] ) throws IOException
  {
    Gui21fileIOClass myWindow = new Gui21fileIOClass();
    myWindow.setSize(400,300);
    myWindow.setLocation(300,200);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
//==========================================================================================
@SuppressWarnings("serial")
class Gui21fileIOClass extends JFrame
{
  private JTextArea  txtAreaLeft;                                                  // fields
  private JTextArea  txtAreaRight;
  //----------------------------------------------------------------------------------------
  public Gui21fileIOClass()   throws IOException                              // constructor
  {
    super("Simple File I/O");
    FileReader      diskfile = new FileReader("gui21dataIn.txt");
    BufferedReader  stufile  = new BufferedReader(diskfile);

    txtAreaLeft              = new JTextArea();
    txtAreaRight             = new JTextArea();
    JPanel          txtPnl   = new JPanel();

    JButton         copyBtn  = new JButton("Copy");
    JButton         saveBtn  = new JButton("Save");
    JPanel          btnPnl   = new JPanel();

    String          rec;
    String          names    = "";

    setLayout(new BorderLayout(0,0));

    txtPnl.setLayout(new GridLayout(1,2));
    txtPnl.add(txtAreaLeft);
    txtPnl.add(txtAreaRight);
    add(txtPnl,BorderLayout.CENTER);

    btnPnl.setLayout(new GridLayout(1,2));
    btnPnl.add(copyBtn);
    btnPnl.add(saveBtn);
    add(btnPnl,BorderLayout.SOUTH);

    while((rec = stufile.readLine()) != null)
      names = names + (rec + "\n");

    txtAreaLeft.setText(names);

    CopyHandler copyHdlr = new CopyHandler();  //instantiate handlers
    SaveHandler saveHdlr = new SaveHandler();

    copyBtn.addActionListener(copyHdlr);       //register handlers
    saveBtn.addActionListener(saveHdlr);

    stufile.close();
  }//end constructor
  //----------------------------------------------------------------------------------------
  // Copy names from left text area to right text area (and upper case them).
  //----------------------------------------------------------------------------------------
  private class CopyHandler implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      String nameList;
      nameList = txtAreaLeft.getText();
      nameList = nameList.toUpperCase();
      txtAreaRight.setText(nameList);
    }
  }//end inner class
  //----------------------------------------------------------------------------------------
  // Get names from right text area and write them to a file.
  //
  // Note: use of try/catch required because abstract method actionPerformed doesn't have
  //       throws IOException, and doesn't allow it to be added when implemented.
  //----------------------------------------------------------------------------------------
  private class SaveHandler implements ActionListener
  {
    public void actionPerformed( ActionEvent event )
    {
      try
        {
          FileWriter  fw       = new FileWriter("gui21dataOut.txt");
          PrintWriter pw       = new PrintWriter(fw);
          String      nameList = txtAreaRight.getText();
          pw.write(nameList);
          pw.close();
          JOptionPane.showMessageDialog(null,"File created:\n\n" + nameList);
        }
      catch(IOException e)
        {
          System.out.println("file output error");
        }
    }
  }//end inner class
  //----------------------------------------------------------------------------------------
}//end outer class
