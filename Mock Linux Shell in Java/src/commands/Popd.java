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

import helpers.Directory;

/**
 * Class Name: Popd This class holds methods removes the top entry from the
 * directory stack, and cd into it.
 */
public class Popd implements CommandInterface {

  /**
   * Checks if there is a directory in the stack and cd's into it.
   *
   * @param explorer the explorer
   */
  public static void popd(Directory explorer) {
    if (Pushd.getStack().size() > 0) {
      explorer.changeCurrentDir("/");
      Cd.switchDir(explorer, (String) Pushd.getStack().pop());
    } else {
      System.out.println("popd: directory stack empty");
    }

  }

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    popd(dir);
  }
}
