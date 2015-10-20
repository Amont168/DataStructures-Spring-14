//==============================================================================
// Program : BalanceOnDemand.java
// Author  : K. Pappas
// Date    : 11/04/2012
// Abstract: Example of balancing a tree on demand.
//==============================================================================
import java.util.*;
import java.io.*;
public class BalanceOnDemand
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader   br        = new BufferedReader(new FileReader("stu63random1.txt"));
    int              grid1[][] = new int[63][64]; //up to 63 nodes
    int              grid2[][] = new int[63][64]; //col 0 used for ctr
    StringTokenizer  tok;
    String           rec;
    int              id;
    String           name;
    BalanceClass myTree        = new BalanceClass();


    while ((rec = br.readLine()) != null)
      {
        tok  = new StringTokenizer(rec,",");
        id   = Integer.parseInt(tok.nextToken());
        name = tok.nextToken();
        myTree.addNode(id,name);
      }

    myTree.fillGrid(myTree.root,-1,1,grid1); //for display only (grid1 before balance)
    myTree.balanceTree();
    myTree.fillGrid(myTree.root,-1,1,grid2); //for display only (grid2 after balance)
    myTree.showGrid(grid1);
    myTree.showGrid(grid2);
    br.close();
  }
}
//==============================================================================
class BalanceClass
{
  public Node root;                                                //fields
  public int  n = 0;
  //----------------------------------------------------------------------------
  public BalanceClass()                                            //constructor
  {
    root = null;
  }
  //----------------------------------------------------------------------------
  public void addNode(int id, String name)                         //methods
  {
    Node current;
    Node parent;
    Node newNode = new Node(id,name);
    n++;
    if(root==null)
      root = newNode;
    else
      {
        current = root;
        while(true)
          {
            parent = current;
            if(id<current.id)
              {
                current = current.left;
                if(current == null)
                  {
                    parent.left=newNode;
                    return;
                  }
              }
            else
              {
                current = current.right;
                if(current == null)
                  {
                    parent.right=newNode;
                    return;
                  }
              }
          }//end while
      }//end else not root
  }
  //----------------------------------------------------------------------------

  //----------------------------------------------------------------------------
  // Traverse tree "in order" and put node values into array
  //----------------------------------------------------------------------------
  public int fillGrid(Node node, int row, int col,int grid[][])
  {
    if(node==null)
      return col;

    row++;
    col = fillGrid(node.left,row,col,grid);    //go left to lowest values

    grid[row][col]=node.id;
    grid[row][0]++;                            //col [0] used for node ctr
    col++;

    col = fillGrid(node.right,row,col,grid);   //go right to next lowest values

    return col;
  }
  //----------------------------------------------------------------------------
  // Builds a balanced tree by:
  // 1. traversing an existing tree in-order to build an ordered array, then
  // 2. accessing those array elements using binary search logic to retrieve
  //    data in the order needed to build a new balanced tree.
  //----------------------------------------------------------------------------
  public void balanceTree()
  {
    Node tempList[] = new Node[n];
    int  i;

    traverseAndLoadArray(tempList,root,0);     //build ordered array
    root = null;                               //empty out tree
    rebuildTree(tempList,0,tempList.length-1); //rebuild tree from array
  }
  //----------------------------------------------------------------------------
  // Traverse "in order" to build an ordered array.
  //----------------------------------------------------------------------------
  public int traverseAndLoadArray(Node tempList[],Node localRoot,int i)
  {
    if(localRoot==null)
      return i;

    i =traverseAndLoadArray(tempList,localRoot.left,i);
    tempList[i] = localRoot;
    i++;
    i = traverseAndLoadArray(tempList,localRoot.right,i);

    return i;
  }
  //----------------------------------------------------------------------------
  // Access array using binary search logic to build balanced tree.
  //----------------------------------------------------------------------------
  public void rebuildTree(Node tempList[],int top,int bottom)
  {
    int mid;
    int num;

    if(top>bottom)
      return;

    mid  = (top+bottom)/2;
    addNode(tempList[mid].id,tempList[mid].name);
    rebuildTree(tempList,top  ,mid-1);
    rebuildTree(tempList,mid+1,bottom);
  }
  //----------------------------------------------------------------------------



















  //----------------------------------------------------------------------------
  // Loop stops when it gets to the level where there are no more nodes.
  //----------------------------------------------------------------------------
  public void showGrid(int grid[][])
  {
    int row = 0;
    int col;
    prtDashes();
    System.out.println("Lvl Count");
    while(grid[row][0] != 0)                 //col [0] is used for node ctr
      {
        System.out.printf("%2d  %3d :  ",row,grid[row][0]);
        for(col=1;col<grid[0].length;col++)
          if(grid[row][col]==0)
            System.out.print("   ");
          else
            System.out.printf("%3d",grid[row][col]);
        System.out.println("\n");
        row++;
      }
    prtDashes();
  }
  //----------------------------------------------------------------------------
  public void prtDashes()
  {
    for(int i=0;i<200;i++)
      System.out.print("-");
    System.out.println();
  }
  //----------------------------------------------------------------------------



  //==========================inner class=======================================
  // Made an inner class to demo a way to avoid possible file naming conflicts.
  // Will create BalanceClass$Node.class instead of Node.class
  // Note: this class does not have anything to do with the API Node interface.
  //----------------------------------------------------------------------------
  class Node
  {
    public int    id;
    public String name;
    public Node   left;
    public Node   right;

    public Node(int i,String n)
    {
      id    = i;
      name  = n;
      left  = null;
      right = null;
    }
  }
  //============================================================================
}
