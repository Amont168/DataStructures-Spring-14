//==========================================================================================
// Demo Gui10: Demo of nested panels
//==========================================================================================
import javax.swing.*;
public class Gui10dvr
{
  public static void main(String[] args)
  {
    Gui10nestedPanels myWindow = new Gui10nestedPanels();

    myWindow.setSize    (400,200);
    myWindow.setLocation(400,200);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setVisible(true);
  }
}
