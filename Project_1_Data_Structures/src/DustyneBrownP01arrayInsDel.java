//===============================================================================
// Project : Project 1 - Array Add Delete
// Author : Dustyne Brown
// Date : 9/11/13
// Abstract: Load in an array of number from a text file, then add or delete
// numbers from a different text file, before saving them. Numbers must stay
// in ascending order.
//===============================================================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//---------------------------------------------------------------------------------

public class DustyneBrownP01arrayInsDel 
{
    public static void main(String[] args) throws IOException 
    {
        
        String fileName1 = "inumsMst.txt";                          //Declare file locations and other main
        String fileName2 = "inumsAdd.txt";                          // variables.
        String fileName3 = "inumsDel.txt";
        String saveLocation = "DustyneBrownP01newNumList.txt";
        String userChoice;
        
        int userChoiceInt = 10;

        int[] intArray = new int[1000];
        
        intArray = arrayFiller(intArray, fileName1);                //Fill the array from the base list.

        while(userChoiceInt != 0)                                   //Create loop till user decides to exit.
        {
            userChoice = JOptionPane.showInputDialog(null, "Would you like to " +   //Base task selection window.
            		"add numbers to the array, " +
            		"delete them or exit? \n Enter 0 or press cancel to exit. \n " +
            		"Enter 1 to add. \n Enter 2 to delete. \n Enter 3 to save to file.", 
            		"What shall we do now?", JOptionPane.PLAIN_MESSAGE);
            
            while(!userChoice.equals("0") && !userChoice.equals("1") && 
                    !userChoice.equals("2") && !userChoice.equals("3"))
            {
                userChoice = JOptionPane.showInputDialog(null, "I'm sorry, what you " +   //Task selection if
                		"entered was not a valid option, please try again.\n " +          //first selection was
                		"Enter 0 or press cancel to exit. \n " +                          //an invalid option.
                        "Enter 1 to add. \n Enter 2 to delete. \n Enter 3 to save to file.", 
                        "Please Try Again", JOptionPane.PLAIN_MESSAGE);
            }
        
            userChoiceInt = Integer.parseInt(userChoice);
            
            if(userChoiceInt == 1)                                 //Selection to add numbers from the add list.
            {
                intArray = arrayAdder(intArray, fileName2);
                userChoice = "10";
                userChoiceInt = 10;
            }
            else if(userChoiceInt == 2)                            //Selection to remove number from the remove
            {                                                      // list.
                intArray = arrayDeleter(intArray, fileName3);
            }
            else if(userChoiceInt == 3)                            //Selection to safe array to a text file.
            {
                fileSaver(intArray, saveLocation);
            }
        }
    }
    
//---------------------------------------------------------------------------------
    
    private static int[] arrayFiller(int[] intArray, String fileSource) throws IOException
    {
        String dataHolder;                                    //Declare method variables.
        int counter = 0;
        
        FileReader fr =  new FileReader(fileSource);
        BufferedReader br = new BufferedReader(fr);
        
        while((dataHolder=br.readLine())!=null)             //Continue reading until text file line is empty.
        {
            intArray[counter] = Integer.parseInt(dataHolder);
            counter++;
        }
        
        fr.close();
        br.close();
        
        while(counter != intArray.length)               //Fill remaining slots with 0's.
        {
            intArray[counter] = 0;
            counter++;
        }
        
        intArray = arraySorter(intArray);
        
        return intArray;
    }
    
//---------------------------------------------------------------------------------
    
    private static int[] arraySorter(int[] intArray)
    {
        int temp = 0;
        
        for(int x1 = 0; x1 <= 999; x1++)
        {
            for(int x2 = 0; x2 < 999; x2++)
            {
                if(intArray[x2] > intArray[x2+1])
                {
                    if(intArray[x2] != 0 && intArray[x2+1] != 0)   //Bubble sort to organize array after
                    {                                              // first load.
                        temp = intArray[x2];
                        intArray[x2] = intArray[x2+1];
                        intArray[x2+1] = temp;
                    }
                    else
                    {
                        x2 = 1000;                                 //Breaks loop early if a 0 
                    }                                              // is already there.
                }
            }
        }
        
        return intArray;
    }
    
//---------------------------------------------------------------------------------

