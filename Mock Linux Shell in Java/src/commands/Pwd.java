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

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.Directory;

/**
 * Class Name: Pwd This class holds methods to show the current directories
 * path.
 */
public class Pwd implements CommandInterface {

  // Holds the current file path
  private Pwd getFilePath;

  /**
   * 
   * @param explorer
   * @return "/" if we are in root, else find the path of current dir and return
   *         it
   * 
   * @return printDir, string of the current working directory
   */
  public static String printDir(Directory directory) {
    String printDir = "";
    printDir = directory.workingDir() + "/";
    if (directory.workingDir() == "/") {
      // Checks if the working directory is the root of the tree
      return "/";
    } else {
      while (directory.getParentDir() != "/") {
        // Goes through the loop until the root directory is found
        printDir = directory.getParentDir() + "/" + printDir;
        // Concatenates the string name of all directories in to a string
        directory.changeCurrentDir(directory.getParentDir());
        // Makes the current directory the parent directory
      }
    }
    directory.changeCurrentDir(directory.getParentDir());
    printDir = printDir.substring(0, printDir.length() - 1);
    printDir = "/" + printDir;
    Cd.switchDir(directory, printDir);
    // Reverts the current directory to the directory before the
    // function was called
    return printDir;

  }

  public void execute(Directory dir, String input, Stack Holder) {
    String output = "";
    Pattern pattern = Pattern.compile(
        "(\\s*)^(pwd)(\\s+)"
            + "((>>|>)(\\s+)([^!@$\\&*()?:\\[\\]\"\\<\\>'`|={}\\;]+))",
        Pattern.DOTALL); // Includes \n in STRING
    Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) {
      Echo e = new Echo();
      output = printDir(dir);
      String file = "echo \"" + output + "\" " + matcher.group(4);
      e.execute(dir, file, null);
    } else if (input.split("\\s+").length == 1) {
      input = input.trim().substring(3);
      System.out.println(printDir(dir));
    } else {
      System.out.println("pwd: error: invalid arguments");
    }
  }
}
