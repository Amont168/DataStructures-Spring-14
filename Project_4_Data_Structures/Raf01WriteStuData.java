//================================================================================
// Program : Raf01WriteStuData.java
// Author  : K. Pappas
// Date    : 09/03/12
// Abstract: Demo to show basic creation and write to a random access file.
//           Random access files should use something other than .txt extension.
//           "r"  for read only if used as an input file
//           "rw" for both input and output
//           setLength(0) method used when you want to clean out an existing file.
//           String fields should be padded with spaces to make them fixed length.
//================================================================================
import java.io.*;
public class Raf01WriteStuData
{
  public static void main(String args[]) throws IOException
  {
    RandomAccessFile raf = new RandomAccessFile("raf01-simple.dat","rw");

    raf.setLength(0);

    String name1 = "Anna Arcello   ";
    int    hrs1  = 12;
    double gpa1  = 3.50;

    String name2 = "Jeannie Fisher ";
    int    hrs2  = 12;
    double gpa2  = 3.75;

    String name3 = "ABCDEFGHIJKLMNO";
    int    hrs3  = 24;
    double gpa3  = 4.00;

    raf.writeBytes(name1);  //  0-14  15 bytes ASCII
    raf.writeInt(hrs1);     // 15-18   4 bytes 2's compliment binary notation
    raf.writeDouble(gpa1);  // 19-26   8 bytes IEEE 754 floating-point notation

    raf.writeBytes(name2);  // 27-41
    raf.writeInt(hrs2);     // 42-45
    raf.writeDouble(gpa2);  // 46-53

    raf.writeBytes(name3);  // 54-68
    raf.writeInt(hrs3);     // 69-72
    raf.writeDouble(gpa3);  // 73-80

    System.out.println("file size = " + raf.length());

    raf.close();
  }
}
