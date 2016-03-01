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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Stack;

import exceptions.*;
import helpers.*;

/**
 * Class Name: Get this class gets a text file from a url and adds it to the
 * current working directory
 */
public class Get implements CommandInterface {
  /**
   * Creates a text file from a website url
   * 
   * @param input Single string of the user input
   * @throws FileDirectoryExistsException
   */
  private static void getUrl(Directory dir, String input)
      throws FileDirectoryExistsException, MalformedURLException, IOException {
    // Trims the input so it is only a url
    input = input.trim().substring(3).trim();
    Echo e = new Echo();
    URL url;
    String fileName = SplitPaths.pathSplit(input)[1]; // Gets file name
    url = new URL(input);
    Scanner s = new Scanner(url.openStream()); // Opens web page
    String content = "";

    while (s.hasNext()) {
      content = content + s.nextLine() + "\n"; // Appends contents
    }
    // Adds file to current directory
    e.execute(dir, "echo \"" + content + "\" > " + fileName, null);
    s.close(); // Closes scanner
  }
  

  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack Holder) {
    try {
      getUrl(dir, input);
    } catch (FileDirectoryExistsException e1) {
      System.out.println(
          "echo: cannot create file '" + e1.getError() + "': Directory exists");
    } catch (MalformedURLException e2) { // Invalid url
      System.out.println("get: " + e2.getMessage() + ": url not found");
    } catch (IOException e3) { // Invalid syntax
      System.out.println("get: " + e3.getMessage() + ": invalid syntax");
    }
  }
}
