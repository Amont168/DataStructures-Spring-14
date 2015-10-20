//==========================================================================================
// Demo Gui03: Multiple button components with a layout manager.
//
// See the following link for layout managers:
// http://java.sun.com/docs/books/tutorial/uiswing/layout/using.html
//
// Note on import statements:
// Generally, J components are in javax.swing.
// Some layout managers are in javax.swing and some are in java.awt
//
// Also shows centering a window.
//==========================================================================================
import javax.swing.*;
import java.awt.*;
public class Gui03frame10ButtonsFlowLayout
{
  public static void main(String[] args)
  {
    Toolkit   toolKitVar;
    Dimension windowDimVar;

    JFrame  myFrame  = new JFrame("10 Button Window with FlowLayout");//create frame
    JButton myButton1   = new JButton("OK 1");                        //create buttons
    JButton myButton2   = new JButton("OK 2");
    JButton myButton3   = new JButton("OK 3");
    JButton myButton4   = new JButton("OK 4");
    JButton myButton5   = new JButton("OK 5");
    JButton myButton6   = new JButton("OK 6");
    JButton myButton7   = new JButton("OK 7");
    JButton myButton8   = new JButton("OK 8");
    JButton myButton9   = new JButton("OK 9");
    JButton myButton10  = new JButton("OK 10");

    myFrame.setLayout(new FlowLayout() );  //establish how components will be arranged.

    myFrame.add(myButton1);                //attach buttons to the frame
    myFrame.add(myButton2);
    myFrame.add(myButton3);
    myFrame.add(myButton4);
    myFrame.add(myButton5);
    myFrame.add(myButton6);
    myFrame.add(myButton7);
    myFrame.add(myButton8);
    myFrame.add(myButton9);
    myFrame.add(myButton10);

    toolKitVar   = Toolkit.getDefaultToolkit();
    windowDimVar = toolKitVar.getScreenSize();

    //windowDimVar = Toolkit.getDefaultToolkit().getScreenSize();  //another way

    System.out.println("Screen width  = " + windowDimVar.width);
    System.out.println("Screen height = " + windowDimVar.height);

    myFrame.setSize(400,200);
    myFrame.setLocation(windowDimVar.width/2-200,windowDimVar.height/2-100);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);

  }
}
// To center the window:
// divide screen width by 2 and subtract half the window width     windowDimVar.width/2-200
// divide screen height by 2 and subtract half the window height   windowDimVar.height/2-100
// (for a 400w x 200h window)
