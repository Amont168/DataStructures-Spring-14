//==============================================================================
// Program : TreeSearchApp.java
// Author  : K. Pappas
// Date    : 10/29/2012
// Abstract: Build tree and search for a node.
//==============================================================================
import java.io.*;
public class TreeSearchApp
{
  public static void main(String[] args) throws IOException
  {
    TreeSearchClass  myTree = new TreeSearchClass();//also loads file

    String msg;

    msg = myTree.find(10);

    System.out.println();
    System.out.println(msg);
  }
}