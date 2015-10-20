//===============================================================================
// Project : Project 2 Array Move Teams
// Author : Dustyne Brown
// Date : 9/17/13
// Abstract: Load 10 teams from a text file, then moved the teams based on user
// input, as well as make sure the data entered by the user is valid.
//===============================================================================

import java.io.*;
import javax.swing.JOptionPane;


public class dustyneBrownP02arrayMoveTeams 
{
  public static void main(String[] args) throws IOException 
  {
    boolean validInput = false;                       //Declares Variables
    
    String teamSource = "teams.txt";
    String userInput = "";
    
    String[] teamArray = new String[10];
    
    int[] twoPos = new int[2];
    
    twoPos[0] = 1;
    
    FileReader fr = new FileReader(teamSource);
    BufferedReader br = new BufferedReader(fr);
    
    int x = 0;
    
    teamArray = teamLoader(teamSource, teamArray, br, x);   //Load names from text file in an array.
    
    fr.close();
    br.close();
    
    arrayReader(teamArray, x);                              //Displays what is currently in the array.
    
    while(twoPos[0] != 0)
      {
        twoPos = getInput(userInput, validInput, twoPos);  //Gets and validates input.
        
        teamArray = teamMover(teamArray, twoPos, x);       //Moves teams based on input.
        
        arrayReader(teamArray, x);                         //Displays teams.
      }
    
  }
  
//--------------------------------------------------------------------------------- 
  
  private static String[] teamLoader(String source, String[] teamArray, 
      BufferedReader br, int x) throws IOException
  {
    for(x = 0; x < 10; x++)                                       //Reads in data.
      {
        teamArray[x] = br.readLine();
      }
    return teamArray;
  }

//---------------------------------------------------------------------------------
  
  private static int[] getInput(String userInput, boolean validInput, int[] twoPos)
  {
    String[] inputSplit = new String[2];
    
    int checkHolder;
    
    validInput = false;
    
    userInput = JOptionPane.showInputDialog(null, "Enter from,to positions (0 = Exit)", 
        "Proj 2 Dustyne Brown", JOptionPane.PLAIN_MESSAGE);          //Get input.

    while (validInput != true)
      {
        checkHolder = userInput.indexOf(",");                        //Locate the divider.
        
        if((int) userInput.charAt(0) == 48 && userInput.length() == 1)
          {
            twoPos[0] = 0;                                          //Check that 0 was entered
            twoPos[1] = 0;                                          // if no divider was found.
            validInput = true;
          }
        else
          if(checkHolder != -1)                                     //Makes sure divider was found.
            {
              inputSplit = userInput.split(",");
              
              try
                {
                  twoPos[0] = Integer.parseInt(inputSplit[0]);      //Makes the start was numeric.
                  
                  try
                    {
                      twoPos[1] = Integer.parseInt(inputSplit[1]);  //Makes sure second entry was nuermic.
                      
                      if(twoPos[0] > 0 && twoPos[0] < 11 && twoPos[1] > 0 && twoPos[1] < 11)
                        {
                          if(twoPos[0] != twoPos[1])                //Exists the while loop if 2 numerics
                            {                                       // and a divider was entered.
                              validInput = true;
                            }
                          else
                            {
                              userInput = JOptionPane.showInputDialog(null, "Enter from," +
                              		        "to positions (0 = Exit)\n\nAttempted Entry: " 
                              		        + userInput + "\nInvalid request - same from,to. " +
                              		        "Try Again.","Proj 2 Dustyne Brown", 
                              		        JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                      else
                        {
                          userInput = JOptionPane.showInputDialog(null, "Enter from,to positions " +
                        		          "(0 = Exit)\n\nAttempted Entry: " + userInput + "\n" +
                        		          "Invalid row number. Try Again.",
                        		          "Proj 2 Dustyne Brown", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                  catch (NumberFormatException e)
                    {
                      userInput = JOptionPane.showInputDialog(null, "Enter from,to positions (0 = " +
                                  "Exit)\n\nAttempted Entry: " + userInput + "\nIllegal" +
                                  		"character at position 2. Try Again.",
                                  "Proj 2 Dustyne Brown", JOptionPane.PLAIN_MESSAGE);
                    }
                }
              catch (NumberFormatException e)
                {
                  userInput = JOptionPane.showInputDialog(null, "Enter from,to positions (0 = " +
                              "Exit)\n\nAttempted Entry: " + userInput + "\nIllegal" +
                              "character at position 1. Try Again.",
                              "Proj 2 Dustyne Brown", JOptionPane.PLAIN_MESSAGE);
                }
            }
        else
          {
            validInput = false;
            userInput = JOptionPane.showInputDialog(null, "Enter from,to positions (0 = " +
            		        "Exit)\n\nAttempted Entry: " + userInput + "\nRequires 2 numbers, " +
            		        "with a separator (,) between the two. Try Again.",
            		        "Proj 2 Dustyne Brown", JOptionPane.PLAIN_MESSAGE);
          }
      }
    return twoPos;
  }
  
//---------------------------------------------------------------------------------
  
  private static String[] teamMover(String[] teamArray, int[] twoPos, int x)
  {
    String temp = "";
    
    x = 0;
    
    int gap = twoPos[0] - twoPos[1];                            //Calculates number of moves needed.
    
    if(gap < 0)                                                 //Moves from lower number to higher.
      {
        temp = teamArray[twoPos[0] - 1];
      
        gap = gap * -1;
        
        for(x = 0; x < gap; x++)
          {
            teamArray[(twoPos[0] - 1) + x] = teamArray[twoPos[0] + x];
          }
        
        teamArray[twoPos[1] - 1] = temp;
      }
    else
      if(gap > 0)                                             //Moves from higher to lower spots.
        {
          temp = teamArray[twoPos[0] - 1];
          
          for(x = 1; x <= gap; x++)
            {
              teamArray[(twoPos[0] - x)] = teamArray[(twoPos[0] -1) - x];
            }
          
          teamArray[twoPos[1] - 1] = temp;
        }
    
    return teamArray;
  }
  
//---------------------------------------------------------------------------------
  
  private static void arrayReader(String[] teamArray, int x)
  {
    System.out.printf("%4s\n", "----------------");             //Displays all data.
    for(x = 0; x < 10; x++)
      {
        System.out.printf("%2s%1s%-15s\n", (x + 1), " ", teamArray[x]);
      }
    
  }
}
