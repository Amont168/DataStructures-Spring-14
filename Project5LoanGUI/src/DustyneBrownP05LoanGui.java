//===============================================================================
// Project : Project 5 - Loan GUI
// Author : Dustyne Brown
// Date : 4/27/13
// Abstract: First class creates the user GUI, which allows the user to enter 
// data into the text fields. The main GUI also offers 3 buttons to preform
// calculations based on the entered data. The first button (Can also be accessed
// by pressing enter in the 3rd field) calculates the minimum monthly payment to
// pay off the debt in the length of time at the interest rate entered by the
// user. The second button does the same as the first, in addition to displaying
// how much the user's debt would be after each month, and displaying how much
// they payed total. The final button clears all entered data.
//===============================================================================
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class DustyneBrownP05LoanGui 
{
    static JTextField prinF = new JTextField();   //Generates the GUI's text fields as static JFrame text
	static JTextField intF  = new JTextField();	  //fields.
	static JTextField termF = new JTextField();
	static JTextField payF  = new JTextField();

	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Dustyne Brown " +		//Creates the entire JFrame and it's title.
				"- Loan Payment Calculator");
		
		payF.setEditable(false);						 //Changes the pay text field to be un-editable before
														//anything else begins
		
		LoanDateUtility utility = new LoanDateUtility();  //Calls the time and date from the file
		String dateS = utility.getDateTimeStamp();		  //LoanDateUtility.java
		
		JLabel date   = new JLabel(dateS);				 //Creates all labels used by the GUI
		JLabel prinL  = new JLabel("Principal");
		JLabel intL   = new JLabel("Int Rate");
		JLabel termL  = new JLabel("Term");
		JLabel payL   = new JLabel("Payment");
			
		JPanel topPanel = new JPanel();					//Creates all panels used by the GUI
		JPanel midPanel = new JPanel();
		JPanel midLeft = new JPanel();
		JPanel midRight = new JPanel();
		JPanel botPanel = new JPanel();
		
		JButton calc = new JButton("Calculate");		//Creates all buttons used by the GUI
		JButton sched = new JButton("Schedule");
		JButton clear = new JButton("Clear");
		
		topPanel.setLayout(new BorderLayout());		  //Creates the top panel (Containing the date and time)
		topPanel.add(date, BorderLayout.CENTER);	  //to be used the the GUI
		date.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		midLeft.setLayout(new GridLayout(4,1));		 //Creates the grid layout on the left(X wise) in 
		midLeft.add(prinL);						     //middle (Y Wise) to be used by the GUI
		midLeft.add(intL);							 //(This is all labels)
		midLeft.add(termL);
		midLeft.add(payL);
		
		midRight.setLayout(new GridLayout(4,1));	//Lays out the rest of the middle(Y wise) of the GUI
		midRight.add(prinF);						//(This is all text fields)
		midRight.add(intF);
		midRight.add(termF);
		midRight.add(payF);
		
		midPanel.setLayout(new BorderLayout());		//Lays the middle(Y Wise) of the GUI into one piece, putting
		midPanel.add(midLeft, BorderLayout.WEST);	//the labels on the left, and the text fields over the rest
		midPanel.add(midRight, BorderLayout.CENTER); //of the area
		
		botPanel.setLayout(new GridLayout(1,3));	//Positions the 3 buttons on the GUI in a row
		botPanel.add(calc);
		botPanel.add(sched);
		botPanel.add(clear);
		
		frame.setLayout(new BorderLayout());		//Adds the 3 major panels to the GUI, the top(date panel) 
		frame.add(topPanel, BorderLayout.NORTH);    // in a smaller, non-growing area, then the labels and text
		frame.add(midPanel, BorderLayout.CENTER);   //fields are allowed to grow, while the button panel is not
		frame.add(botPanel, BorderLayout.SOUTH);
		
		int frameX = 400;							//Creates the GUI size and positions it in the middle of the 
		int frameY = 300;							//screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		int xLoc = (screenWidth / 2) - (frameX / 2);
		int yLoc = (screenHeight / 2) - (frameY / 2);
		
		frame.setSize(frameX, frameY);				//Creates the GUI
		frame.setLocation(xLoc, yLoc);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtField textField = new txtField();		//Initializes all the objects that will relate to the 
		bttnCal buttonCalc = new bttnCal();			//action listener classes
		bttnSched buttonSched = new bttnSched();
		bttnClear buttonClear = new bttnClear();
		
		prinF.addActionListener(textField);			//Binds the functions of each field and button, the first 
		intF.addActionListener(textField);			//two fields advance the focus, while the calc button and
		termF.addActionListener(buttonCalc);		//terms field calculates the monthly payments and error checks
		calc.addActionListener(buttonCalc);			//the schedule button then writes the payment schedule and
		sched.addActionListener(buttonSched);		//the clear button erases all entered values
		clear.addActionListener(buttonClear);
	}
	
