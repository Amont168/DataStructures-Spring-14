//==============================================================================
// Program  : Employee dat file creater, and tree creator
// Author   : Dustyne Brown
// Date     : 11/29/2013  
// Abstract : Creates the dat file and binary tree  for Dsb04empInq2
//==============================================================================

import java.io.*;


public class Dsb05txt2rafAndTree 
{
  public static void main(String[] args) throws IOException 
  {
    BufferedReader br  = new BufferedReader(new FileReader("emp-master.txt"));         //Connects to file on disk
    
    rafCreator(br);
    
    br.close();
  }
  
  private static void rafCreator(BufferedReader br) throws IOException
  {
    OutputStream file = new FileOutputStream("emp-master.tree");                      //Establishes a connection 
    ObjectOutputStream output = new ObjectOutputStream(file);                         //to a file on disk
    
    RandomAccessFile raf = new RandomAccessFile("emp-master.dat","rw");
    
    TreeBuildClass   treeObj = new TreeBuildClass();
    
    String[] holder = new String[2];
    String   name;
    String   rec;
    
    char pyt;  
    char mts;
    
    double pyr;
    
    int ssn;
    int phn;
    int dpt;  
    int trgt = 0;
    
    raf.setLength(0);
    
    while((rec=br.readLine())!=null)                                //This loop reads in all records, breaks them 
      {                                                             // apart, and adds them as unordered nodes
      
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
        
        treeObj.addNode(ssn,trgt);                            //Adds a node to the tree after each record read in
        
        trgt++;                                    //Increments target so we know where each record is on the RAF
        }
    
    raf.close();                                                                  //Closes the Random Access File
    
    treeObj.balanceTree();                                       //Calls the method that balances the binary tree
    
    output.writeObject(treeObj);                                              //Writes the Binary Tree to a file
    
    output.close();                                                                      //Closes file connection
    file.close();
  }
}

//=============================================================================
//    Tree Build Class (Contains all methods for building and balancing Tree)
//==============================================================================

class TreeBuildClass implements Serializable
{
  public TreeNode root;                                                
  public int  x = 0;
  
  public TreeBuildClass()                                                              //Class Constructor Method
  {
    root = null;
  }
  
//----------------------------------------------------------------------------
  
  public void addNode(int ssn, int trgt)                                   //Method used to add nodes to the tree
  {
    TreeNode current;
    TreeNode parent;
    TreeNode newNode = new TreeNode(ssn, trgt);                     //Creates the new node object to be linked in
    
    x++;                                                               //Increments the counter for each new node
    
    if(root==null)                                                          //Creates the base if there isn't one
      {
        root = newNode;
      }
    else
      {
        current = root;                                      //Moves the selection to inspect to the current root
        while(true)
          {
            parent = current;
            if(ssn < current.ssn)                                        //Compares the passed SSN to the current
              {
                current = current.lChild;                                        //Advances to less than position
                if(current == null)
                  {
                    parent.lChild = newNode;                        //Turns the new node into the current's child
                    return;
                  }
              }
            else                                             //Executed if the passed SSN is greater than current
              {
                current = current.rChild;                                     //Advances to greater than position
                if(current == null)
                  {
                    parent.rChild = newNode;                                  
                    return;
                  }
              }
          }
      }
  }
  
//----------------------------------------------------------------------------
  
  public void balanceTree()
  {
    TreeNode temp[] = new TreeNode[x];

    traverseAndLoadArray(temp, root, 0);                           //Orders nodes into a specific sequenced array
    
    root = null;                                                                                   //Empties Tree
    
    rebuildTree(temp, 0, temp.length-1);                    //Uses Temp List's sequence to create a balanced Tree
  }

//----------------------------------------------------------------------------

  public int traverseAndLoadArray(TreeNode tempList[],TreeNode localRoot,int i)
  {                                                              //Traverses, orders and puts tree into temp list
    if(localRoot==null)
      return i;

    i = traverseAndLoadArray(tempList, localRoot.lChild, i);                                       //Loads lowest
    tempList[i] = localRoot;                                                              //Stores current number
    i++;
    i = traverseAndLoadArray(tempList,localRoot.rChild,i);                                         //Gets highest

    return i;
  }
  
//----------------------------------------------------------------------------
  
  public void rebuildTree(TreeNode tempList[],int top,int bottom)
  {                                                      //Loads in nods in the order they were added to tempList
    int mid;

    if(top>bottom)
      return;

    mid  = (top+bottom)/2;
    addNode(tempList[mid].ssn,tempList[mid].trgt);                                                   //Adds nodes
    rebuildTree(tempList,top  ,mid-1);                                                 //Loads lower half of tree
    rebuildTree(tempList,mid+1,bottom);                                               //Loads higher half of tree
  }
  
//----------------------------------------------------------------------------
  
  public long find(long key)
  {
    TreeNode current;

    current = root;

    while(current!=null && current.ssn!=key)
      {
        if(key<current.ssn)
          current = current.lChild;
        else
          current = current.rChild;
      }

    if(current!=null)
      key = current.trgt;
    else
      key = 9999;
    
    return key;
  }
  
//============================================================================
  class TreeNode  implements Serializable                                   //Inner class used to create the tree
  {
    public int      ssn;
    public int      trgt;
    public TreeNode lChild;
    public TreeNode rChild;

    public TreeNode(int x, int y)
    {
      ssn    = x;
      trgt  = y;
      lChild  = null;
      rChild = null;
    }
  }
}
