//==============================================================================
// Program  : Practical exam problem 1.
// Name     :                                                  // <--- YOUR NAME
// Date     : 05/01/2013
// Objective: Return true if "xyz" appears in the middle of a string.
//            For odd size arrays the 'y' must be in the middle element.
//            For even size arrays the 'y' can be in either of the middle two.
//            Numbers 1-12 should test true, 13-20 should test false
//==============================================================================
public class P01middleXyz(FirstnameLastname)                   // <--- YOUR NAME
{
  public static void main(String[] args)
  {
    System.out.println("01 result = " + xyzMiddle("xyz"));          // 1-12 true
    System.out.println("02 result = " + xyzMiddle("xyza"));
    System.out.println("03 result = " + xyzMiddle("axyz"));
    System.out.println("04 result = " + xyzMiddle("bxyzc"));
    System.out.println("05 result = " + xyzMiddle("caxyzd"));
    System.out.println("06 result = " + xyzMiddle("dxyzef"));
    System.out.println("07 result = " + xyzMiddle("eaxyzgh"));
    System.out.println("08 result = " + xyzMiddle("faxyzaia"));
    System.out.println("09 result = " + xyzMiddle("gaaxyzaj"));
    System.out.println("10 result = " + xyzMiddle("testxyztest"));
    System.out.println("11 result = " + xyzMiddle("yesxyzyes"));
    System.out.println("12 result = " + xyzMiddle("xyabxyzbayz"));
    System.out.println();
    System.out.println("13 result = " + xyzMiddle(""));           // 13-20 false
    System.out.println("14 result = " + xyzMiddle("y"));
    System.out.println("15 result = " + xyzMiddle("xy"));
    System.out.println("16 result = " + xyzMiddle("yz"));
    System.out.println("17 result = " + xyzMiddle("noxyzaaaaa"));
    System.out.println("18 result = " + xyzMiddle("cbaaaxyzaxy"));
    System.out.println("19 result = " + xyzMiddle("kxyzaayz"));
    System.out.println("20 result = " + xyzMiddle("caxyzwontpass"));
  }
  //----------------------------------------------------------------------------
  // Do not change anything in the main method.
  // Complete the code below. You can add additional methods if you desire.
  //----------------------------------------------------------------------------
  public static boolean xyzMiddle(String str)
  {

    return false; //  <--- alter to meet your needs
  }
  //----------------------------------------------------------------------------
}
