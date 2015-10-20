//===============================================================================
// Project : Project 04 - Amort Table
// Author : Dustyne Brown
// Date : 4/10/13
// Abstract: Collect user input about their loan amount, interest rate, and the
// length of their loan. It then calculates their monthly payments based on their
// entered information, and creates an amortization table, both on their display
// and as a text file. The program then asks them if they'd like to calculate 
// another loan, if so, writing both tables to the file.
//===============================================================================
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*; 

public class DustyneBrownP04Loan 
{
	public static void main(String[] args) throws IOException 
	{
		boolean numChecker = false;					//Check used to make sure that only numerics and 
													//decimals are entered into the JOption Pane
		double loanAmount = 0;						
		double interestRate = 0;					//Initialize numerics
		int month = 0;
		int collect2 = 121;
		
		String title = "Dustyne Brown";				//Initialize strings
		String loanAmountS = "";
		String interestRateS = "";
		String monthS = "";
		String loopAgain = "y";
		
		FileWriter fWriter = new FileWriter("DustyneBrownP04AmortTable.txt");		//Initialize file writer
        PrintWriter pWriter = new PrintWriter(fWriter);
		
		while(loopAgain == "y")								//Loop to do multiple tables
		{
			loanAmountS = JOptionPane.showInputDialog(null, "Enter Loan Amount", 
					title, JOptionPane.PLAIN_MESSAGE);
			numChecker = checker(loanAmountS);
			while(numChecker == false)						//While loop to check numerics
			{
				loanAmountS = JOptionPane.showInputDialog(null, "Invalid. Try Again." +
						"\r\nEnter Loan Amount", title, JOptionPane.PLAIN_MESSAGE);
				numChecker = checker(loanAmountS);
			}
			numChecker = false;
			loanAmount = Double.parseDouble(loanAmountS);
			interestRateS = JOptionPane.showInputDialog(null, "Enter interest rate",
					title, JOptionPane.PLAIN_MESSAGE);
			numChecker = checker(interestRateS);
			while(numChecker == false)
			{
				interestRateS = JOptionPane.showInputDialog(null, "Invalid. Try Again." +
						"\r\nEnter interest rate", title, JOptionPane.PLAIN_MESSAGE);
				numChecker = checker(interestRateS);
			}
			numChecker = false;
			interestRate = Double.parseDouble(interestRateS);
			monthS = JOptionPane.showInputDialog(null, "Enter term in months", 
					title, JOptionPane.PLAIN_MESSAGE);
			numChecker = checker(monthS);
			while(numChecker == false)
			{
				monthS = JOptionPane.showInputDialog(null, "Invalid. Try Again." +
						"\r\nEnter term in months", title, JOptionPane.PLAIN_MESSAGE);
				numChecker = checker(monthS);
			}
			month = Integer.parseInt(monthS);
			
			collect2 = calculateAndWriting(loanAmount, interestRate,	 //Passes off entered values to a
					month, title, pWriter); 							// method that calculates and writes 
																		//amort tables
			if (collect2 == 121)	
			{														//Checks that the value passed to collect2
				loopAgain = "y";									//is equal to y, if not, loopAgain is changed
			}														//to cancel the loop
			
			else
				loopAgain = "e";			
		}
		fWriter.close();
		
		
	}
	
//---------------------------------------------------------------------------------
	
