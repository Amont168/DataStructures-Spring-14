//==============================================================================
// Program : TreeBuildApp.java
// Author  : K. Pappas
// Date    : 10/29/2012
// Abstract: Simple demo of building a binary search tree.
//==============================================================================
import java.util.*;
import java.io.*;
public class TreeBuildApp
{
  public static void main(String[] args) throws IOException
  {
    FileReader       fr = new FileReader("stuBalanced.txt");
    BufferedReader   br = new BufferedReader(fr);

    TreeBuildClass   treeObj = new TreeBuildClass();

    StringTokenizer  tok;
    String           rec;
    int              id;
    String           name;

    while ((rec = br.readLine()) != null)          //loop to build tree
      {
        tok  = new StringTokenizer(rec,",");
        id   = Integer.parseInt(tok.nextToken());
        name = tok.nextToken();
        treeObj.addNode(id,name);                  //put node in tree
      }
    br.close();

    System.out.println();
    System.out.println(treeObj.root.name);
    System.out.println();
    System.out.println(treeObj.root.leftChild.name);
    System.out.println(treeObj.root.leftChild.leftChild.name);
    System.out.println();
    System.out.println(treeObj.root.rightChild.name);
    System.out.println(treeObj.root.rightChild.rightChild.name);
  }
}
