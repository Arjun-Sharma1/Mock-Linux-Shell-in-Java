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

import java.util.*;

import helpers.*;


/**
 * Class Name: Cat, This class holds methods to display the contents of FILE in
 * the shell.
 */
public class Cat implements CommandInterface {
  
  /**
   * Processes an input string into their respective files depending on how many
   * files are inputed.
   *
   * @param dir the dir
   * @param inputs The use input that will be broken down into seperate file
   *        Strings
   * @return output
   */
  public static List<String> interpreter(Directory dir, String inputs) {
    // Breaks down the file into separate Strings for each file name
    String[] all = inputs.trim().substring(3).trim().split("\\s+");
    Cd change = new Cd();
    String currentPath = Pwd.printDir(dir);
    SplitPaths divide = new SplitPaths();
    Pathchecker valid = new Pathchecker();
    List<String> output = new ArrayList(); // Output array
    // Cycles through paths
    for (int file = 0; file < all.length; file++) {
      change.switchDir(dir, currentPath); // Switch back to current directory
      String[] pathFile = divide.pathSplit(all[file]); // Path and file name
      if (pathFile[0].equals("")) { // Is a direct file
        output.add(getFileInfo(dir, all[file])); // Adds output
      } else if (valid.pathCheck(dir, pathFile[0])) {
        change.switchDir(dir, pathFile[0]); // Changes file path
        output.add(getFileInfo(dir, pathFile[1])); // Adds the output
      } else { // No file or directory
        output.add("cat: " + all[file] + ": No such file or directory");
      }
    }
    change.switchDir(dir, currentPath); // Returns to current path
    return output;
  }

  /**
   * Returns a string representation of the file and it's contents.
   *
   * @param dir the directory
   * @param file The file name that will be searched for
   * @return output
   */
  public static String getFileInfo(Directory dir, String file) {
    // Default return string
    String output = "cat: " + file + ": No such file or directory";
    // Gets list of current directory
    List<Tree> files = dir.rawWorkingDir().getRawChildren();
    // Loops through objects in the tree
    for (int data = 0; data < files.size(); data++) {
      // Checks if the nodes are of type File
      if (files.get(data).getRawItems() instanceof File) {
        // Gets the specific file object
        File current = (File) files.get(data).getRawItems();
        if (current.getFileName().equals(file)) {
          // Output changes if the file is found
          output = current.getContent();
        }
      }
    }
    // Returns output
    return output;
  }

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public void execute(Directory dir, String input, Stack Holder) {
    Cat.interpreter(dir, input);
    // Changes the list into an iterator
    Iterator out = Cat.interpreter(dir, input).iterator();
    // Outputs the files whether it is invalid or not
    while (out.hasNext()) {
      System.out.println(out.next());
    }
  }
}