	private static int calculateAndWriting(double loanAmount, double interestRate,
			double month, String title, PrintWriter pWriter) 
	{
		double interestRate2 = interestRate/100;				//Calculates monthlyPayments
		double a = loanAmount * interestRate2;
		double b = interestRate2 / 12;
		b = 1 + b;
		double month2 = month * -1;
		double c = Math.pow(b, month2);
		c = 1 - c;
		c = 12 * c;
		double monthlyPayment = a / c;
		
		String loanAmountF = formatter("$###,###,###,###.00", loanAmount);		//Passes the format pattern and
		String interestRateF = formatter("###.0000", interestRate);				//variable to my formatter,
		String monthF = formatter("####", month);								//preparing it for display.
		String monthlyPaymentF = formatter("$###,###,###,###.00", monthlyPayment);
		String monthlyPaymentF2 = monthlyPaymentF;
		
		System.out.printf("%9s%25s\r\n", "Principal", loanAmountF);				//Displays entered information
		System.out.printf("%8s%26s\r\n", "Interest", interestRateF);
		System.out.printf("%4s%30s\r\n", "Term", monthF);
		System.out.printf("%7s%27s\r\n\r\n", "Payment", monthlyPaymentF);
		System.out.printf("%-4s%18s%15s%17s%22s%15s\r\n", "Num", "Beginning Balance", "Payment", 
				"Interest", "Principle Applied","End Balance");
		System.out.printf("%-4s%18s%18s%16s%20s%15s\r\n", "---", "-----------------", "-------------", 
				"------------", "-----------------","-----------");
		
		pWriter.printf("%9s%25s\r\n", "Principal", loanAmountF);				//Writes the same information 
		pWriter.printf("%8s%26s\r\n", "Interest", interestRateF);				//to the output file
		pWriter.printf("%4s%30s\r\n", "Term", monthF);
		pWriter.printf("%7s%27s\r\n\r\n", "Payment", monthlyPaymentF);
		pWriter.printf("%-4s%18s%15s%17s%22s%15s\r\n", "Num", "Beginning Balance", "Payment", 
				"Interest", "Principle Applied","End Balance");
		pWriter.printf("%-4s%18s%18s%16s%20s%15s\r\n", "---", "-----------------", "-------------", 
				"------------", "-----------------","-----------");
		
		double totalPayment = 0;
		double totalInterest = 0;
		double totalPrincAppl = 0;
		String mon = formatter("########.##", monthlyPayment);
		monthlyPayment = Double.parseDouble(mon);
		for(int num = 1; num < month + 1; num++)
		{
			double interest = loanAmount * (interestRate2/12); 			//This till the printF calculates the
			String interestF = formatter("###,###,###,###.00", interest);//Amort table
			double interest2 = Double.parseDouble(interestF);					
		    
		    if((loanAmount + interest2) - monthlyPayment <= 1.00)	///If payment is within a small threshold,
		    {														//it finishes it that cycle.
		    	monthlyPayment = monthlyPayment + ((loanAmount + interest2) - monthlyPayment);
		    	monthlyPaymentF = formatter("$###,###,###,###.00", monthlyPayment);
		    }

		    double prinApp = monthlyPayment - interest2;
		    double endBalance = loanAmount - prinApp;
		    if (endBalance < 0)										//Added this, because for some reason, some
		    {														//end balances were displayed as "-0.00"
		    	endBalance = endBalance * -1;
		    }
		    totalPayment = totalPayment + monthlyPayment;
		    totalInterest = totalInterest + interest2;
		    totalPrincAppl = totalPrincAppl + prinApp;
		    	
			loanAmountF = formatter("###,###,###,###.00", loanAmount);	//Formats the calculated 
			String prinAppF = formatter("###,###,###,###.00", prinApp); //numbers for display
			String endBalanceF = formatter("###,###,###,###.00", endBalance);
			
			System.out.printf("%3s%19s%18s%16s%20s%15s\r\n", num, loanAmountF, monthlyPaymentF, 
					interestF, prinAppF, endBalanceF);			//Displays formatted numbers
			
			pWriter.printf("%3s%19s%18s%16s%20s%15s\r\n", num, loanAmountF, monthlyPaymentF, 
					interestF, prinAppF, endBalanceF);			//Writes formatted numbers to file.
			
			loanAmount = endBalance;
		}
		
		String totalPaymentF = formatter("$###,###,###,###.00", totalPayment);			//Formats final totals
		String totalInterestF = formatter("$###,###,###,###.00", totalInterest);
		String totalPrincApplF = formatter("$###,###,###,###.00", totalPrincAppl);
		
		System.out.printf("%40s%16s%20s\r\n", "-------------", "------------", "-----------------" );
		System.out.printf("%22s%18S%16s%20s\r\n", "Totals", totalPaymentF, totalInterestF, totalPrincApplF);
		System.out.printf("%1s", "---------------------------------------------------------------------------" +
				"---------------\r\n\r\n");					//Displays final totals
		
		pWriter.printf("%40s%16s%20s\r\n", "-------------", "------------", "-----------------" );
		pWriter.printf("%22s%18S%16s%20s\r\n", "Totals", totalPaymentF, totalInterestF, totalPrincApplF);
		pWriter.printf("%1s", "---------------------------------------------------------------------------" +
				"---------------\r\n\r\n");					//Writes final totals to the output file
		
		String collect = JOptionPane.showInputDialog(null, "Prin: " + loanAmountF + "\r\nInt: " + interestRate2 +
				"\r\nTerm: " + monthF + "\r\nPayment: " + monthlyPaymentF2 + "\r\nAnother? (y/n)", 
					title, JOptionPane.PLAIN_MESSAGE);			//Displays table info, and asks if they'd like to
																//calculate another
		int returnMe = ((int) collect.charAt(0));						//Casts their input into an int(easier to
		return returnMe;												//work with in my opinion)
		
		
	}
	
//---------------------------------------------------------------------------------
	
	private static String formatter(String pattern, double value) 
	{																//Accepts a pattern and value, then formats	
		DecimalFormat formatter = new DecimalFormat(pattern);		//that value into the pattern.
		String returnMe = formatter.format(value);
		return returnMe;
	}
	
//---------------------------------------------------------------------------------
	
	private static boolean checker(String input) 
	{													//Checks that all things entered into jOption pane are 
		int checkerCount = 0;							//numeric or decimals. Any letters won't increment the 
														//checker, and causes it to return false and try again.
		for(int x = 0; x < input.length(); x++)
		{
			if (((int) input.charAt(x)) >= 48 && ((int) input.charAt(x)) <= 57)
			{
				checkerCount++;
				if(checkerCount == input.length())
				{
					return true;
				}
			}
		}
		return false;
	}

}
