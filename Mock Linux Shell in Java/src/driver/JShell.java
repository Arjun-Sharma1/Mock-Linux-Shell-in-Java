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
package driver;

import java.io.*;
import java.util.*;

import helpers.*;

/**
 * Class Name: JShell This class captures the input and based on it executes the
 * proper class or sends an error if.
 */
public class JShell {
  public static void main(String[] args) throws IOException {
    BufferedReader objReader =
        new BufferedReader(new InputStreamReader(System.in));
    Stack<String> holder = new Stack<String>(); // Stack for history
    String input = ""; // First input
    Directory dir = new Directory();
    // Exits if "exit" is inputed by the user
    while (!commands.Exit.checkString(input)) {
      System.out.print("/# "); // Path
      input = objReader.readLine().trim();// Input
      if (!input.isEmpty()) { // Creates a stack that holds all user input
        holder.push(input);
      }
      String command[] = input.trim().split("\\s+");// Splits the string
      // Checks if the command is valid
      if (input.isEmpty()) { // Does nothing if user input is empty
      } else if (InputParser.validate(command[0]) && !command[0].equals("echo")
          && (input.contains(">") || input.contains(">>"))) {
        StdOutput.stdOutput(dir, input, holder);
      } else if (input.matches("![0-9]+")) {
        input = "Number " + input;
        helpers.Reflection.execute(dir, input, holder);
      } else if (InputParser.validate(input)) { // Checks validity of path
        helpers.Reflection.execute(dir, input, holder);
      } else {
        System.out.println("Invalid input! Please try again");
      }
    }
  }
}
