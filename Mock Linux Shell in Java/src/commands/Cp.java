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

import java.util.List;
import java.util.Stack;

import helpers.Directory;
import helpers.File;
import helpers.FormatMe;
import helpers.PathWalker;
import helpers.Pathchecker;
import helpers.Tree;


public class Cp implements CommandInterface {

  /**
   * Checks the path from the given string, holds the copied tree, pastes it in
   * the new destination if it exists.
   * 
   * @param explorer, holds the series of directories
   * 
   * @param dir, holds the target and destination path
   */
  protected static boolean CopyDir(Directory explorer, String[] dir) {
    if (dir[0].equals(".") && dir[1].equals(".")) {
      System.out.println("Cannot make same directory sub-directory of itself.");
    }
    String initialDir = Pwd.printDir(explorer);// original directory holder
    if (PathWalker.goToPath(explorer, dir[0])) { // path that needs to be copied
      Tree temp = copyFolders(explorer); // recursively duplicate tree
      PathWalker.goToPath(explorer, initialDir); // go back to original
      if (PathWalker.goToPath(explorer, dir[1])) { // go to destination
        explorer.insertMe(temp, explorer.rawWorkingDir());// put the duplicate
        PathWalker.goToPath(explorer, initialDir);// go back to original
        return true;
      } else {
        System.out.println("Second path does not exist");
        return false;
      }
    } else {
      System.out.println("First path does not exist");
      return false;
    }


  }

  /**
   * Recursively copies the tree and its children. The function copies all the
   * sub-directories that are under the current directory.
   * 
   * @param explorer, holds the series of directories
   * 
   * @return Tree, returns the copy of the directories below the current one.
   */
  private static Tree copyFolders(Directory explorer) {
    if (explorer.getContents().trim() == "") {// no sub directories
      return new Tree(explorer.workingDir()); // base case
    } else {
      Tree temp = new Tree(explorer.workingDir()); // current directory tree
      String oldDir = explorer.workingDir();
      List objects = explorer.getRawChildren();// all sub-directories
      for (int i = 0; i < objects.size(); i++) {
        if (((Tree) objects.get(i)).getRawItems() instanceof File) {
          File tempf = // copying file data
              new File(
                  ((File) ((Tree) objects.get(i)).getRawItems()).getFileName(),
                  ((File) ((Tree) objects.get(i)).getRawItems()).getContent());
          temp.addChild(new Tree(tempf));
          if (explorer.workingDir().equals("/")) {// no need to copy whole tree
            return new Tree(tempf);
          }
        } else if (((Tree) objects.get(i)).getRawItems() instanceof String) {
          explorer.cdOneDown(((Tree) objects.get(i)).getItems()); // go into it
          temp.addChild(copyFolders(explorer)); // recursive call
          explorer.changeCurrentDir(oldDir); // change back to original
        }
      }
      return temp; // return whole tree
    }
  }

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    if (input.trim().length() < 3) {
      System.out.println("Not valid input. There are no arguments");
    } else {
      String[] paths = input.substring(3).trim().split("\\s+"); // get array of
      // paths
      Cp.CopyDir(dir, paths);
    }
  }
}
