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

    if(ctr == 0)
      {
      System.out.println("Check1" + name);
        head = newNode;
        tail = newNode;
      }
    else
    if(tail.priority > priority)
      {
      System.out.println("Check2" + name);
        insertNode(newNode);
      }
   else
   if(tail.priority >= priority)
     {
     System.out.println("Check3" + name);
     tail.next    = newNode;
     newNode.prev = tail;
     tail         = newNode;
     }
   else
     {
        System.out.println("Test309" + name);//needs to go somewhere in the list
        insertNode(newNode);
        tail.prev = tail;
        tail = newNode;
     }

    ctr++;
  }
  //----------------------------------------------------------------------
  public void insertNode(PriNode newNode)
  {

    PriNode target = head;
    for(int x = 0; x >= ctr; x++)
    {
      if(target.priority > newNode.priority)
      {
       head.prev = newNode;
       newNode.next = head;
       head = newNode;
      }
      else
      {
        target = target.next;
      }
    }//code to find proper insertion point & insert new node
    

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