//===================== Private inner class for cursor advancement =========================

	private static class txtField implements ActionListener
	{
	    public void actionPerformed(ActionEvent event)             //Simple if else statement, stating that if
	    {                                                          //one of the first two fields has focus, it 
	      if(prinF.hasFocus())                                     //advances the cursor to the next field
	      {
	    	  intF.requestFocus();
	      }
	      else
	      {
	        termF.requestFocus();
	      }
	    }
	  }
	
//===================== Private inner class for calculating monthly payments ===============
//                         (Is used for the schedule button as well)
	
	private static class bttnCal implements ActionListener
	{
		@SuppressWarnings("unused")
        public void actionPerformed (ActionEvent event)
		{
			double dummy = checkEntry();        //Uses a dumbie value which is unused unless the schedule
		}                                        //button is used

//------------------------------------------------------------------------------------------	

		@SuppressWarnings("unused")
        private static double checkEntry()
		{
			String a, b, c;                                  //Get text from all fields then checks that they
			double d = 0, e = 0, f = 0, dummy = 0;          //are numeric
			boolean trueF = false;
			a = prinF.getText();
			b = intF.getText();
			c = termF.getText();
			trueF = checkMe.checker(a);
			while(trueF == false)                            //If the data entered isn't numeric, the user is
			{                                                //prompted for a numeric until one is entered, then 
				a = JOptionPane.showInputDialog(null, "Invalid. Try Again" +            //the numeric is entered
							"\r\nEnter Principal", "Error", JOptionPane.PLAIN_MESSAGE);  //into the GUI
				prinF.setText(a);
				trueF = checkMe.checker(a);
			}
			trueF = checkMe.checker(b);
			while(trueF == false)
			{
				b = JOptionPane.showInputDialog(null, "Invalid. Try Again" +
							"\r\nEnter Interest", "Error", JOptionPane.PLAIN_MESSAGE);
				intF.setText(b);
				trueF = checkMe.checker(b);
			}
			trueF = checkMe.checker(c);
			while(trueF == false)
			{
				c = JOptionPane.showInputDialog(null, "Invalid. Try Again" +
						"\r\nEnter Terms", "Error", JOptionPane.PLAIN_MESSAGE);
				termF.setText(c);
				trueF = checkMe.checker(c);				
			}
			d = Double.parseDouble(a);                               //Gathers all entered data to be passed to
			e = Double.parseDouble(b);                               //the monthly payment calculator
			f = Double.parseDouble(c);
			return dummy = calculate(d, e, f);                  //Returns the dummy variable, which is used by the
		}                                                        //schedule button, and starts the calculator
		
//------------------------------------------------------------------------------------------    

		private static double calculate(double d, double e, double f) 
		{
			double interestRate2 = e/100;				//Calculates the monthly payments, then sets the 
			double a = d * interestRate2;               //payment field to match it's calculation
			double b = interestRate2 / 12;
			b = 1 + b;
			double month2 = f * -1;
			double c = Math.pow(b, month2);
			c = 1 - c;
			c = 12 * c;
			double monthlyPayment = a / c;
			String monthlyPaymentF = formatMe.formatter("$###,###,###,###.00", monthlyPayment);
			payF.setText(monthlyPaymentF);
			return monthlyPayment;                      //Returns the payments to be used by the schedule button
		}
	}
	
//===================== Private inner class for writing the payment schedule ===============
	
	private static class bttnSched implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			double monthlyPayment = bttnCal.checkEntry();   //Pulls the monthly payment from the calculate button
			writer(monthlyPayment);                         //Starts the method to write the schedule
		}
		
