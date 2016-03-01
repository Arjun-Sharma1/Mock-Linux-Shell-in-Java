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

/**
 * Class Name: File,
 * This class holds the file name and its contents and returns them at command.  
 */
public class File {
  
  /** The file name. */
  private String fileName = "";
  
  /** The content. */
  private String content = "";

  /**
   * Constructs the file object.
   *
   * @param newFile the name of the file
   * @param newContent the content of the file 
   */
  public File(String newFile, String newContent) {
    this.fileName = newFile;
    this.content = newContent;
  }

  /**
   * Sets the fileName of the file.
   *
   * @param file the new fileName to be replaced
   */
  public void setFileName(String file) {
    this.fileName = file;
  }

  /**
   * Sets the content of the file.
   *
   * @param set the new content to be rewritten
   */
  public void setContent(String set) {
    this.content = set;
  }

  /**
   * Gets the file name.
   *
   * @return fileName, Returns the file's name
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * Gets the content.
   *
   * @return content, Returns the file's content
   */
  public String getContent() {
    return content;
  }
}
