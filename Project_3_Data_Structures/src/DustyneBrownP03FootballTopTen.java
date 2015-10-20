//===============================================================================
// Project : Project 3 Football Top Ten
// Author : Dustyne Brown
// Date : 9/27/13
// Abstract: Create a GUI of buttons with team names that are unscripted, and
// an array of radio buttons to click in order to move teams.
//===============================================================================

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DustyneBrownP03FootballTopTen 
{
  
  static int lstSlctn = 0;                        //Used to keep track of last selected button.
  
  static ButtonGroup grp = new ButtonGroup();     //Button Grouping for radio buttons. (Here in order to be used
                                                  // in the action event.)
  
  static JButton[] tmBttn = new JButton[10];      //Array of buttons with the team names on them. (Here in order
                                                  // to be used in the Action event.)  
  
  public static void main(String[] args) 
  {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //Used to launch the window in the 
                                                                          //middle of the screen.
    
    int frameXSize = 400;                       //Declaration of the window dimensions.
    int frameYSize = 400;
    
    int screenHeight = screenSize.height;       //Variables used in order to calculate the center of the 
    int screenWidth = screenSize.width;         // monitor.
    int xLoc = (screenWidth / 2) - (frameXSize / 2);
    int yLoc = (screenHeight / 2) - (frameYSize / 2);
    
    JFrame frame = new JFrame("Dustyne Brown - Top Ten Teams");
    
    frame = ContainerConstructor(frame);        //Passes the frame to a method that places 
                                                // everything within it.
    
    frame.setSize(frameXSize, frameYSize);      //Sets all frame settings and launches the program.
    frame.setLocation(xLoc, yLoc);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  }
  
//--------------------------------------------------------------------------------- 
  
  private static JFrame ContainerConstructor(JFrame frame)
  {
    JPanel bttnPnl = new JPanel();              //Declaration of the 2 panels that create the program.
    JPanel tmPnl = new JPanel();
    
    JRadioButton[] rnkRBttn = new JRadioButton[10];   //Array of Radio Buttons for movement selection.
    
    String[] teamList = new String[10];         //Array of strings containing the team names.
    
    Listener lstnr = new Listener();            //Declaration for the radio button's action listener.
    
    int x;
    
    teamList = TeamListFiller(teamList);        //Passes the String Array to be filled with team names.
    
    bttnPnl.setLayout(new GridLayout(10,1));
    tmPnl.setLayout(new GridLayout(10,1));
    
    for( x = 0; x < 10; x++)
      {
        rnkRBttn[x] = new JRadioButton(Integer.toString(x + 1));  //Sets text for both buttons added in 
        tmBttn[x] = new JButton(teamList[x]);                     // the loop.
        
        rnkRBttn[x].setFont(new Font("Courier", Font.PLAIN, 36)); //Sets fonts for both buttons.
        tmBttn[x].setFont(new Font("Courier", Font.PLAIN, 36));
        
        rnkRBttn[x].addActionListener(lstnr);         //Adds the action listener to the radio buttons.
        
        tmBttn[x].setHorizontalAlignment(SwingConstants.LEFT);  //Aligns team names.
        
        grp.add(rnkRBttn[x]);         //Adds the Radio Buttons to their group.
        
        bttnPnl.add(rnkRBttn[x]);     //Adds both buttons to their panels.
        tmPnl.add(tmBttn[x]);
      }
    
    frame.setLayout(new BorderLayout());
      
    frame.add(bttnPnl, BorderLayout.WEST);    //Adds both panels to the frame.
    frame.add(tmPnl, BorderLayout.CENTER);
    
    return frame;
  }

//--------------------------------------------------------------------------------- 

  private static String[] TeamListFiller(String[] teamList)
  {
    teamList[0] = "Arkansas";     //Quickly adds team names into the String array teamList.
    teamList[1] = "Texas";        // (Performed here to keep the 'busier' code above a little simpler.)
    teamList[2] = "OU";
    teamList[3] = "OSU";
    teamList[4] = "USC";
    teamList[5] = "LSU";
    teamList[6] = "TCU";
    teamList[7] = "Florida";
    teamList[8] = "SMU";
    teamList[9] = "Texas Tech";
    
    return teamList;
  }
  
//--------------------------------------------------------------------------------- 
  
  private static class Listener implements ActionListener       //Script to used whenever a radio button 
  {                                                           // is pressed.
    public void actionPerformed(ActionEvent event)
    {
      int crrntSlctn = Integer.parseInt(event.getActionCommand());  //Grabs the button just pressed.
      
      if(lstSlctn == crrntSlctn)          //Clears button Focus if the same button is pressed twice.
      {                                   // (Done in order to make re-arranging a little simpler.)
        grp.clearSelection();
        
        crrntSlctn = 0;
      }
      else
        if(lstSlctn != 0)                 //Ensures the user wants to move and wasn't preparing to.
        {
          TeamMover(lstSlctn, crrntSlctn);  //Passes the two selections to a method to re-order teams.
        }
      
      lstSlctn = crrntSlctn;              //Updates last selected button.
    }
    
//--------------------------------------------------------------------------------- 
    
    private void TeamMover(int lstSlctn, int crrntSlctn)
    {
      String temp = "";
    
      int x = 0;
    
      int gap = lstSlctn - crrntSlctn;                            //Calculates number of moves needed.
              
      if(gap < 0)                                                 //Moves from lower number to higher.
        {
          temp = tmBttn[lstSlctn - 1].getText();
        
          gap = gap * -1;
          
          for(x = 0; x < gap; x++)
            {
              tmBttn[(lstSlctn - 1) + x].setText(tmBttn[lstSlctn + x].getText());
            }
          
          tmBttn[crrntSlctn - 1].setText(temp);
        }
      else
        if(gap > 0)                                             //Moves from higher to lower spots.
          {
            temp = tmBttn[lstSlctn - 1].getText();
          
            for(x = 1; x <= gap; x++)
              {
                tmBttn[(lstSlctn - x)].setText(tmBttn[(lstSlctn - 1) - x].getText());
              }
          
            tmBttn[crrntSlctn - 1].setText(temp);
          }
      
    }
    
  }
  
}