    private static int[] arrayAdder(int[] intArray, String fileSource) throws IOException
    {
        FileReader fr = new FileReader(fileSource);                 //Declare method variables.
        BufferedReader br = new BufferedReader(fr);
        
        String dataHolder = "";
        
        int sltSlct = 0;
        int counter = 0;
        int data;
        
        boolean passed = false;
        
        while((dataHolder=br.readLine())!=null)                     //Create loop to read until
        {                                                           // text file is empty.
            passed = false; 
            sltSlct = 0;
            
            data = Integer.parseInt(dataHolder);
            
            while(passed == false)                                  //Loops until a pass condition
            {                                                       //(Meaning the number is in place) is passed.
                if(data == intArray[sltSlct])
                {                                                   //Check for pre-existing numbers.
                    System.out.println("Add attempt - number already in list: " + data);
                    passed = true;
                }
                else if (data > intArray[sltSlct])                  //Checks if the read number is 
                {                                                   // larger than the number in slot.
                    if(sltSlct != 999)
                    {
                        sltSlct++;                            //Somehow was getting out of bounds errors, added
                    }                                         // a simple fail-safe.
                    else
                    {
                        passed = true;
                    }
                }
                else                                          //Initiates moving all numbers down one 
                {                                             // space to make room.
                    for(counter = 0; intArray[sltSlct + counter] != 0; counter++)
                    {
                                                        //Used to find where in the array the first 0 is.
                    }
                    for(; counter != 0; counter --)
                    {                                   //Copies every number to the next slot, working backwards 
                        intArray[sltSlct + counter] = intArray[sltSlct + (counter - 1)]; // to the insertion 
                    }                                                                    // point.
                    
                    intArray[sltSlct] = data;         //Insert read number.
                    passed = true;
                }
            }
        }
        
        fr.close();
        br.close();
        
        return intArray;
    }
    
//---------------------------------------------------------------------------------
    
    private static int[] arrayDeleter(int[] intArray, String fileSource) throws IOException
    {
        FileReader fr = new FileReader(fileSource);                 //Declare local variables.
        BufferedReader br = new BufferedReader(fr);
        
        String dataHolder = "";
        
        int data = 0;
        int sltSlct = 0;
        
        while((dataHolder=br.readLine())!=null)                     //Loop to read the text file.
        {
            data = Integer.parseInt(dataHolder);
            
            boolean passed = false;                                 //Reset boolean.
            
            while(passed == false)                  //Repeat loop until a pass point it met.
            {
                if(data == intArray[sltSlct])       //Check for a match.
                {
                    while(intArray[sltSlct] != 0)               //Make sure there wasn't a 0 in the text file or
                    {                                           // the code didn't move to far down the array.
                        intArray[sltSlct] = intArray[sltSlct + 1];
                        sltSlct++;                              // Move everything up one slot and pass the check.
                    }
                    
                    passed = true;
                }
                else if(intArray[sltSlct] == 0)                 //Check in case the number wasn't found by the 
                {                                               // array's first 0.
                    System.out.println("Del attempt - number not found: " + data);
                    passed = true;
                }
                else                                            //Increment and check the next slot.
                {
                    sltSlct++;
                }
            }
            
            sltSlct = 0;
        }
        
        fr.close();
        br.close();
        
        return intArray;
    }
    
//---------------------------------------------------------------------------------
    
    private static void fileSaver(int[] intArray, String saveLocation) throws IOException
    {
        FileWriter fw = new FileWriter(saveLocation);           //Declare method variables.
        PrintWriter pw = new PrintWriter(fw);
        
        String frmttdCount = "";                    
        
        int sltSlct = 0;
        
        while(intArray[sltSlct] != 0)
        {
            frmttdCount = formatter("[0000]", sltSlct);         //Pass number to a formatter.
            
            pw.printf("%4s%6s\r\n", frmttdCount, intArray[sltSlct]);  //Write to file.
            
            System.out.printf("%4s%6s\r\n", frmttdCount, intArray[sltSlct]);  //Write to line.
            
            sltSlct++;
        }
        fw.close();
        pw.close();
    }
    
//---------------------------------------------------------------------------------
    
    private static String formatter(String pattern, double value) 
    {                                                               //Accepts a pattern and value, then formats 
        DecimalFormat formatter = new DecimalFormat(pattern);       //that value into the pattern.
        String returnMe = formatter.format(value);
        return returnMe;
    }
}
