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

package helpers;

import java.util.Hashtable;

/**
 * Class Name: InputParser,
 * Checks if input is valid or invalid.  
 */
public class InputParser {

  /**
   * Validates if the given input by the user and checks if it is correct
   *
   * @param input the input given to JShell
   * @return true, if the given input is an valid input
   */
  public static boolean validate(String input) {
    final int dataCap = Integer.MAX_VALUE;
    Hashtable<String, Integer> classes = new Hashtable<String, Integer>();
    classes.put("mkdir", dataCap);
    classes.put("grep", dataCap);
    classes.put("cd", 2);
    classes.put("ls", dataCap);
    classes.put("pwd", 3);
    classes.put("pushd", 2);
    classes.put("popd", 1);
    classes.put("history", 3);
    classes.put("cat", dataCap);
    classes.put("echo", dataCap);
    classes.put("man", 2);
    classes.put("exit", 1);
    classes.put("mv", dataCap);
    classes.put("cp", dataCap);
    classes.put("get", 2);
    String temp[] = input.trim().split("\\s+");
    if (classes.get(temp[0]) != null
        && classes.get(temp[0]) > (temp.length - 1)) {
      return true;
    }
    return false;
  }
}
