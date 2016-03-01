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

import commands.Cd;
import commands.Mkdir;

/**
 * The Class Pathchecker.
 */
public class Pathchecker {

  /**
   * Pathcheck. Returns true if the given relative or absolute file path is
   * correct,false otherwise
   *
   * @param explorer is the directory the file path exists in
   * @param input the relative or absolute file path
   * @return boolean, returns true if the file path that was given is correct
   */
  public static boolean pathCheck(Directory explorer, String input) {
    String dirHolder = explorer.workingDir(); // holds current directory
    if (input == "/") {
      return true;
    }
    if (input.startsWith("/")) { // checks if path is absolute or relative
      String temp[] = input.trim().substring(1).split("/");
      explorer.changeCurrentDir("/");
      for (int x = 0; x < temp.length; x++) { // Iterates through path if valid
        if (!explorer.checkDir(temp[x])) {
          explorer.changeCurrentDir(dirHolder);
          return false;
        }
        if (explorer.peekType(temp[x]).equals("File")) {
          return true;
        }
        Cd.switchDir(explorer, temp[x]);
      }
    } else { // This only occurs if path is not absolute
      String temp[] = input.trim().split("/");
      for (int x = 0; x < temp.length; x++) { // Iterates through relative path
        if (!explorer.checkDir(temp[x])) {
          explorer.changeCurrentDir(dirHolder);
          return false; // If path is not found return false
        }
        if (explorer.peekType(temp[x]).equals("File")) {
          return true;
        }
        Cd.switchDir(explorer, temp[x]);
      }
    }
    explorer.changeCurrentDir(dirHolder); // If path is found return true
    return true;
  }
}
