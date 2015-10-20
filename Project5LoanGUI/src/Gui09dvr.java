//==========================================================================================
// Demo Gui09: Panel with GridLayout manager
//==========================================================================================
import javax.swing.*;
public class Gui09dvr
{
  public static void main(String[] args)
  {
    Gui09panel2filesGridLayout myWindow = new Gui09panel2filesGridLayout();

    myWindow.setSize    (700,300); // change numbers to see effect
    myWindow.setLocation(400,200);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setVisible(true);
  }
}
