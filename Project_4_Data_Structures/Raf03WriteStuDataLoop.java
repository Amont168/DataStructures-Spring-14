//==============================================================================
// Program     : RafWriteStuDataLoop.java
// Author      : K. Pappas
// Date        : 09/03/12
// Abstract    : Read text file, write random access file demo.
//==============================================================================
import java.io.*;
import java.util.StringTokenizer;
public class Raf03WriteStuDataLoop
{
  public static void main(String args[]) throws IOException
  {
    FileReader       fr  = new FileReader("students10.txt");
    BufferedReader   br  = new BufferedReader(fr);
    RandomAccessFile raf = new RandomAccessFile("raf03-stuDataLoop.dat","rw");
    StringTokenizer  tok;

    String rec;
    String name;
    int    hrs;
    double gpa;
    String spaces = "               "; //used to pad strings for fixed length

    raf.setLength(0);                  //empty out the file (if desired)

    while((rec=br.readLine())!=null)
      {
        tok   = new StringTokenizer(rec,",");
        name  = tok.nextToken();
        hrs   = Integer.parseInt(tok.nextToken());
        gpa   = Double.parseDouble(tok.nextToken());
        name  = name + spaces;
        name  = name.substring(0,15);
        raf.writeBytes(name);
        raf.writeInt(hrs);
        raf.writeDouble(gpa);
      }

    System.out.println("file size = " + raf.length());
    raf.close();
  }
}

