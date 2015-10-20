//==============================================================================
// Program  : Practical exam problem 3.
// Name     :                                                  // <--- YOUR NAME
// Date     : 05/01/2013
// Objective: Will be demonstrated in class at beginning of exam.
// 1. Enter a character or number into input field, and press enter.
// 2. What you have entered and what it converts to will appear below.
// 3. The input field is cleared and ready for the next entry.
// 4. If more than one character (eg: abc) is entered, only the 1st character
//    is to be used.
// 5. There are no restrictions or error handling for numeric entry.
// 6. IMPORTANT: clear the input field after pressing enter.
//==============================================================================
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class P03asciiConversionGuiDustyneBrown          // <--- YOUR NAME
{
  public static void main( String args[] )
  {
    AsciiConversionWindow myWindow = new AsciiConversionWindow();
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setSize(400,150 );
    myWindow.setLocation(200,300);
    myWindow.setVisible(true);
  }
}
//------------------------------------------------------------------------------
// Do not make any changes above this line.
// Make any other changes or additions needed to get the desired result.
//------------------------------------------------------------------------------
@SuppressWarnings("serial")
class AsciiConversionWindow extends JFrame
{
  private static JTextField txtInput;                                    // fields
  private static JLabel     lblResultChar;
  private static JLabel     lblResultInt;

  public AsciiConversionWindow()                                  // constructor
  {
      super("ASCII Converter");
      
      
     JPanel top = new JPanel();
     JPanel center = new JPanel();
     JPanel center1 = new JPanel();
     JPanel center2 = new JPanel();
      
     setLayout(new BorderLayout());
     add(top, BorderLayout.NORTH);
     top.setLayout(new BorderLayout());
     center.setLayout(new BorderLayout());
     center.add(center1, BorderLayout.WEST);
     center.add(center2, BorderLayout.EAST);
     add(center, BorderLayout.SOUTH);
     
     Dimension sizeCenter = new Dimension(400, 100);
     Dimension sizeCenter1 = new Dimension(200, 50);
     center.setPreferredSize(sizeCenter);
     center1.setPreferredSize(sizeCenter1);
     center2.setPreferredSize(sizeCenter1);
     
     
     
     
    

    JLabel lblPrompt  = new JLabel("Enter character or decimal value:");
    JLabel lblForChar = new JLabel("Character");
    JLabel lblForInt  = new JLabel("Decimal");

    txtInput      = new JTextField(10);
    lblResultChar = new JLabel();
    lblResultInt  = new JLabel();

        //change as needed

    txtInput     .setHorizontalAlignment(JTextField.CENTER);
    lblForChar   .setHorizontalAlignment(JLabel.CENTER);
    lblForInt    .setHorizontalAlignment(JLabel.CENTER);
    lblResultChar.setHorizontalAlignment(JLabel.CENTER);
    lblResultInt .setHorizontalAlignment(JLabel.CENTER);

    top.add(lblPrompt, BorderLayout.CENTER);     //label     for "Enter..."
    top.add(txtInput, BorderLayout.EAST);      //textfield for input
    add(lblForChar);    //label     for "Character"
    add(lblForInt);     //label     for "Decimal"
    add(lblResultChar); //label     for character result
    add(lblResultInt);  //label     for decimal   result
    center1.setLayout(new BorderLayout());
    center2.setLayout(new BorderLayout());
    center1.add(lblForChar, BorderLayout.NORTH);
    center1.add(lblResultChar, BorderLayout.SOUTH);
    center2.add(lblForInt, BorderLayout.NORTH);
    center2.add(lblResultInt, BorderLayout.SOUTH);

    inputField input = new inputField();
    
    txtInput.addActionListener(input);
    
  }
  //----------------------------------------------------------------------------
  
  private static class inputField implements ActionListener
  {
      public void actionPerformed (ActionEvent event)
      {
          
          String input1 = txtInput.getText();
          char charInput = input1.charAt(0);
          String charOutput = charInput + "";
          int changer = ((int) charInput);
          String numberOutput = formatter(changer);
          lblResultChar.setText(charOutput);
          lblResultInt.setText(numberOutput);
          txtInput.setText("");
      } 
  }
  
  private static String formatter(int value) 
  {
      DecimalFormat formatter = new DecimalFormat("####");       
      String returnMe = formatter.format(value);
      return returnMe;
  }
}
