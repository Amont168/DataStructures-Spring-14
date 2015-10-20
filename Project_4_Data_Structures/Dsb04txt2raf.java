//==============================================================================
// Program  : Employee dat file creater
// Author   : Dustyne Brown
// Date     : 10/10/2013  
// Abstract : Creates the dat file for Dsb04empInq1
//==============================================================================

import java.io.*;


public class Dsb04txt2raf 
{
  public static void main(String[] args) throws IOException 
  {
    FileReader       fr  = new FileReader("emp-master.txt");
    BufferedReader   br  = new BufferedReader(fr);
    RandomAccessFile raf = new RandomAccessFile("emp-master.dat","rw");

    String[] holder = new String[2];
    String name;
    String rec;
    
    char  pyt;  
    char mts;
    
    double pyr;
    
    int ssn;
    int    phn;
    int dpt;    
    
    raf.setLength(0);
    
    while((rec=br.readLine())!=null)
      {
      
        holder[0] = rec.substring(0,9);                             //Block substrings a record to correct fields
        ssn = Integer.parseInt(holder[0]);
        name = rec.substring(9, 34);
        holder[0] = rec.substring(34, 41);
        phn = Integer.parseInt(holder[0]);
        holder[0] = rec.substring(41, 42);
        pyt = holder[0].charAt(0);
        holder[0] = rec.substring(42, 53);
        pyr = Double.parseDouble(holder[0]);
        holder[0] = rec.substring(53, 54);
        mts = holder[0].charAt(0);
        holder[0] = rec.substring(54, 56);
        dpt = Integer.parseInt(holder[0]);
        
        raf.writeInt(ssn);                                                         //Writes all data for a record
        raf.writeBytes(name);
        raf.writeInt(phn);
        raf.writeByte(pyt);
        raf.writeDouble(pyr);
        raf.writeByte(mts);
        raf.writeInt(dpt);
      }
    raf.close();
  }

}
