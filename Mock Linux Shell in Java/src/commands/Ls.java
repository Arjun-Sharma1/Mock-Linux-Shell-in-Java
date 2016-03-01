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
 * Class Name: Ls This class prints out the contents of the current directory or
 * specified one.
 */
public class Ls implements CommandInterface {

  /**
   * Checks contents of a relative path(directory). Returns error if path does
   * not exist
   * 
   * @param explorer, holds the series of directories
   * @param input, the directory to be checked
   * @return contents, the contents of the current directory
   */
  public static String listDir(Directory explorer, String input) {
    String contents = "";// final string holder
    String oldDir = explorer.workingDir();// to roll back on directory
    if (input.contentEquals("")) {// single ls
      contents = Pwd.printDir(explorer) + ":"
          + explorer.rawWorkingDir().getChildren() + "\n";
      return contents;// return string for testing
    }
    String path[] = null;
    if (input.startsWith("/")) {
      path = input.trim().substring(1).split("/"); // Trims the input
      explorer.changeCurrentDir("/");
    } else {
      path = input.trim().split("/"); // Trims the input
    }
    boolean con = true;// directory we are looking for is child of current
    for (int i = 0; i < path.length - 1 && con; i++) { // go to path
      if (!path[i].contentEquals("")) {// ignore empty strings
        con = explorer.cdOneDown(path[i]);
      }
    }
    if (con
        && explorer.peekType(path[path.length - 1]).contentEquals("Folder")) {
      explorer.cdOneDown(path[path.length - 1]);// go into last folder
      contents = Pwd.printDir(explorer) + ":"
          + explorer.rawWorkingDir().getChildren() + "\n";
    } else if (con && explorer.checkDir(path[path.length - 1])) {// its a file
      contents = path[path.length - 1];
    } else if (!explorer.checkDir(path[path.length - 1])) {// not found
      contents = "ls: cannot access " + input + ": No such file or directory";
    }
    explorer.changeCurrentDir(oldDir);// go back to original directory
    return contents;
  }

  /**
   * Checks contents of a relative or absolute path and its lists all of its
   * subdirectories recuirsively. Returns error if path does not exist
   * 
   * @param dir, holds the series of directories
   * @return 
   */
  public static String recursivelyListAllDir(Directory dir) {
    String finalOutput= listDir(dir, ""); // Prints current directory
    if (dir.getContents().trim() == "") {// Base Case(directory has no children)
      // Stop recursion
    } else { // Goes through each childs subdirectories recursively
      String[] children = dir.getContents().trim().split("\\s+");
      for (String child : children) {
        if (dir.peekType(child).equals("Folder")) {// recursive only if folder**
          String dirHolder = dir.workingDir();
          Cd.switchDir(dir, child);
          finalOutput += "\n"+recursivelyListAllDir(dir);
          dir.changeCurrentDir(dirHolder);
        }
      }
    }
    return finalOutput;
  }

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    input = input.trim().substring(2);
    String path[] = input.trim().split("\\s+");
    for (String paths : path) {
      if (!path[0].contains("-R") && !path[0].contains("-r")) {
        System.out.println(listDir(dir, paths));
      } else {
        if (path.length < 2) {
          System.out.println(recursivelyListAllDir(dir));
        } else {
          if (paths.equals("-R") || paths.equals("-r")) {
          } else if (dir.peekType(paths).equals("File")) {
            System.out.println(paths);
          } else {
            String dirHolder = dir.workingDir();
            Cd.switchDir(dir, paths);
            System.out.println(recursivelyListAllDir(dir));
            dir.changeCurrentDir(dirHolder);
          }
        }
      }
    }
  }

}
