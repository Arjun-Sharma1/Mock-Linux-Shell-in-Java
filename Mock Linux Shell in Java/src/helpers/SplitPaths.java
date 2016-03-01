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
 * Class Name: SplitPaths This class splits up a path into it's constituents a
 * directory path and a file ex. /1/2/3/4/5.txt splits into /1/2/3/4/ and 5.txt
 */
public class SplitPaths {
  /**
   * Processes an input string into their respective files divides it into a
   * path and a file
   * 
   * @param path The input that will be processed
   * @return output The file path and the file name that will be returned
   */
  public static String[] pathSplit(String input) {
    int fileSize = input.length(); // Get input's length
    // The file name is the last entry of / followed by the rest of the string
    String fileName = input.substring(input.lastIndexOf('/') + 1, fileSize);
    // The file path is the file name subtracted by the input's length
    String path = input.substring(0, fileSize - fileName.length());
    String[] output = {path, fileName}; // Create output array
    return output;
  }
}
