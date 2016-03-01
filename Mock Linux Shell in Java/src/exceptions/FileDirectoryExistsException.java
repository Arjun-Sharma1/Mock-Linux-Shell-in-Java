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

package exceptions;


/**
 * Class Name: FileDirectoryExistsException is an exception class when a file or
 * directory is trying to be created when the same directory or file with the
 * same name exists.
 */
public class FileDirectoryExistsException extends Exception {
  
  /** The error. */
  private String error = "";

  /**
   * Instantiates a new file directory exists exception.
   *
   * @param input the input
   */
  public FileDirectoryExistsException(String input) {
    this.error = input;
  }

  /**
   * Gets the error.
   *
   * @return the error
   */
  public String getError() {
    return this.error;
  }
}
