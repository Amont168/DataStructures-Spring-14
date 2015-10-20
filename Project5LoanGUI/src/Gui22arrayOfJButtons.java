//==========================================================================================
// Demo Gui22: An array of JButton demo
//==========================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui22arrayOfJButtons
{
  public static void main( String args[] )
  {

    Gui22arrayOfJButtonsClass myWindow = new Gui22arrayOfJButtonsClass();
    myWindow.setSize(300,350);
    myWindow.setLocation(100,100);
    myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    myWindow.setVisible( true );
  }
}
//==========================================================================================
@SuppressWarnings("serial")
class Gui22arrayOfJButtonsClass extends JFrame
{

  JTextArea    txtArea    = new JTextArea();                                        //fields
  JButton      petBtn[]   = new JButton[3]; //instantiate below in method
  JButton      dispBtn;
  JButton      clearBtn;
  JPanel       buttonPnl  = new JPanel();
  PetBtnHdlr   petHdlr    = new PetBtnHdlr();
  DispBtnHdlr  dispHdlr   = new DispBtnHdlr();
  ClearBtnHdlr clearHdlr  = new ClearBtnHdlr();

  public Gui22arrayOfJButtonsClass()                                          // constructor
  {
    super("Button Array Demo");

    buttonPnl.setLayout(new GridLayout(5,1));
    setUpPetButtons();
    setUpActionButtons();

    setLayout(new BorderLayout());
    add(buttonPnl,BorderLayout.WEST);
    add(txtArea,BorderLayout.CENTER);

  }
  //----------------------------------------------------------------------------------------
  private void setUpPetButtons()                                                    //method
  {
    String  buttonValues[]  = {"Dog" ,"Cat" ,"Bird"};
    for(int i=0;i<3;i++)                             // 1st 3 buttons
      {
        petBtn[i] = new JButton(buttonValues[i]);    //create button
        petBtn[i].addActionListener(petHdlr);        //add action listener
        buttonPnl.add(petBtn[i]);                    //add to panel
      }
  }
  //----------------------------------------------------------------------------------------
  private void setUpActionButtons()                                                 //method
  {
    dispBtn    = new JButton("Display");    //create 4th & 5th buttons
    clearBtn   = new JButton("Clear");
    buttonPnl.add(dispBtn);                 //adds to panel
    buttonPnl.add(clearBtn);
    dispBtn.addActionListener(dispHdlr);    //add action listeners
    clearBtn.addActionListener(clearHdlr);
  }
  //----------------------------------------------------------------------------------------
  private class PetBtnHdlr implements ActionListener                           //inner class
  {
    public void actionPerformed(ActionEvent e)
    {
      String taStr;
      String btnTxt;

      taStr   = txtArea.getText();       //get current list
      btnTxt  = e.getActionCommand();    //get text from button

      if(taStr.length()==0)
        taStr   = btnTxt;                //start list
      else
        taStr   = taStr + "\n" + btnTxt; //replace list

      txtArea.setText(taStr);
    }
  }
  //----------------------------------------------------------------------------------------
  private class DispBtnHdlr implements ActionListener                          //inner class
  {
    public void actionPerformed(ActionEvent e)
    {
      String taStr;
      taStr = txtArea.getText();
      JOptionPane.showMessageDialog(null,taStr); //show text area in JOpt window
    }
  }
  //----------------------------------------------------------------------------------------
  private class ClearBtnHdlr implements ActionListener                         //inner class
  {
    public void actionPerformed(ActionEvent e)
    {
      txtArea.setText("");  //clear text area
    }
  }
  //----------------------------------------------------------------------------------------
}
