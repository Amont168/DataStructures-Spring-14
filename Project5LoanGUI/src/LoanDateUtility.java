//=============================================================================
// Program : Static date utility
// Author  : Ken Pappas
// Date    : 04/17/2013
// Abstract: Utility class. Provides date/time information to other programs.
//           Methods with example return values:
//           getAlphaDate()      Tuesday, January 12, 2010
//           getNumericDate()    01/12/2010
//           getTimeStamp()      11:00:40pm
//           getDateTimeStamp()  01/12/2010 11:00:40pm
//=============================================================================
import java.util.*;
public class LoanDateUtility
{
  //--------------------------fields-------------------------------------------
  private Calendar cal;
  private int      year;
  private int      month;
  private int      day;
  private int      dayOfWeek;
  private String   dayAlpha = "";
  private String   moAlpha  = "";
  private String   sMo;
  private String   sDay;
  private int      hour12;
  @SuppressWarnings("unused")
private int      hour24;
  private int      min;
  private int      sec;
  @SuppressWarnings("unused")
private int      ms;
  private int      ampm;
  private String   sHr;
  private String   sMin;
  private String   sSec;
  //---------------------------------------------------------------------------
  private void startup()
  {
    cal         = new GregorianCalendar();
    year        = cal.get(Calendar.YEAR);          // 2006
    month       = cal.get(Calendar.MONTH);         // 0=Jan, 1=Feb, ...
    day         = cal.get(Calendar.DAY_OF_MONTH);  // 1...
    dayOfWeek   = cal.get(Calendar.DAY_OF_WEEK);   // 1=Sunday, 2=Monday...
    hour12      = cal.get(Calendar.HOUR);          // 0..11
    hour24      = cal.get(Calendar.HOUR_OF_DAY);   // 0..23
    min         = cal.get(Calendar.MINUTE);        // 0..59
    sec         = cal.get(Calendar.SECOND);        // 0..59
    ms          = cal.get(Calendar.MILLISECOND);   // 0..999
    ampm        = cal.get(Calendar.AM_PM);         // 0=AM,1=PM
    month++;
    sMo         = "" + month;
    sDay        = "" + day;

    if(month<10)
      sMo  = "0" + month;

    if(day<10)
      sDay = "0" + day;

    switch(dayOfWeek)
      {
        case 1: dayAlpha = "Sunday";
                break;
        case 2: dayAlpha = "Monday";
                break;
        case 3: dayAlpha = "Tuesday";
                break;
        case 4: dayAlpha = "Wednesday";
                break;
        case 5: dayAlpha = "Thursday";
                break;
        case 6: dayAlpha = "Friday";
                break;
        case 7: dayAlpha = "Saturday";
      }

    switch(month)
      {
        case  1: moAlpha = "January";
                 break;
        case  2: moAlpha = "February";
                 break;
        case  3: moAlpha = "March";
                 break;
        case  4: moAlpha = "April";
                 break;
        case  5: moAlpha = "May";
                 break;
        case  6: moAlpha = "June";
                 break;
        case  7: moAlpha = "July";
                 break;
        case  8: moAlpha = "August";
                 break;
        case  9: moAlpha = "September";
                 break;
        case 10: moAlpha = "October";
                 break;
        case 11: moAlpha = "November";
                 break;
        case 12: moAlpha = "December";
      }


    if(hour12==0) //02/24/12 fixed error, show 12 when hour is 0
      hour12 =  12;

    if(hour12<10)
      sHr = "0" + hour12;
    else
      sHr = ""  + hour12;

    sMin        = "" + min;
    sSec        = "" + sec;

    if(min < 10)
      sMin = "0" + min;

    if(sec < 10)
      sSec = "0" + sec;
  }
  //----------------------------public methods---------------------------------
  public  String getAlphaDate()
  {
    String dateStr;
    startup();
    dateStr = String.format("%s, %s %s, %s",dayAlpha,moAlpha,day,year);
    return dateStr;
  }
  //---------------------------------------------------------------------------
  public String getNumericDate()
  {
    String dateStr;
    startup();
    dateStr = String.format("%s/%s/%s",sMo,sDay,year);
    return dateStr;
  }
  //---------------------------------------------------------------------------
  public String getTimeStamp()
  {
    String dateStr;
    String ampmStr;
    startup();
    if(ampm==0)
      ampmStr = "am";
    else
      ampmStr = "pm";
    dateStr = String.format("%s:%s:%s%s",sHr,sMin,sSec,ampmStr);
    return dateStr;
  }
  //---------------------------------------------------------------------------
  public String getDateTimeStamp()
  {
    String dateStr;
    String numericDate;
    String ampmStr;
    startup();
    if(ampm==0)
      ampmStr = "am";
    else
      ampmStr = "pm";
    numericDate = getNumericDate();
    dateStr = String.format("%s %s:%s:%s%s",numericDate,sHr,sMin,sSec,ampmStr);
    return dateStr;
  }
  //---------------------------------------------------------------------------
}