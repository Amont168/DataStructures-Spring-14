//==============================================================================
// Program : TreeTraverse1class.java
// Author  : K. Pappas
// Date    : 10/31/2012
// Abstract: Driver to build and traverse a binary tree.
//==============================================================================
import java.util.*;
import java.io.*;
public class TreeTraverseClass
{
  public TreeNodeIdName root;

  public void loadfile() throws IOException
  {
    FileReader      diskIn = new FileReader("stuBalanced.txt");
    BufferedReader  fileIn     = new BufferedReader(diskIn);
    StringTokenizer tok;
    String          rec;
    int             id;
    String          name;

    while ((rec = fileIn.readLine()) != null)
      {
        tok  = new StringTokenizer(rec,",");
        id   = Integer.parseInt(tok.nextToken());
        name = tok.nextToken();
        addNode(id,name);
      }

    fileIn.close();
  }
  //----------------------------------------------------------------------------
  public void addNode(int id, String name)
  {
    TreeNodeIdName current;
    TreeNodeIdName parent;
    TreeNodeIdName newNode = new TreeNodeIdName(id,name);

    if(root==null)
      root = newNode;                  // set root
    else                             // or
      {                                // navigate down to insertion point
        current = root;
        while(true)
          {
            parent = current;
            if(id<current.id)
              {
                current = current.leftChild;
                if(current == null)
                  {
                    parent.leftChild=newNode;
                    return;
                  }
              }
            else
              {
                current = current.rightChild;
                if(current == null)
                  {
                    parent.rightChild=newNode;
                    return;
                  }
              }
          }//end while
      }//end else not root
  }
  //----------------------------------------------------------------------------
  public void listPreOrder(TreeNodeIdName localRoot)
  {
    if(localRoot==null)
      return;

    System.out.printf("\n%3d %s",localRoot.id,localRoot.name);
    listPreOrder(localRoot.leftChild);
    listPreOrder(localRoot.rightChild);
  }
  //----------------------------------------------------------------------------
  public void listInOrder(TreeNodeIdName localRoot)
  {
    if(localRoot==null)
      return;

    listInOrder(localRoot.leftChild);
    System.out.printf("\n%3d %s",localRoot.id,localRoot.name);
    listInOrder(localRoot.rightChild);
  }
  //----------------------------------------------------------------------------
  public void listPostOrder(TreeNodeIdName localRoot)
  {
    if(localRoot==null)
      return;

    listPostOrder(localRoot.leftChild);
    listPostOrder(localRoot.rightChild);
    System.out.printf("\n%3d %s",localRoot.id,localRoot.name);
  }
  //----------------------------------------------------------------------------
}
