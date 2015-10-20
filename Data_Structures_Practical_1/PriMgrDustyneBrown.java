//======================================================================
// Assignment : Doubly Linked Priority Queue (practical exam files)
// Date       : 10/09/2013
// Author     : K. Pappas(started), completed by Xxxxxxxx Xxxxxxxx
// Abstract   : priority queue manager
//======================================================================
public class PriMgrDustyneBrown
{
  private PriNode head;
  private PriNode tail;
  private int     ctr;
  //--------------------------------------------------------------------
  public PriMgrDustyneBrown()                         //constructor
  {
    head = null;
    tail = null;
    ctr  = 0;
  }
  //--------------------------------------------------------------------
  public void addNode(String name,int priority)
  {
    PriNode newNode = new PriNode(name,priority);

    if(/* is list empty */)
      {
        //code to add 1st node
      }
    else
    if(/* is this higher than any priority so far */)
      {
        //code to add to top
      }
    else
    if(/* is this at least as low as the lowest priority so far */)
      {
        //code to add to bottom
      }
    else
      {
        insertNode(newNode); //needs to go somewhere in the list
      }

    ctr++;
  }
  //----------------------------------------------------------------------
  public void insertNode(PriNode newNode)
  {

    //code to find proper insertion point & insert new node

  }
  //----------------------------------------------------------------------
  public void listFwd()
  {
    PriNode currNode = head;
    int     n        = 1;

    while(currNode!=null)
      {
        System.out.printf("(%02d) %s %d\n",n,currNode.name,currNode.priority);
        currNode = currNode.next;
        n++;
      }
  }
  //----------------------------------------------------------------------
  public void listBwd()
  {
    PriNode currNode = tail;
    int     n        = ctr;

    while(currNode!=null)
      {
        System.out.printf("(%02d) %s %d\n",n,currNode.name,currNode.priority);
        currNode = currNode.prev;
        n--;
      }
  }
  //----------------------------------------------------------------------
}
