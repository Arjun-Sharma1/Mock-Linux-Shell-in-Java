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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helpers.*;
import exceptions.*;

/**
 * Class Name: Echo This class holds methods that creates a new file if OUTFILE
 * does not exists and erases the old contents if OUTFILE already exists.
 */
public class Echo implements CommandInterface {
  private static FileExists presentFile = new FileExists();
  private static PathWalker change = new PathWalker();

  /**
   * Processes the input as an array containing the contents, operations and
   * fileName/path
   * 
   * @param input Single string of the user input
   * @throws InvalidSyntaxException
   * @throws FileDirectoryExistsException
   */
  private static void commit(Directory dir, String input)
      throws InvalidSyntaxException, FileDirectoryExistsException {
    String currentPath = Pwd.printDir(dir); // Saves current path
    Pattern pattern = Pattern.compile(
        "(\\s*)^(echo)(\\s+)(\"+.*\"+)(\\s+)?"
            + "((>>|>)(\\s+)([^!@$\\&*()?:\\[\\]\"\\<\\>'`|={}\\;]+))?",
        Pattern.DOTALL); // Includes \n in STRING
    Matcher matcher = pattern.matcher(input);
    if (matcher.matches()) { // A valid input must fit the pattern
      String content = // Content for file
          matcher.group(4).substring(1, matcher.group(4).length() - 1);
      if (matcher.group(7) != null) { // Group 7 specifies the commands
        String[] pathFile =
            SplitPaths.pathSplit(currentPath + "/" + matcher.group(9));
        if ((currentPath.equals("/")) // Verifies path is root
            || Pathchecker.pathCheck(dir, pathFile[0])) { // Path isn't root
          PathWalker.goToPath(dir, pathFile[0]); // Changes to path directory
          if (matcher.group(7).equals(">") // File doesn't exist or > used
              || !FileExists.getFileExists(dir, pathFile[1])) {
            addFile(dir, content, pathFile[1]); // > operation
          } else if (matcher.group(7).equals(">>")) {
            appendExisting(dir, content, pathFile[1]); // >> operation
          }
        }
      } else { // Print command
        System.out.println(content); // Prints STRING
      }
    } else { // Invalid syntax
      input = input.trim().substring(4).trim().replaceAll("( )+", " ");
      throw new InvalidSyntaxException(input);
    }
    PathWalker.goToPath(dir, currentPath); // Returns to current path
  }

  /**
   * Rewrites a file's contents or creates a new file
   * 
   * @param directory Navigates through the current directory
   * @param content Contains the content of the file to be created/rewritten
   * @param file The file that will be modified
   * @return content Returns the contents of the file
   */
  private static String addFile(Directory dir, String content, String file)
      throws FileDirectoryExistsException {
    String output = "";
    if (presentFile.getFileExists(dir, file)) {
      // Gets the files in the current directory
      List<Tree> files = dir.rawWorkingDir().getRawChildren();
      for (Tree item : files) { // Loops through the current directory
        if (item.getRawItems() instanceof File) { // Checks if file is in dir
          File f = (File) item.getRawItems(); // Makes instance of the file
          // Modifies files if they are found
          if (f.getFileName().equals(file)) {
            // Changes file content
            f.setContent(content);
          }
        }
      }
    } else if (dir.checkDir(file)) {
      throw new FileDirectoryExistsException(file);
    } else if (!presentFile.getFileExists(dir, file)) {
      // Inserts the File into the tree if the file doesn't exist
      Tree insert = new Tree(new File(file, content));
      dir.insertMe(insert, dir.rawWorkingDir());
      output = content; // Output message
    }

    return content; // Output message
  }

  /**
   * Appends content to a file if it exists
   * 
   * @param directory Navigates through the current directory
   * @param content Contains the content of the file to be appended
   * @param file The file name that be modified
   * @return content Returns the contents of the file
   */
  private static String appendExisting(Directory directory, String content,
      String file) {
    StringBuilder output = new StringBuilder();
    // Gets the files in the current directory
    List<Tree> files = directory.rawWorkingDir().getRawChildren();
    // Loops through the current directory
    for (Tree item : files) {
      // Creates file objects if files are found
      if (item.getRawItems() instanceof File) {
        File f = (File) item.getRawItems(); // Makes instance of the file
        // Modifies files if they are found
        if (f.getFileName().equals(file)) {
          // Changes file content
          f.setContent(f.getContent() + content);
          content = f.getContent(); // Changes output message
        }
      }
    }
    return content; // Output message
  }

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    try {
      commit(dir, input);
    } catch (InvalidSyntaxException e1) {
      System.out.println("echo: " + e1.getError() + ": invalid syntax");
    } catch (FileDirectoryExistsException e2) {
      System.out.println(
          "echo: cannot create file '" + e2.getError() + "': Directory exists");
    }
  }
}
