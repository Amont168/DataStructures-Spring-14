//==============================================================================
// Program : TreeNodeIdName.java
// Author  : K. Pappas
// Date    : 10/29/2012
// Abstract: Node class for tree examples.
//==============================================================================
public class TreeNodeIdName
{
  public int             id;
  public String          name;
  public TreeNodeIdName  leftChild;
  public TreeNodeIdName  rightChild;

  public TreeNodeIdName(int i,String n)     //constructor
  {
    id         = i;
    name       = n;
    leftChild  = null;
    rightChild = null;
  }
}