//==============================================================================
// Program  : Practical exam problem 2.
// Name     :                                                     <--- YOUR NAME
// Date     : 05/01/2013
// Objective: Convert binary codes to decimal and character.
//==============================================================================
import java.io.*;
public class P02binaryConverter(FirstnameLastname)             // <--- YOUR NAME
{
  public static void main(String args[]) throws IOException
  {
    FileReader     fr = new FileReader("p02-data-in.txt");
    BufferedReader br = new BufferedReader(fr);
    String rec;

    while((rec=br.readLine())!=null)
      showRec(rec);

    br.close();
  }
  //----------------------------------------------------------------------------
  // Do not change anything in the main method.
  // Complete the code below. You can add additional methods if you desire.
  // I will test with a different input file.
  // Output is to be columnar. See sample output below
  //----------------------------------------------------------------------------
  public static void showRec(String binary)
  {


    System.out.print....  ;  //change to give required columnar output
  }
  //----------------------------------------------------------------------------
}
/* Sample output

01000001   65  A
01000010   66  B
01000011   67  C
11100011  227  ã
01011000   88  X
01011001   89  Y
01011010   90  Z
01100001   97  a
01100010   98  b
01100011   99  c
00000111    7    (note: you may get a blank space for some codes)
01111000  120  x
01111001  121  y
01111010  122  z
00110001   49  1
00110010   50  2
00110011   51  3

*/
