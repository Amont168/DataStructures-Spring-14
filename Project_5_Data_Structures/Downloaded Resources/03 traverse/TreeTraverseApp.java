//==============================================================================
// Program : TreeTraverseApp.java
// Author  : K. Pappas
// Date    : 10/29/2012
// Abstract: Driver to build and traverse a binary tree.
//==============================================================================
import java.io.*;
public class TreeTraverseApp
{
  public static void main(String[] args) throws IOException
  {
    TreeTraverseClass travObj = new TreeTraverseClass();

    travObj.loadfile();

    System.out.print("\n\n------------------ Pre Order ------------------");
    travObj.listPreOrder(travObj.root);

    System.out.print("\n\n------------------ In Order -------------------");
    travObj.listInOrder(travObj.root);

    System.out.print("\n\n----------------- Post Order ------------------");
    travObj.listPostOrder(travObj.root);
  }
}
