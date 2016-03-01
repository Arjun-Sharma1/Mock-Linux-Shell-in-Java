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

import helpers.Directory;
import helpers.File;
import helpers.PathWalker;
import helpers.Tree;

import java.util.List;
import java.util.Stack;

public class Mv extends Cp {

  /**
   * Deletes the target path from the tree of directories.
   * 
   * @param explorer, holds the series of directories
   * 
   * @param input, holds the initial path marked for deletion
   */
  private void delPath(Directory explorer, String input) {
    String initialDir = Pwd.printDir(explorer); // original directory
    if (PathWalker.goToPath(explorer, input)) { // if its a path go to it
      if (!explorer.workingDir().contentEquals("/")) { // cannot delete root
        Tree object = explorer.rawWorkingDir(); // path to be deleted
        explorer.changeCurrentDir(explorer.getParentDir()); // go up
        explorer.getRawChildren().remove(object);// remove from children list
      }
    }
    if (input.contains("/")) {// if its a path and was not able to go into it
      input = input.substring(0, input.lastIndexOf("/"));
      PathWalker.goToPath(explorer, input);
    }
    List objects = explorer.getRawChildren();// list all sub-directories
    for (int i = 0; i < objects.size(); i++) {// for every directory in sub
      if (((Tree) objects.get(i)).getRawItems() instanceof File) {
        if (((File) ((Tree) objects.get(i)).getRawItems()).getFileName()
            .equals(input)) {
          explorer.getRawChildren().remove(objects.get(i)); // remove it
        }
      }
    }
    PathWalker.goToPath(explorer, initialDir); // go back to original path
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
      if (CopyDir(dir, paths)) {// copy the indicated directories or files
        delPath(dir, paths[0]); // delete the initial directories or files
      }
    }
  }
}
