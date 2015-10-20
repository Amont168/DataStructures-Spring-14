//======================================================================
// Assignment : Doubly Linked Priority Queue (practical exam files)
// Date       : 10/10/2013
// Author     : K. Pappas
// Abstract   : node class (do not change any code in this class)
//======================================================================
public class PriNode
{
  public PriNode prev = null;
  public String  name;
  public int     priority;
  public PriNode next = null;

  public PriNode(String n, int p)
  {
    name     = n;
    priority = p;
  }
}
