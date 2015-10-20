//==========================================================================================
// Demo Gui02frameWithOneButton: Adding a button component.
//==========================================================================================
import javax.swing.*;

public class Gui02frameWithOneButton
{
  @SuppressWarnings("static-access")
public static void main(String[] args)
  {
    JFrame  myFrame  = new JFrame("Gui02 Adding components to a frame");  //create frame
    JButton myButton = new JButton("My big button, click on me");         //create button



    myFrame.add(myButton);                                      //attach button to the frame

    myFrame.setSize(350,200);
    myFrame.setLocation(300,150);
    myFrame.setVisible(true);
    myFrame.setDefaultCloseOperation(myFrame.EXIT_ON_CLOSE);
  }
}
//------------------------------------------------------------------------------------------
//Note that the button fills the entire frame.
//Adding a layout manager will reduce the size of the button to what would be normal.
//This is something you usually do, but, you need to know what happens when you don't.

//To see the difference you can add a layout manager with the following two statements:
//import java.awt.*;                         //place on line 5 above
//    myFrame.setLayout(new FlowLayout() );  //place on line 13 above
//------------------------------------------------------------------------------------------
