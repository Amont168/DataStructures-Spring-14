//==========================================================================================
// Demo Gui08: Changes demo Gui07 to driver/class configuration.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui08dvr
{
  public static void main(String[] args)
  {
    Toolkit   toolKitVar   = Toolkit.getDefaultToolkit();
    Dimension windowDimVar = toolKitVar.getScreenSize();

    Gui08panelTwoFiles myWindow = new Gui08panelTwoFiles();

    myWindow.setSize    (700,200);
    myWindow.setLocation(windowDimVar.width/2-350,windowDimVar.height/2-100);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setVisible(true);
  }
}
