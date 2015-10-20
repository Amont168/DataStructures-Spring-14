//======================================================================
// Assignment : Doubly Linked List
// Date       : 10/03/2013
// Author     : K. Pappas
// Driver     : DblLLDvr.java
// Class      : DblLLMgr.java
// Node       : DblLLNode.java
// Abstract   : Basic doubly linked list programs
//======================================================================
public class DblLLMgr
{
  private DblLLNode head;
  private DblLLNode tail;
  private int       ctr;
//----------------------------------------------------------------------
  public DblLLMgr() //constructor
  {
    head = null;
    tail = null;
    ctr  = 0;
  }
//----------------------------------------------------------------------
  public void addNode(String n)  //fifo
  {
    DblLLNode newNode = new DblLLNode();
    newNode.name = n;
    if(head==null)              //adding first node
      {
        head         = newNode;
        tail         = newNode;
      }
    else
      {
        tail.next    = newNode;
        newNode.prev = tail;
        tail         = newNode;
      }
    ctr++;
  }
//----------------------------------------------------------------------
  public void listFwd()
  {
    DblLLNode currNode = head;
    int       n = 1;

    while(currNode!=null)
      {
        System.out.printf("(%02d) %s\n",n,currNode.name);
        currNode = currNode.next;
        n++;
      }
  }
//----------------------------------------------------------------------
  public void listBwd()
  {
    DblLLNode currNode = tail;
    int       n        = ctr;

    while(currNode!=null)
      {
        System.out.printf("(%02d) %s\n",n,currNode.name);
        currNode = currNode.prev;
        n--;
      }
  }
//----------------------------------------------------------------------
  public void insNode(String n, int pos)
  {
    DblLLNode newNode  = new DblLLNode();
    newNode.name       = n;
    DblLLNode currNode = head;
    int i;

    if(pos==1)
      {
        head.prev    = newNode;
        newNode.next = head;
        head         = newNode;
      }
    else
      {
        for(i=1;i<pos-1;i++)
          currNode = currNode.next;

        newNode.prev      = currNode;
        newNode.next      = currNode.next;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
      }
    ctr++;
  }
//----------------------------------------------------------------------
}
