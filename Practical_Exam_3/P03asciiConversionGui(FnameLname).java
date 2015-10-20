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
public class P03asciiConversionGui(FirstnameLastname)          // <--- YOUR NAME
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
class AsciiConversionWindow extends JFrame
{
  private JTextField txtInput;                                    // fields
  private JLabel     lblResultChar;
  private JLabel     lblResultInt;

  public AsciiConversionWindow()                                  // constructor
  {
    super("ASCII Converter");

    JLabel lblPrompt  = new JLabel("Enter character or decimal value:");
    JLabel lblForChar = new JLabel("Character");
    JLabel lblForInt  = new JLabel("Decimal");

    txtInput      = new JTextField(10);
    lblResultChar = new JLabel();
    lblResultInt  = new JLabel();

    setLayout(new FlowLayout());    //change as needed

    txtInput     .setHorizontalAlignment(JTextField.CENTER);
    lblForChar   .setHorizontalAlignment(JLabel.CENTER);
    lblForInt    .setHorizontalAlignment(JLabel.CENTER);
    lblResultChar.setHorizontalAlignment(JLabel.CENTER);
    lblResultInt .setHorizontalAlignment(JLabel.CENTER);

    add(lblPrompt);     //label     for "Enter..."
    add(txtInput);      //textfield for input
    add(lblForChar);    //label     for "Character"
    add(lblForInt);     //label     for "Decimal"
    add(lblResultChar); //label     for character result
    add(lblResultInt);  //label     for decimal   result

  }
  //----------------------------------------------------------------------------
}
