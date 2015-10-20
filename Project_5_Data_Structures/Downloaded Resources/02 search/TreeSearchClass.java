///==============================================================================
// Program : TreeSearchClass.java
// Author  : K. Pappas
// Date    : 10/31/2012
// Abstract: class for tree search
//==============================================================================
import java.util.*;
import java.io.*;
public class TreeSearchClass
{
  public TreeNodeIdName root;
  //----------------------------------------------------------------------------
  public TreeSearchClass() throws IOException
  {
    FileReader      fr = new FileReader("stuBalanced.txt");
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
  public void addNode(int id, String name)
  {
    TreeNodeIdName current;
    TreeNodeIdName parent;
    TreeNodeIdName newNode = new TreeNodeIdName(id,name);

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
  public String find(int key)
  {
    TreeNodeIdName current;
    String         msg;
    int            lvl = 0;

    current = root;

    while(current!=null && current.id!=key)
      {
        if(key<current.id)
          current = current.leftChild;
        else
          current = current.rightChild;
        lvl++;
      }

    if(current!=null)
      msg = "Record located: " + current.id + " " + current.name + " (Level " + lvl + ")";
    else
      msg = "Record " + key + " not found";

    return msg;
  }
  //----------------------------------------------------------------------------
}
