//======================================================================
// Assignment : Doubly Linked List
// Date       : 10/03/2013
// Author     : K. Pappas
// Driver     : DblLLDvr.java
// Class      : DblLLMgr.java
// Node       : DblLLNode.java
// Abstract   : Basic doubly linked list programs (no validation)
//======================================================================
import javax.swing.JOptionPane;
public class DblLLDvr
{
  public static void main(String[] args)
  {
    int      insPt = 4;
    String   name  = "Zelda";

    DblLLMgr student = new DblLLMgr();

    student.addNode("Anna     1");
    student.addNode("Barbara  2");
    student.addNode("Cindy    3");
    student.addNode("Debbie   4");
    student.addNode("Eve      5");
    student.addNode("Fran     6");
    student.addNode("Gina     7");
    student.addNode("Heidi    8");
    student.addNode("Inga     9");
    student.addNode("Jeannie 10");

    System.out.println("-------Fwd--------");
    student.listFwd();
    System.out.println("-------Bwd--------");
    student.listBwd();
    System.out.println("-----------------");

    System.out.println("inserting " + name + " at " + insPt);
    student.insNode(name,insPt);

    System.out.println("-------Fwd--------");
    student.listFwd();
    System.out.println("-------Bwd--------");
    student.listBwd();
    System.out.println("-----------------");
  }
}
