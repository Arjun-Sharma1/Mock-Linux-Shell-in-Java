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
 * Class Name: Directory,
 * This class holds the main tree and operates it helping other classes navigate
 * and create new folders/files.  
 */
public class Directory {
  
  /** The working dir. */
  private Tree workingDir = new Tree("/");


  /**
   * Returns true if the directory exists in current working directory, false
   * otherwise.
   *
   * @param dir contains the name of the folder to look for.
   * @return true, if successful
   */
  public boolean checkDir(String dir) {
    if (dir.contentEquals(".")) {
      return true;
    }
    String dirs[] = workingDir.getChildren().trim().split("\\s+");
    for (int i = 0; i < dirs.length; i++) {
      if (dirs[i].contentEquals(dir)) {
        return true;
      }
    }
    return false;
  }


  /**
   * Working dir.
   *
   * @return workingDir.getItems()  Returns all the files and folders in
   * current directory as a string.
   */
  public String workingDir() {
    return workingDir.getItems();
  }

  /**
   * Checks for children.
   *
   * @return true, if successful
   */
  public boolean hasChildren() {
    return !workingDir.isLeaf();
  }

  /**
   * Gets the contents.
   *
   * @return workingDir.getChildren(), Returns string of all children
   * in the current working directory.
   */
  public String getContents() {
    return workingDir.getChildren();
  }

  /**
   * Raw working directory.
   *
   * @return workingDir, Returns all the files and folders
   * in current directory as a list of trees.
   */
  public Tree rawWorkingDir() {
    return workingDir;
  }

  /**
   * Gets the raw children.
   *
   * @return the raw children
   */
  public List getRawChildren() {
    return workingDir.getRawChildren();
  }

  /**
   * Gets the parent dir.
   *
   * @return wokringDir.getParent().getItems,
   * Returns the contents of the parent directory as string.
   */
  public String getParentDir() {
    return workingDir.getParent().getItems();
  }


  /**
   * Changes working directory to newDir if exists, otherwise prints error.
   *
   * @param newDir the new directory
   */
  public void setDirectory(String newDir) {// only call this if directory exists
                                           // in current working directory.
    for (int i = 0; i < workingDir.getRawChildren().size(); i++) {
      if (((Tree) workingDir.getRawChildren().get(i)).getItems()
          .equals(newDir)) {
        workingDir = (Tree) workingDir.getRawChildren().get(i);
      }
    }
  }

  /**
   * Search through the working directory for the specified file/folder. Returns
   * the type of content in the tree node(file or folder) as string. Returns Not
   * found if the directory or file does not exist.
   *
   * @param newDir the new dir
   * @return string ("File", "Folder", "Not found")
   */
  public String peekType(String newDir) {
    if (newDir.contentEquals(".")) {
      return "Folder";
    }

    for (int i = 0; i < workingDir.getRawChildren().size(); i++) {
      if (((Tree) workingDir.getRawChildren().get(i)).getItems()
          .equals(newDir)) {
        if (((Tree) workingDir.getRawChildren().get(i))
            .getRawItems() instanceof String) {
          return "Folder";
        } else {
          return "File";
        }
      }
    }
    return "Not found";// true for folder false for folder
  }


  /**
   * Search through the working directory for the specified file/folder. Switch
   * to the directory if it exists, if not go up to root and look for it.
   *
   * @param newDir the new dir
   */
  public void changeCurrentDir(String newDir) {
    // System.out.println("THISSSS " + newDir);
    Tree tempDir = workingDir;// hold this, if dir does not exist, we go back to
                              // the old one.

    if (checkDir(newDir)) {// if the folder exists in current dir, switch
      setDirectory(newDir);
    } else if (workingDir.getItems() != "/") {// directory does not exist and
                                              // its not the root folder(so we
                                              // can go up)
      workingDir = workingDir.getParent();// go up
      while (workingDir.getItems() != "/") {// go through all the folders up
                                            // until root.
        if (checkDir(newDir)) {// found folder we need to switch to on way to
                               // root.
          setDirectory(newDir);// change directory
          break;// break loop because we found folder we were looking for
        } else {// did not find the folder in current dir
          workingDir = workingDir.getParent();// go up one more level
        }
      }
      if (workingDir.getItems() == "/") {// if loop dint find anything
        if (checkDir(newDir) || newDir == "/") {
          setDirectory(newDir);// set it
        } else {// directory does not exist
          workingDir = tempDir;// send back to original dir since the dir we
                               // were looking for does not exist
          System.err.println("Dir does not exist");// change to good error msg.
        }
      }
    }
  }

  /**
   * Goes in the directory that is in working directory, if it exists. Checks
   * for type and does not go in file.
   *
   * @param newDir the new dir
   * @return boolean
   */
  public boolean cdOneDown(String newDir) {

    if (newDir.contentEquals(".")) {
      return true;
    }
    if (checkDir(newDir) && peekType(newDir).contentEquals("Folder")) {
      setDirectory(newDir); // if the folder exists in current dir, switch
      return true;
    } else {
      return false;
    }
  }

  /**
   * Inserts a tree as a child to the current working directory.
   *
   * @param object the object
   * @param locationDir the location dir
   */
  public void insertMe(Tree object, Tree locationDir) {// folder insert
    locationDir.addChild(object);
  }

  public Object getChild(String childName) {
    for (int i = 0; i < workingDir.getRawChildren().size(); i++) {
      if (((Tree) workingDir.getRawChildren().get(i)).getItems()
          .equals(childName)) {

        return ((Tree) workingDir.getRawChildren().get(i)).getRawItems();

      }
    }
    return false;// true for folder false for folder
  }

}
