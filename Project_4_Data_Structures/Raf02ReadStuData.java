//================================================================================
// Program : Raf02ReadStuData.java
// Author  : K. Pappas
// Date    : 09/03/12
// Abstract: Demo to show reading a random access file.
//           "r" appropriate when input only.
//           Shows repositioning file pointer.
//================================================================================
import java.io.*;
public class Raf02ReadStuData
{
  public static void main(String args[]) throws IOException
  {
    RandomAccessFile raf = new RandomAccessFile("raf01-simple.dat","r");

    byte   barray[] = new byte[15];
    String name;
    int    hrs;
    double gpa;

    raf.read(barray);        //  0-14  15 bytes ASCII
    name = new String(barray);
    hrs  = raf.readInt();    // 15-18   4 bytes 2's compliment binary notation
    gpa  = raf.readDouble(); // 19-26   8 bytes IEEE 754 floating-point notation
    System.out.printf("%s %d %8.2f\n",name,hrs,gpa);

    raf.seek(54);
    raf.read(barray);        // 54-68
    name = new String(barray);
    hrs  = raf.readInt();    // 69-72
    gpa  = raf.readDouble(); // 73-80
    System.out.printf("%s %d %8.2f\n",name,hrs,gpa);

    raf.seek(27);
    raf.read(barray);        // 27-41
    name = new String(barray);
    hrs  = raf.readInt();    // 42-45
    gpa  = raf.readDouble(); // 46-53
    System.out.printf("%s %d %8.2f\n",name,hrs,gpa);

    System.out.println("current position = " + raf.getFilePointer());

    raf.seek(0);

    System.out.println("current position = " + raf.getFilePointer());

    raf.read(barray);        //  0-14
    name = new String(barray);
    hrs  = raf.readInt();    // 15-18
    gpa  = raf.readDouble(); // 19-26
    System.out.printf("%s %d %8.2f\n",name,hrs,gpa);

    raf.close();
  }
}
