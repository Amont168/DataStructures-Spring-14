//==============================================================================
// Demo Gui20: ScrollPane.
//==============================================================================
import javax.swing.*;
public class Gui20ScrollPane
{
  public static void main(String[] args)
  {
    String txt = "";
    txt += "This is a sample line of text.\n";
    txt += "This is line 2\n";
    txt += "This is line 3\n";
    txt += "This is line 4\n";
    txt += "This is line 5\n";
    txt += "This is line 6\n";
    txt += "This is line 7\n";
    txt += "This is line 8\n";
    txt += "This is line 9\n";
    txt += "This is line 10";

    JFrame      frame = new JFrame("Gui20 JScrollPane");
    JTextArea   ta    = new JTextArea(txt);
    JScrollPane sp    = new JScrollPane(ta);

    frame.add(sp);   //add scrollpane to window (or panel as needed)

    frame.setSize(400,300);
    frame.setLocation(200,100);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
