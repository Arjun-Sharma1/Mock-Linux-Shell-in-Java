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
 * Class Name: Pushd This class pops the directory that is stored in the stack
 * and changes the working directory to that directory.
 */
public class Pushd implements CommandInterface {
  
  /** The holder. */
  private static Stack holder = new Stack();

  /**
   * Pushd.
   *
   * @param explorer the explorer
   * @param dir the dir
   * @return 
   */
  public static String pushd(Directory explorer, String dir) {
    String temp = Pwd.printDir(explorer);
    String path[] = dir.trim().split("/");
    for (int i = 0; i < path.length; i++) {
      if (explorer.cdOneDown(path[i])) {
        holder.push(temp);
      } else {
        return "pushd: " + dir + ": No such file or directory";
      }
    }
    return "";
  }

  /**
   * Gets the stack.
   *
   * @return the stack
   */
  public static Stack getStack() {
    return holder;
  }
  
  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    input = input.substring(5).trim();
    System.out.println(pushd(dir, input));
  }
}
