//==============================================================================
// Program  : Employee master file inquiry
// Author   : Starter file by K. Pappas, finished by: Dustyne Brown
// Date     :                 10/28/2013              10/10/2013  
// Abstract : class file that provides emp random access file inquiry
//==============================================================================
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
public class Dsb04empInq1
{
  public static void main(String[] args) throws IOException
  {
    dsb04empScreen empScrn = new dsb04empScreen();
    empScrn.setSize(650,350);
    empScrn.setLocation(300,300);
    empScrn.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    empScrn.setVisible(true);
  }
}
//------------------------------------------------------------------------------
class dsb04empScreen extends JFrame
{
  private RandomAccessFile raf;
  private JTextField       tfReqID;    //east area request fields
  private JTextField       tfReqSSN;
  private JTextField       tfReqName;
  private JTextField       tfReqPhone;
  private JTextArea        taNameList; //east area search results

  private JTextField       tfID;       //center area record display
  private JTextField       tfSSN;
  private JTextField       tfName;
  private JTextField       tfPhone;
  private JTextField       tfPType;
  private JTextField       tfPRate;
  private JTextField       tfMStat;
  private JTextField       tfExemp;

  private JTextField       tfMsg;      //south area message

  private final int        REC_LEN   = 47;
  private final int        NAME_LEN  = 25;
  //-----------------------------------------------------------------constructor
  public dsb04empScreen() throws IOException
  {
    super("Sally Student - Project 4");
    raf = new RandomAccessFile("emp-master.dat","r");
    setLayout(new BorderLayout());

    JPanel pnlWest      = new JPanel();    //west area
    JLabel labelID      = new JLabel("Emp ID");
    JLabel labelSSN     = new JLabel("SSN");
    JLabel labelName    = new JLabel("Name");
    JLabel labelPhone   = new JLabel("Phone");
    JLabel labelPType   = new JLabel("Pay Type");
    JLabel labelPRate   = new JLabel("Pay Rate");
    JLabel labelMStat   = new JLabel("Married/Single");
    JLabel labelExemp   = new JLabel("Number of Exemptions  ");
    pnlWest.setLayout(new GridLayout(8,1));
    pnlWest.add(labelID);                   // row 1
    pnlWest.add(labelSSN);                  // row 2
    pnlWest.add(labelName);                 // row 3
    pnlWest.add(labelPhone);                // row 4
    pnlWest.add(labelPType);                // row 5
    pnlWest.add(labelPRate);                // row 6
    pnlWest.add(labelMStat);                // row 7
    pnlWest.add(labelExemp);                // row 8
    add(pnlWest,BorderLayout.WEST);

    JPanel  pnlCenter   = new JPanel();     //center area
    tfID    = new JTextField();
    tfSSN   = new JTextField();
    tfName  = new JTextField();
    tfPhone = new JTextField();
    tfPType = new JTextField();
    tfPRate = new JTextField();
    tfMStat = new JTextField();
    tfExemp = new JTextField();
    pnlCenter.setLayout(new GridLayout(8,1));
    pnlCenter.add(tfID);                    // row 1
    pnlCenter.add(tfSSN);                   // row 2
    pnlCenter.add(tfName);                  // row 3
    pnlCenter.add(tfPhone);                 // row 4
    pnlCenter.add(tfPType);                 // row 5
    pnlCenter.add(tfPRate);                 // row 6
    pnlCenter.add(tfMStat);                 // row 7
    pnlCenter.add(tfExemp);                 // row 8
    add(pnlCenter,BorderLayout.CENTER);

    JPanel pnlEastTop    = new JPanel();
    pnlEastTop.setLayout(new GridLayout(4,1));
    tfReqID              = new JTextField(20);
    tfReqSSN             = new JTextField(20);
    tfReqName            = new JTextField(20);
    tfReqPhone           = new JTextField(20);
    pnlEastTop.add(tfReqID);                // row 1
    pnlEastTop.add(tfReqSSN);               // row 2
    pnlEastTop.add(tfReqName);              // row 3
    pnlEastTop.add(tfReqPhone);             // row 4

    taNameList = new JTextArea();           // search results, fills rows 5-8
    taNameList.setFont(new Font("Courier", Font.PLAIN, 12));
    JScrollPane sp = new JScrollPane(taNameList,
                                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    JPanel pnlEast       = new JPanel();
    pnlEast.setLayout(new GridLayout(2,1));
    pnlEast.add(pnlEastTop);
    pnlEast.add(sp);
    add(pnlEast,BorderLayout.EAST);

    JButton     btnReadPrevID = new JButton("Read Prev ID");
    JButton     btnReadNextID = new JButton("Read Next ID");
    JButton     btnClear      = new JButton("Clear");
    JButton     btnListAll    = new JButton("List All Recs");
    JPanel      pnlButtons    = new JPanel();
    pnlButtons.setLayout(new GridLayout(1,4)); //next to bottom row
    pnlButtons.add(btnReadPrevID);
    pnlButtons.add(btnReadNextID);
    pnlButtons.add(btnClear);
    pnlButtons.add(btnListAll);

    tfMsg = new JTextField();
    tfMsg.setText("Lookup by ID");

    JPanel  pnlBottomRows = new JPanel();
    pnlBottomRows.setLayout(new GridLayout(2,1)); //for button pnl & msg tf
    pnlBottomRows.add(pnlButtons);
    pnlBottomRows.add(tfMsg);
    add(pnlBottomRows,BorderLayout.SOUTH);

    tfID      .setEditable(false);
    tfSSN     .setEditable(false);
    tfName    .setEditable(false);
    tfPhone   .setEditable(false);
    tfPType   .setEditable(false);
    tfPRate   .setEditable(false);
    tfMStat   .setEditable(false);
    tfExemp   .setEditable(false);
    tfMsg     .setEditable(false);
    taNameList.setEditable(false);

    pack(); //forces frame to be realized so focus can be set
    tfReqID.requestFocus();

    tfReqID      .addActionListener(new HandlerID()        );
    tfReqSSN     .addActionListener(new HandlerSSN()       );
    tfReqName    .addActionListener(new HandlerName()      );
    tfReqPhone   .addActionListener(new HandlerPhone()     );
    btnReadPrevID.addActionListener(new HandlerReadPrevID());
    btnReadNextID.addActionListener(new HandlerReadNextID());
    btnClear     .addActionListener(new HandlerClear()     );
    btnListAll   .addActionListener(new HandlerListAll()   );

  }//end constructor
  
  //============================================================================
  //              ID handler (physical record number in the file)
  //============================================================================
  
  private class HandlerID implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String idStr = tfReqID.getText();
      String holder = "";
      
      int x;
      
      long targetId = 0;
      long targetLoc = 0;
      
      if(idStr.length()==0)                                                 //0=enter key pressed on empty field
        {
          tfMsg.setText("Lookup by ID");                                         //Provides function info, clears
          tfReqSSN.requestFocus();                                               // and advances
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          taNameList.setText("");
          return;
        }
      else                                //If anything was entered into the field, it's stripped to only numerics
        {
          for(x = 0; x < idStr.length(); x++)   
            {
              if((int) idStr.charAt(x) >= 48 && (int) idStr.charAt(x) <= 57)
              {
                holder = holder + idStr.charAt(x);
              }
            }
          targetId = Long.parseLong(holder);                                        //Moves entered data to a long
        }
      
      if (targetId <= 58)
        {
          targetLoc = (targetId * REC_LEN) - 47;                           //Uses the length of each record in the
                                                                           // .dat to target specific ID locations
          
          try                                                                   //Loads and displays requested ID  
          {
            raf.seek(targetLoc);                                                                  //Seek location
            dsb04empRec empTrgt = readCurrRec();                                           //Create an emp object
            fillInfoFields(empTrgt);                                                             //Display object
            clearReqFields();                                                                      //Reset fields
            tfMsg.setText("");
          } 
        catch (IOException e)                                               //Error catcher, should never execute
          {
            tfMsg.setText("Invalid Request: " + idStr);
            clearReqFields();
            tfID   .setText("");
            tfSSN  .setText("");
            tfName .setText("");
            tfPhone.setText("");
            tfPType.setText("");
            tfPRate.setText("");
            tfMStat.setText("");
            tfExemp.setText("");
            taNameList.setText("");
            return;
          }
        }
      else                                                            //Invalid data entered (ID entered over 58)
        {
          tfMsg.setText("Invalid Request: " + targetId);
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          taNameList.setText("");
        }
    }
  }
  
  //============================================================================
  //                             SSN handler
  //============================================================================
  
  private class HandlerSSN implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String holder = "";
      String ssnReqStr = tfReqSSN.getText();
      
      int x;
   
      long targetLoc;
      
      if(ssnReqStr.length()==0)                                               //Function info if nothing entered
        {
          tfReqName.requestFocus();
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          tfMsg.setText("Lookup by SSN");
          taNameList.setText("");
          return;
        }
      else                                                              //Strips entered request to numeric only
        {
          for(x = 0; x < ssnReqStr.length(); x++)
            {
              if((int) ssnReqStr.charAt(x) >= 48 && (int) ssnReqStr.charAt(x) <= 57)
              {
                holder = holder + ssnReqStr.charAt(x);
              }
            }
        }
      
      try 
        {
          targetLoc = 9999;                                                  //Used as a flag if no results found
          targetLoc = findSsn(holder, targetLoc);                                     //Searches for the requested 
        }                                                                            // ssn's location.
      catch (IOException e)                                                 //Error catcher, should never execute
        {
          tfMsg.setText("Unexpected Error While Searching For SSN");
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          taNameList.setText("");
          return;
        }
      
      if(targetLoc != 9999)                                                      //Makes sure something was found
        {
          try                                                                  //Loads emp object and displays it
            {
              raf.seek(targetLoc);
              dsb04empRec empRec = readCurrRec();
              fillInfoFields(empRec);
              tfMsg.setText("");
              clearReqFields();
              taNameList.setText("");
            } 
          catch (IOException e)                                             //Error catcher, should never execute
            {
              tfMsg.setText("Unexpected Error While Seeking And Loading Match");
            }
        }
      else
        {
          clearReqFields();
          clearInfoFields();
          tfMsg.setText("Invalid request: " + holder);
        }
    }

    //--------------------------------------------------------------------------
    
    private long findSsn(String ssnReqStr, long targetLoc) throws IOException            //Method that hunts the 
      {                                                                                  // requested data
        long search = 0;
          
        String holder;
        
        while(search < raf.length())                                                   //Continues searching till
          {                                                                            // the end of file
            raf.seek(search);
            holder = raf.readInt() + "";
            
            if (holder.equals(ssnReqStr))                                               //Checks the read in INT 
              {                                                                         // against the requested
                targetLoc = search;                                                     
                return targetLoc;                                                      //If data matches, returns
              }
            else                                                  //Advances to the next records if nothing found
              {
                search = search + REC_LEN;
              }
          }
        return targetLoc;
      }    
  }
  
  //============================================================================
  //                             Name handler
  //============================================================================
  
  private class HandlerName implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String nameReq = tfReqName.getText();
      String holder = "";
      
      long[] trgtLocs = new long[58];
      
      int x;
      int y;
      
      if(nameReq.length()==0)                                                     //Makes sure entry wasn't empty
        {
          tfReqPhone.requestFocus();
          clearReqFields();
          tfID      .setText("");
          tfSSN     .setText("");
          tfName    .setText("");
          tfPhone   .setText("");
          tfPType   .setText("");
          tfPRate   .setText("");
          tfMStat   .setText("");
          tfExemp   .setText("");
          tfMsg     .setText("Lookup by Name(partial matches allowed");
          taNameList.setText("");
          return;
        }
      else                                                             //Sets up flags to determine if that array
        {                                                              // slot has a valid entry location stored
          for(x = 0; x < 58; x++)
            {
              trgtLocs[x] = 9999;                                    
            }
        }
      try 
        {
          x = 0;
          y = 0;
          trgtLocs = findName(nameReq, trgtLocs);      
          for(x = 0; x < 58; x++)
            {
              if(trgtLocs[x] != 9999)
              {
                y++;                                                                    //Number of records found
              }
            }
        }                                                                           
      catch (IOException e)                                                                //Should never execute
        {
          tfMsg.setText("Unexpected Error While Searching For Name");
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          taNameList.setText("");
          return;
        }
      
      if(y == 1)                                                                 //Executed if only 1 match found
        {
          try
            {
              raf.seek(trgtLocs[0] - 4);                                                //Displays the only match
              dsb04empRec empRec = readCurrRec();
              fillInfoFields(empRec);
              tfMsg.setText("Unique record found for this request: " + '"' + nameReq + '"');
              taNameList.setText("");
              clearReqFields();
            }
          catch (IOException e)
          {
            tfMsg.setText("Unexpcted Error While Seeking and Loading Match");
          }
        }
      else
        {
          if(y >= 2)                                                        //Executed if 2 or more matches found
          {
            for(x = 0; x < y; x++)                                    //Puts the name of each match into a holder
              {                                                       // then put it in the name list
                try
                  {
                    raf.seek(trgtLocs[x] - 4);
                    dsb04empRec empRec = readCurrRec();
                    holder = holder + empRec.name + "\n";
                  }
                catch (IOException e)
                  {
                    System.out.println("Error while loading all matches");
                  }
                
              }
            clearInfoFields();
            clearReqFields();
            taNameList.setText(holder);
            tfMsg.setText("Results: " + y + " matches found with the characters: " + '"' + nameReq + '"');
          }
          else
            {
              tfMsg.setText("Invalid request: " + nameReq);
              clearReqFields();
            }
        }
    }
    
    //--------------------------------------------------------------------------

    private long[] findName(String nameReq, long[] trgtLocs) throws IOException 
    {
      String holder;
      
      byte[] bArray = new byte[NAME_LEN];
      
      long search = 4;
      
      int x = 0;
      
      nameReq = nameReq.toLowerCase();
      
      while(search < raf.length())                                                   
        {                                                                           
          raf.seek(search);
          raf.read(bArray);
          holder = new String(bArray);
          
          holder = holder.toLowerCase();
          
          if(holder.contains(nameReq))                  //Checks lower case version of entry against lower record
            {
              trgtLocs[x] = search;
              x++;
            }
          search = search + REC_LEN;
        }
      return trgtLocs;
    }
  }
  //============================================================================
  //                              Phone handler
  //============================================================================
  private class HandlerPhone implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String holder = "";
      String phoneReqStr = tfReqPhone.getText();

      long targetLoc;
      
      int x;
      
      if(phoneReqStr.length()==0)                                                 //Checks if the entry was empty
        {
          clearReqFields();
          tfID      .setText("");
          tfSSN     .setText("");
          tfName    .setText("");
          tfPhone   .setText("");
          tfPType   .setText("");
          tfPRate   .setText("");
          tfMStat   .setText("");
          tfExemp   .setText("");
          taNameList.setText("");
          tfMsg     .setText("Lookup by Phone");
          tfReqID   .requestFocus();
          return;
        }
      else                                                                        //Strips entry to numerics only
        {
          for(x = 0; x < phoneReqStr.length(); x++)
            {
              if((int) phoneReqStr.charAt(x) >= 48 && (int) phoneReqStr.charAt(x) <= 57)
              {
                holder = holder + phoneReqStr.charAt(x);
              }
            }
        }
      try 
        {
          targetLoc = 9999;                                              //Sets a flag and searches for the entry
          targetLoc = findPhone(holder, targetLoc);                                      
        }                                                                           
      catch (IOException e)                                                 //Error Catcher, should never execute
        {
          tfMsg.setText("Unexpected Error While Searching For Phone");
          clearReqFields();
          tfID   .setText("");
          tfSSN  .setText("");
          tfName .setText("");
          tfPhone.setText("");
          tfPType.setText("");
          tfPRate.setText("");
          tfMStat.setText("");
          tfExemp.setText("");
          taNameList.setText("");
          return;
        }
      
      if(targetLoc != 9999)                 //Checks the flag, if valid, locates and displays the requested entry
        {
          try                                                               
            {
              raf.seek(targetLoc - NAME_LEN - 4);
              dsb04empRec empRec = readCurrRec();
              fillInfoFields(empRec);
              taNameList.setText("");
              clearReqFields();
              tfMsg.setText("");
            } 
          catch (IOException e)                                             //Error catcher, should never execute
            {
              tfMsg.setText("Unexpected Error While Seeking And Loading Match");
            }
        }
      else                                                                                   //Invalid data entry
        {
          clearReqFields();
          clearInfoFields();
          tfMsg.setText("Invalid request: " + holder);
        }
    }
    
  //----------------------------------------------------------------------------
    private long findPhone(String phoneReqStr, long targetLoc) throws IOException              
      {                                                                                  
        long search = 4 + NAME_LEN;                                   //Used to seek to the location of the phone
          
        String holder;
        
        while(search < raf.length())                                                
          {                                                                     
            raf.seek(search);
            holder = raf.readInt() + "";
            if (holder.equals(phoneReqStr))                              //Checks the number located VS the entry
              {                                                       
                targetLoc = search;                                                     
                return targetLoc;                                           
              }
            else                               
              {
                search = search + REC_LEN;
              }
          }
        return targetLoc;
      }   
  }
  //============================================================================
  //                      Read previous button handler
  //============================================================================
  private class HandlerReadPrevID implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
     long x;
     
      try
        {
          x = (raf.getFilePointer() - (REC_LEN * 2));                       //Used to point the file towards the 
                                                                            // start of the previous record
          if( x < 0)
            {
              tfMsg.setText("Error: No previous records");
            }
          else
          {
            raf.seek(x);
            dsb04empRec empObj = readCurrRec();
            fillInfoFields(empObj);
          }
        }
      catch (IOException e)
        {
          tfMsg.setText("Error while trying to read previous record");
        }
    }
    
  }
  //============================================================================
  //                       Read next button handler
  //============================================================================
  private class HandlerReadNextID implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      try 
        {
          if(raf.getFilePointer() < raf.length())                            //Makes sure there is another record
            {
              dsb04empRec empObj = readCurrRec();
              fillInfoFields(empObj);
            }
          else                                                                    //Used if no more records exist
            {
              tfMsg.setText("Error: No more records to display");
            }
        }
      catch (IOException e) 
        {
          tfMsg.setText("Unexpected error while searching for next record");
        }
    }
  }
  //============================================================================
  //                           Clear button handler
  //============================================================================
  private class HandlerClear implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      clearInfoFields();
      clearReqFields();
      taNameList.setText("");
      tfMsg.setText("Lookup by ID");
      tfReqID.requestFocus();
      try
        {
          raf.seek(0);
        }
      catch(IOException e)
        {
          System.out.println("io error in clear handler should not occur");
        }
    }
  }
  //============================================================================
  //                    List all records button handler
  //============================================================================
  private class HandlerListAll implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      String ssn;
      String phone;
      String name;
      String holder1;
      String holder2;
      String holder3;
      
      char payType;
      char martialStat;
      
      long x = 0;
      
      double payRate;
      
      int id;
      int dependants;
      
      byte[] bArray = new byte[NAME_LEN];
      byte holder;
      
      try
        {
          raf.seek(x);
          while(raf.getFilePointer() < raf.length())
            {
              id = (((int)raf.getFilePointer()) / REC_LEN) + 1;                 //Gathers all information for one
              ssn = raf.readInt() + "";                                         // record from the file
              raf.read(bArray);
              name = new String(bArray);
              phone = raf.readInt() + "";
              holder = raf.readByte();
              payType = ((char) holder);
              payRate = raf.readDouble();
              holder = raf.readByte();
              martialStat = ((char) holder);
              dependants = raf.readInt();
              
              while(ssn.length() < 9)                                          //Used for formating what needs it
              {
                ssn = "0" + ssn;
              }
              while(phone.length() < 7)
              {
                phone = "0" + phone;
              }
              holder1 = ssn.substring(0,3) + "-" + ssn.substring(3,5) + "-" + ssn.substring(5,9);
              holder2 = phone.substring(0,3) + "-" + phone.substring(3, 7);
              holder3 = formatter("##,###,###.00", payRate);
              
              System.out.printf("%4s%12s%26s%9s%2s%15s%2s%3s\n", id, holder1, name, holder2, payType, 
                  holder3, martialStat, dependants);
            }
        }
      catch (IOException e)                                                 //Error catcher, should never execute
        {
          tfMsg.setText("Error while finding first records");
        }
    }
    
    private String formatter(String pattern, double value) 
    {                                                                //Accepts a pattern and value, then formats 
      DecimalFormat formatter = new DecimalFormat(pattern);          // that value into the pattern.
      String returnMe = formatter.format(value);
      return returnMe;
    }
  }
  //============================================================================
  //                             methods
  //============================================================================
  private void clearInfoFields()
  {
    tfID   .setText("");
    tfSSN  .setText("");
    tfName .setText("");
    tfPhone.setText("");
    tfPType.setText("");
    tfPRate.setText("");
    tfMStat.setText("");
    tfExemp.setText("");
  }
  //----------------------------------------------------------------------------
  private void clearReqFields()
  {
    tfReqID   .setText("");
    tfReqSSN  .setText("");
    tfReqName .setText("");
    tfReqPhone.setText("");
  }
  //----------------------------------------------------------------------------
  private void fillInfoFields(dsb04empRec emp)
  {
    tfID   .setText(Integer.toString(emp.empnum));
    tfSSN  .setText(emp.ssnFmtd);
    tfName .setText(emp.name);
    tfPhone.setText(emp.phoneFmtd);
    tfPType.setText(emp.ptypeFmtd);
    tfPRate.setText(emp.prateFmtd);
    tfMStat.setText(emp.mstatFmtd);
    tfExemp.setText(Integer.toString(emp.exemp));
  }
  //----------------------------------------------------------------------------
  // Method to get data for all fields in the record at current file position.
  // Creates and returns an emp object loaded with formatted record information.
  // File pointer needs to be at the start of desired record before you get here.
  //----------------------------------------------------------------------------
  private dsb04empRec readCurrRec() throws IOException
  {
    dsb04empRec empObj;
    
    int    empnum;
    int    ssn;
    String name;
    int    phone;
    char   ptype;
    double prate;
    char   mstat;
    int    exemp;
    byte[] holder = new byte[NAME_LEN];
    byte   holder2;
    
    empnum  = (((int) raf.getFilePointer() / REC_LEN) + 1);
    ssn     = raf.readInt();
    raf.read(holder);
    name    = new String(holder);
    phone   = raf.readInt();
    holder2 = raf.readByte();
    ptype   = ((char) holder2);
    prate   = raf.readDouble();
    holder2 = raf.readByte();
    mstat   = ((char) holder2);
    exemp   = raf.readInt();
    
    empObj = new dsb04empRec(empnum, ssn, name, phone, ptype, prate, mstat , exemp);

    return empObj;
  }
  //----------------------------------------------------------------------------
}//end frame class

