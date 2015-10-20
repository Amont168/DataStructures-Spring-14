//======================================================================
// Assignment : Doubly Linked Priority Queue (practical exam files)
// Date       : 10/09/2013
// Author     : K. Pappas
// Abstract   : driver class
//======================================================================
import javax.swing.JOptionPane;
public class PriDvr
{
  public static void main(String[] args)
  {
    PriMgrDustyneBrown priQ = new PriMgrDustyneBrown();

    priQ.addNode("A-----A",2); //name and priority
    priQ.addNode("B-----B",4);
    priQ.addNode("C-----C",6);

    priQ.addNode("AA----A",2);
    priQ.addNode("BB----B",4);
    priQ.addNode("CC----C",6);

    priQ.addNode("AAA---A",2);
    priQ.addNode("BBB---B",4);
    priQ.addNode("CCC---C",6);

    priQ.addNode("xxxxxxx",5); //try 1,2,3,4,5,6,7

    priQ.addNode("AAAA--A",2);
    priQ.addNode("BBBB--B",4);
    priQ.addNode("CCCC--C",6);

    priQ.addNode("AAAAA-A",2);
    priQ.addNode("BBBBB-B",4);
    priQ.addNode("CCCCC-C",6);

    priQ.addNode("AAAAAAA",2);
    priQ.addNode("BBBBBBB",4);
    priQ.addNode("CCCCCCC",6);

    System.out.println("-------Fwd--------");
    priQ.listFwd();
    System.out.println("-------Bwd--------");
    priQ.listBwd();
    System.out.println("-----------------");
  }
}
