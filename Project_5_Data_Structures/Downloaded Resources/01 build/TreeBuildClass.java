//==============================================================================
// Program : TreeBuildClass.java
// Author  : K. Pappas
// Date    : 10/31/2012
// Abstract: Simple demo of building a binary search tree.
//==============================================================================
public class TreeBuildClass
{
  public TreeNodeIdName root;                                      //fields
  //----------------------------------------------------------------------------
  public TreeBuildClass()                                          //constructor
  {
    root = null;
  }
  //----------------------------------------------------------------------------
  public void addNode(int id, String name)                         //method
  {
    TreeNodeIdName current;
    TreeNodeIdName parent;
    TreeNodeIdName newNode = new TreeNodeIdName(id,name);

    if(root==null)
      root = newNode;                     //set 1st node at root
    else                               //or
      {                                   //navigate down to add node
        current = root;
        while(true)   //loop terminated by hitting a return statement
          {
            parent = current;
            if(id<current.id)                 //which direction to travel?
              {
                current = current.leftChild;     //take left branch
                if(current == null)              //test for bottom of path
                  {
                    parent.leftChild=newNode;    //attach new leaf
                    return;
                  }
              }
            else
              {
                current = current.rightChild;    //take right branch
                if(current == null)              //test for bottom of path
                  {
                    parent.rightChild=newNode;   //attach new leaf
                    return;
                  }
              }
          }//end while
      }//end else not root
  }
  //----------------------------------------------------------------------------
}