//==============================================================================
// Program  : record class for use by emp inq pgm
// Author   : K. Pappas
// Date     : 10/28/2013
// Abstract : contains all information for one record in all formats needed
//==============================================================================
class dsb04empRec
{
  public int     empnum;     // physical rec num
  public int     ssn;        // ssn
  public String  name;       // name                "last, first"
  public int     phone;      // phone
  public char    ptype;      // pay type            'h' 's'
  public double  prate;      // pay rate
  public char    mstat;      // marital status      'm' 's'
  public int     exemp;      // exemptions claimed

  public String  ssnFmtd;    // ssn                 "nnn-nn-nnnn"
  public String  phoneFmtd;  // phone               "nnn-nnnn"
  public String  ptypeFmtd;  // pay type            "hourly" "salary"
  public String  prateFmtd;  // pay rate            "nn,nnn,nnn.nn"
  public String  mstatFmtd;  // marital status      "married" "single"

  //-----------------------------------------------------------------constructor
  public dsb04empRec(int empnum, int ssn     , String name, int phone,
                     char ptype, double prate, char mstat , int exemp)
  {
    this.empnum = empnum;  //these fields need no formatting
    this.name   = name;
    this.exemp  = exemp;

    setSSN    (ssn);       //set methods used to format these fields
    setPhone  (phone);
    setPayType(ptype);
    setPayRate(prate);
    setMStat  (mstat);
  }
  //-----------------------------------------------------------------set methods
  public void setSSN(int ssn)
  {
    this.ssn = ssn;
    String x = String.format("%09d",ssn);
    ssnFmtd  = x.substring(0,3) + "-" + x.substring(3,5) + "-" + x.substring(5);
  }
  //----------------------------------------------------------------------------
  public void setPhone(int phone)
  {
    this.phone = phone;
    String x   = String.format("%07d",phone);
    phoneFmtd  = x.substring(0,3) + "-" + x.substring(3);
  }
  //----------------------------------------------------------------------------
  public void setPayType(char ptype)
  {
    this.ptype = ptype;
    switch(ptype)
      {
        case 's' : ptypeFmtd = "Salary";  break;
        case 'h' : ptypeFmtd = "Hourly";  break;
        default  : ptypeFmtd = "Not on file";
      }
  }
  //----------------------------------------------------------------------------
  public void setPayRate(double prate)
  {
    this.prate = prate;
    prateFmtd  = String.format("%,13.2f",prate).trim();
  }
  //----------------------------------------------------------------------------
  public void setMStat(char mstat)
  {
    this.mstat = mstat;
    switch(mstat)
      {
        case 's' : mstatFmtd = "Single";  break;
        case 'm' : mstatFmtd = "Married"; break;
        default  : mstatFmtd = "Not on file";
      }
  }
  //----------------------------------------------------------------------------
}
