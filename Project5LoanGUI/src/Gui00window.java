//==========================================================================================
// Demo Gui00window: Basic Window (not decorated, just a gray box)
// Note: Use Crimson Editor "kill process" (right-click output area) to exit program.
//==========================================================================================
import javax.swing.*;
public class Gui00window
{
  public static void main(String[] args)
  {
    JWindow myWindow = new JWindow();
    myWindow.setSize(400,300);      //width,height (in pixels)
    myWindow.setLocation(300,200);  //right,down   (from upper left corner in pixels)
    myWindow.setVisible(true);
  }
}

//    Note: EXIT_ON_CLOSE is a field in class JFrame so the following won't work:
//            myWindow.setDefaultCloseOperation(myWindow.EXIT_ON_CLOSE);
