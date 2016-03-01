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
 * The Class PathWalker.
 */
public class PathWalker {
  
  /**
   * Goes to path regardless of the absolute or regular path.
   *
   * @param explorer the explorer
   * @param path the path
   * @return true, if successful
   */
  public static boolean goToPath(Directory explorer, String path) {

    if (!Pathchecker.pathCheck(explorer, path) && !path.equals("/")) {
      return false;
    }
    // System.out.println("This is printing" +path.startsWith("/"));
    if (path.startsWith("/")) {// absolute path
      // System.out.println( "This is printing");
      explorer.changeCurrentDir("/");

    }
    String path1[] = path.trim().split("/");
    for (int i = 0; i < path1.length; i++) {// go through all the direct
      if (path1[i].contentEquals("..")
          && !explorer.workingDir().contentEquals("/")) {
        explorer.changeCurrentDir(explorer.getParentDir());
      } else if (path1[i].contentEquals(".")) {
        return true;

      } else if (!path1[i].contentEquals("")) {// go into path
        explorer.cdOneDown(path1[i]);
      }
    }
    return true;
  }

}
