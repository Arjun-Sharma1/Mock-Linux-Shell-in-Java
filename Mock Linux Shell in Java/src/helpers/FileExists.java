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

import java.util.List;

/**
 * Class Name: FileExists,
 * Checks if a file is present in the current directory.
 */
public class FileExists {

  /**
   * Checks if the file exists in the tree.
   *
   * @param directory Navigates through the current directory
   * @param fileName The file name that will be searched for
   * @return exists Returns a boolean of whether the file exists or not
   */
  public static boolean getFileExists(Directory directory, String fileName) {
    boolean exists = false; // Files doesn't exist by default
    // Gets the objects in the current directory
    List<Tree> files = directory.rawWorkingDir().getRawChildren();
    // Loops through data
    for (int data = 0; data < files.size(); data++) {
      // Finds a File object
      if (files.get(data).getRawItems() instanceof File) {
        File current = (File) files.get(data).getRawItems();
        // File exists if the filename is the same as specified
        if (current.getFileName().equals(fileName)) {
          exists = true;
        }
      }
    }
    return exists; // Returns whether the file exists or not
  }
}
