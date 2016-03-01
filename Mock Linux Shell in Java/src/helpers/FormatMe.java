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

/**
 * Class Name: FormatMe,
 * Provides format for the raw input string, giving errors for incorrect 
 * characters.  
 */
public class FormatMe {
  
  /**
   * Checks if the input string contains invalid directory characters. Returns
   * true if string is valid false otherwise.
   *
   * @param input the input
   * @return boolean
   */
  public static boolean testDirString(String input) {
    String invalidChars = "!@$&*()?:[]\"<>\'`|={}\\,;";// invalid chars
    for (int i = 0; i < 23; i++) {// loop through all invalid
      if (input.contains("" + invalidChars.charAt(i))) {
        System.out.println("Directory Includes Invalid Character(s): "
            + invalidChars.charAt(i));
        return false;// error occurred
      } else if (input.contains(".") && !input.contains("/")) {
        System.out.println("Directory Includes Invalid Character(s): .");
        return false;// invalid character can imply up one directory
      }
    }
    return true;
  }

  /**
   * Cuts the input string up specific to the MkDir function Returns an array of
   * directories or an array of null if error occured.
   * 
   * @param input string of raw input from Jshell.
   * @return path, empty
   */
  public static String[] cutDirMkdir(String input) {
    input = input.trim().substring(5);// cut mkdir out
    if (FormatMe.testDirString(input)) {// check for invalid characters
      String path[] = input.trim().split("\\s+");// split paths
      return path;// send back
    }
    return null;// error occurred sending back null
  }
}
