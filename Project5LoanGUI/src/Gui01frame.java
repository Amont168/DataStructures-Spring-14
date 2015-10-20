//==========================================================================================
// Demo Gui01Frame: Basic Window (a frame is a "decorated" window)
// Note: click "X" button to close the window.
//==========================================================================================
import javax.swing.*;
public class Gui01frame
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame("The Window Title Goes Here (if desired)");
    frame.setSize(400,300);      //width,height in pixels
    frame.setLocation(300,150);  //from upper left: pixels right,pixels down
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

// Other useful information:
//    import java.awt.Toolkit;
//    import java.awt.Dimension;
//    Toolkit   tk = Toolkit.getDefaultToolkit();
//    Dimension d  = tk.getScreenSize();
//    System.out.println("Screen width  = " + d.width);
//    System.out.println("Screen height = " + d.height);
