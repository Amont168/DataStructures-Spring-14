//==============================================================================
// Program     : Raf04ReadStuDataLoop
// Author      : K. Pappas
// Date        : 09/03/12
// Abstract    : Read a random access file using a loop.
//==============================================================================
import java.io.*;
public class Raf04ReadStuDataLoop
{
  public static void main(String args[]) throws IOException
  {
    RandomAccessFile raf = new RandomAccessFile("raf03-stuDataLoop.dat","r");

    byte   barray[] = new byte[15];
    String name;
    int    hrs;
    double gpa;

    while(raf.getFilePointer()<raf.length())
      {
        raf.read(barray);
        name = new String(barray);
        hrs  = raf.readInt();
        gpa  = raf.readDouble();
        System.out.printf("%-15s %3d %4.2f\n",name,hrs,gpa);
        System.out.println(barray + "          " + "1" + name + "1");
      }

    raf.close();
  }
}

