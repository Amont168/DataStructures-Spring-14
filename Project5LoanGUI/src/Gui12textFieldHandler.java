//==========================================================================================
// Demo Gui12 driver             Multiple components using one event handler
//==========================================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui12textFieldHandler
{
   public static void main( String args[] )
   {
      Gui12textFieldHandlerClass myWindow = new Gui12textFieldHandlerClass();
      myWindow.setSize(325,100);
      myWindow.setLocation(400,200);
      myWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      myWindow.setVisible( true );
   }
}
//==========================================================================================
// Demo Gui12 class (shows problem with registering multiple components with one handler)
//==========================================================================================
@SuppressWarnings("serial")
class Gui12textFieldHandlerClass extends JFrame
{
  public Gui12textFieldHandlerClass()                                          //constructor
  {
    super("Text Field Handler");
    setLayout(new GridLayout(3,2));
    JLabel     labelA   = new JLabel("F Name");
    JLabel     labelB   = new JLabel("M Name");
    JLabel     labelC   = new JLabel("L Name");
    JTextField txtFldA  = new JTextField(20);
    JTextField txtFldB  = new JTextField(20);
    JTextField txtFldC  = new JTextField(20);
    add(labelA);
    add(txtFldA);
    add(labelB);
    add(txtFldB);
    add(labelC);
    add(txtFldC);
    MyTextFieldHdlr handler = new MyTextFieldHdlr();//create an object to handle events
    txtFldA.addActionListener(handler);             //register event handler with components
    txtFldC.addActionListener(handler);             //Note: M Name not registered for demo.
  }

  //-------------------------------------------------------------------- private inner class
  private class MyTextFieldHdlr implements ActionListener
  {
    public void actionPerformed( ActionEvent event )  // method to process a component event
    {
       String string;

       string =  event.getActionCommand();//get data from component that triggered the event

       System.out.println("You entered: " + string);
       JOptionPane.showMessageDialog( null, "You entered:  " + string );
    }
  }//end inner class
}//end outer class

/*------------------------------------------------------------------------------------------
Inner classes are used to create "special purpose objects" that
wouldn't have any usefulness to another program, and, more importantly
have direct access to fields of the outer class (no shown in this example).

Event handlers are usually coded such that they would only be useful
to the outer class. This example doesn't show you, but, the
event handler typically will need to access variables defined in the
outer class.

Note that an inner class CAN have a visibility modifier, and it is usually "private", in
contrast to having two classes in the same file which can have only one public class.

Look at your directory listing to see the names of the class files generated.
------------------------------------------------------------------------------------------*/
