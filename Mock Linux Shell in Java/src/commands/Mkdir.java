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
import helpers.FormatMe;
import helpers.PathWalker;
import helpers.Tree;

/**
 * Class Name: Mkdir This class navigates through the directories and creates a
 * folder or creates a folder in the current directory.
 */
public class Mkdir implements CommandInterface {
  /**
   * Creates a specified directory. Returns error if path does not exist or if
   * directory already there.
   * 
   * @param files, holds the series of directories that newDir needs to be
   *        inserted into.
   * @param dir, the directory to be inserted, also can be a path of folders.
   */
  private static void makeDir(Directory files, String dir) {
    String oldDir = files.workingDir();// for switching back
    boolean inDir = true;
    String newDir = "";

    if (dir.lastIndexOf("/") > 0) {
      newDir = dir.trim().substring(dir.lastIndexOf("/") + 1);
      String path = dir.trim().substring(0, dir.lastIndexOf("/"));
      inDir = PathWalker.goToPath(files, path);
    } else {
      if (dir.startsWith("/")) {
        newDir = dir.trim().substring(1);
        files.changeCurrentDir("/");
      } else {
        newDir = dir.trim();
      }
    }
    if (!files.checkDir(newDir) && inDir) {// path does not exist
      Tree insert = new Tree(newDir);
      files.insertMe(insert, files.rawWorkingDir());
    } else if (files.checkDir(newDir) && inDir) { // path exists
      System.out
          .println("mkdir: cannot create directory '" + dir + "': File exists");
    } else if (!inDir) {
      System.out.println("mkdir: no such directory");
    }
    files.changeCurrentDir(oldDir);// change back to the old directory
  }

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    String[] path = FormatMe.cutDirMkdir(input); // get array of paths
    if (path != null && !input.trim().contentEquals("")) {// check for errors
      for (int i = 0; i < path.length; i++) {// go through all the paths
        makeDir(dir, path[i]);
      }
    } else {
      System.out.println("mkdir: Invalid input try again.");
    }
  }

}

