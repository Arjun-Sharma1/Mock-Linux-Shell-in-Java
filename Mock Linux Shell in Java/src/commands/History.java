// **********************************************************
// Assignment2:
// Student1:
// UTOR user_name: sharm389
// UT Student #: 1000275132
// Author: Arjun Sharma
//
// Student2:
// UTOR user_name: leejos14
// UT Student #: 1001175346
// Author: Joseph Lee
//
// Student3:
// UTOR user_name: zelenenk
// UT Student #: 1001400307
// Author: Taras Zelenenkyy
//
// Student4:
// UTOR user_name: ondertan
// UT Student #: 1001088468
// Author: Tanay Altan Onder
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************


package commands;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.Directory;

/**
 * Class Name: History This class holds methods that show the history of
 * previous typed commands
 */
public class History implements CommandInterface {
  // The stack that holds all of the commands
  private static Stack historyHolder;
  // The number of items the user wants to see(Optional parameter)
  private static int numOfitems;

  /**
   * This method prints out all of the commands in the history stack
   * 
   * @param Itemholder, the stack in which all commands are stored
   * @return finalOutput, a string
   */
  public static String showStack(Stack Itemholder) {
    historyHolder = Itemholder;
    int initialSize = historyHolder.size();
    String finalOutput = "";
    if (historyHolder.size() == 0) {
    }
    // Iterates through stack to print each element in it
    for (int element = 0; element < initialSize; element++) {
      if (element != initialSize - 1) {
        finalOutput +=
            (element + 1) + " " + historyHolder.elementAt(element) + "\n";
      } else {
        finalOutput += (element + 1) + " " + historyHolder.elementAt(element);
      }
    }
    return finalOutput;
  }

  // Prints all n-Number of items
  /**
   * This method Prints all n-Number of items specified by user
   * 
   * @param Itemholder, the stack in which all commands are stored
   * @param items
   * @return finalOutput, a string
   */
  public static String showStack(Stack Itemholder, int items) {
    historyHolder = Itemholder;
    numOfitems = items;
    String finalOutput = "";
    int numOfPops = historyHolder.size() - numOfitems;
    int initialSize = historyHolder.size();
    // Checks if n items specified by user is less than 0
    if (numOfitems < 0) {
      return "History out of Bounds";
    }
    // Checks if n items specified by user is greater then length of the stack
    else if (numOfPops < 0) {
      return showStack(Itemholder);
    }
    // Iterates through stack to print n-number of items requested by user
    else {
      for (int item = numOfPops; item < initialSize; item++) {
        if (item != initialSize - 1) {
          finalOutput +=
              (item + 1) + " " + historyHolder.elementAt(item) + "\n";
        } else {
          finalOutput += (item + 1) + " " + historyHolder.elementAt(item);
        }
      }
      return finalOutput;
    }
  }

  /**
   * Used by Jshell interface to execute the above methods
   */
  public void execute(Directory dir, String input, Stack Holder) {
    String output = "";
    Pattern pattern = Pattern.compile(
        "(\\s*)^(history)(\\s+)"
            + "((>>|>)(\\s+)([^!@$\\&*()?:\\[\\]\"\\<\\>'`|={}\\;]+))",
        Pattern.DOTALL); // Includes \n in STRING
    Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) {
      Echo e = new Echo();
      output = History.showStack(Holder);
      String file = "echo \"" + output + "\" " + matcher.group(4);
      e.execute(dir, file, null);
    } else {
      String input1 = input;
      input1 = input1.trim().substring(7).trim();
      if (input1.contains(" ")) {
        output = "history: too many arguments";
      } else {
        String temp[] = input.split(" ");
        if (temp.length == 1) {
          output = History.showStack(Holder);
        } else {
          output = History.showStack(Holder, Integer.parseInt(temp[1]));
        }
      }
      System.out.println(output);
    }
  }
}