//------------------------------------------------------------------------------------------
		
		private void writer(double monthlyPayment)
		{
			String a, b, c;                              //Initializes holder strings
			
			double loanAmount, interestRate, term;       //Initializes variables for calculating the schedule
			
			a = prinF.getText();                         
			b = intF.getText();
			c = termF.getText();
			
			loanAmount = Double.parseDouble(a);
			interestRate = Double.parseDouble(b);
			term = Double.parseDouble(c);
			
			interestRate = interestRate/100;
			
			String loanAmountF = formatMe.formatter("$###,###,###,###.00", loanAmount);	//Passes the format pattern
			String interestRateF = formatMe.formatter("###.0000", interestRate);		//and variables to my 
			String monthF = formatMe.formatter("####", term);							//formatter, preparing it 
			String monthlyPaymentF = formatMe.formatter("$###,###,###,###.00", monthlyPayment);      //for display.
			
			System.out.printf("%9s%25s\r\n", "Principal", loanAmountF);				//Displays entered information
			System.out.printf("%8s%26s\r\n", "Interest", interestRateF);            //and sets up schedule map
			System.out.printf("%4s%30s\r\n", "Term", monthF);
			System.out.printf("%7s%27s\r\n\r\n", "Payment", monthlyPaymentF);
			System.out.printf("%-4s%18s%15s%17s%22s%15s\r\n", "Num", "Beginning Balance", "Payment", 
					"Interest", "Principle Applied","End Balance");
			System.out.printf("%-4s%18s%18s%16s%20s%15s\r\n", "---", "-----------------", "-------------", 
					"------------", "-----------------","-----------");
			
			double totalPayment = 0;                             //Initializes totals over the table
			double totalInterest = 0;
			double totalPrincAppl = 0;
			
			for(int num = 1; num < term + 1; num++)
			{
				double interest = loanAmount * (interestRate/12); 			//Calculates the interest and formats
				String interestF = formatMe.formatter("###,###,###,###.00", interest);         //it for the table
				double interest2 = Double.parseDouble(interestF);					
			    
			    if((loanAmount + interest2) - monthlyPayment <= 1.00)	///If payment is within a small threshold,
			    {														//it finishes it that cycle.
			    	monthlyPayment = monthlyPayment + ((loanAmount + interest2) - monthlyPayment);
			    	monthlyPaymentF = formatMe.formatter("$###,###,###,###.00", monthlyPayment);
			    }

			    double prinApp = monthlyPayment - interest2;
			    double endBalance = loanAmount - prinApp;
			    
			    if (endBalance < 0)										//Added this, because for some reason, some
			    {														//end balances were displayed as "-0.00"
			    	endBalance = endBalance * -1;
			    }
			    
			    loanAmountF = formatMe.formatter("###,###,###,###.00", loanAmount);	//Formats the calculated 
				String prinAppF = formatMe.formatter("###,###,###,###.00", prinApp); //numbers for display
				String endBalanceF = formatMe.formatter("###,###,###,###.00", endBalance);
				
				System.out.printf("%3s%19s%18s%16s%20s%15s\r\n", num, loanAmountF, monthlyPaymentF, 
						interestF, prinAppF, endBalanceF);			//Displays formatted numbers
				
				totalPayment = totalPayment + monthlyPayment;           //Ads up the totals of each loop
                totalInterest = totalInterest + interest2;
                totalPrincAppl = totalPrincAppl + prinApp;
				
				loanAmount = endBalance;               
			}
			
			String totalPaymentF = formatMe.formatter("$###,###,###,###.00", totalPayment);	     //Formats final 
			String totalInterestF = formatMe.formatter("$###,###,###,###.00", totalInterest);    //totals
			String totalPrincApplF = formatMe.formatter("$###,###,###,###.00", totalPrincAppl);
			
			System.out.printf("%40s%16s%20s\r\n", "-------------", "------------", "-----------------" );
			System.out.printf("%22s%18S%16s%20s\r\n", "Totals", totalPaymentF, totalInterestF, totalPrincApplF);
		}
	}

//=========================== Private inner class to clear entered data ====================
	
	private static class bttnClear implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			prinF.setText("");
			intF.setText("");
			termF.setText("");
			payF.setText("");
		}
	}
	
//=========================== Private inner class to check entered data ====================
	
	private static class checkMe
	{
		private static boolean checker(String input) 
		{													//Checks that all things entered into jOption pane are 
			int checkerCount = 0;							//numeric or decimals. Any letters won't increment the 
														//checker, and causes it to return false and try again.
			for(int x = 0; x < input.length(); x++)
			{
				if (((int) input.charAt(x)) >= 48 && ((int) input.charAt(x)) <= 57 ||
					((int) input.charAt(x) == 46))
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
	
//=========================== Private inner class to format numerics =======================

	private static class formatMe
		{
		private static String formatter(String pattern, double value) 
			{
				DecimalFormat formatter = new DecimalFormat(pattern);		//that value into the pattern.
				String returnMe = formatter.format(value);
				return returnMe;
			}
		}
		
}
