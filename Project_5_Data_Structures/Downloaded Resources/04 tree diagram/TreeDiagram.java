//==============================================================================
// Program : TreeDiagram.java
// Author  : K. Pappas
// Date    : 11/01/2012
// Abstract: Tree diagram example. (all classes combined)
//==============================================================================
import java.util.*;
import java.io.*;
public class TreeDiagram
{
  public static void main(String[] args) throws IOException
  {
    buildDispTree("stuBalanced.txt");
    buildDispTree("stuRandom.txt");
    buildDispTree("stuOrdered.txt");
  }
  //----------------------------------------------------------------------------
  public static void buildDispTree(String fname) throws IOException
  {
    TreeDiagramClass myTree = new TreeDiagramClass(fname);
    int grid[][]            = new int[27][27]; //handles 26 nodes
                                               //col 0 used for counter
    System.out.println(fname);
    System.out.println("ID Name    Lvl");
    myTree.listInOrder(grid,myTree.root,-1,1);
    myTree.showGrid(grid,fname);
  }
}
//==============================================================================
class TreeDiagramClass
{
  public Node root;

  public TreeDiagramClass(String fname) throws IOException
  {
    FileReader      fr = new FileReader(fname);
    BufferedReader  br = new BufferedReader(fr);
    StringTokenizer tok;
    String          rec;
    int             id;
    String          name;

    while ((rec = br.readLine()) != null)
      {
        tok  = new StringTokenizer(rec,",");
        id   = Integer.parseInt(tok.nextToken());
        name = tok.nextToken();
        addNode(id,name);
      }

    br.close();
  }
  //----------------------------------------------------------------------------
  public int listInOrder(int grid[][], Node node, int row, int col)
  {
    if(node==null)
      return col;

    row++;
    col = listInOrder(grid,node.left,row,col);    //go left

    grid[row][col]=node.id;
    grid[row][0]++;           //[row][0] used to keep count of nodes on this row
    showNode(node,row,col);
    col++;

    col = listInOrder(grid,node.right,row,col);   //go right

    return col;
  }
  //----------------------------------------------------------------------------
  public void showNode(Node node,int row,int col)
  {
    if(node.left==null && node.right==null)
      System.out.printf("%2d %-7s %2d leaf",node.id,node.name,row);
    else
      System.out.printf("%2d %-7s %2d     ",node.id,node.name,row);
    System.out.println();
  }
  //----------------------------------------------------------------------------
  public void showGrid(int grid[][],String fname)
  {
    int row = 0;
    int col;

    prtDashes();
    System.out.println(fname);
    System.out.println("Lvl Count");

    while(grid[row][0] != 0) //stop at unused rows
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
    for(int i=0;i<90;i++)
      System.out.print("-");
    System.out.println();
  }
  //----------------------------------------------------------------------------
  public void addNode(int id, String name)
  {
    Node parent;
    Node current;
    Node newNode = new Node(id,name);

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
  //============================================================================
  private class Node                                       //private inner class
  {
    public int    id;
    public String name;
    public Node   left;
    public Node   right;

    public Node(int i,String n)     //constructor
    {
      id    = i;
      name  = n;
      left  = null;
      right = null;
    }
  }
  //============================================================================
}
