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

package test;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import commands.Cd;
import commands.History;
import commands.Ls;
import commands.Man;
import commands.Mkdir;
import helpers.Directory;

public class HistoryTest {
  Stack<String> commands = new Stack<String>();
  Ls ls;
  Mkdir mkDir;
  Cd cd;
  Directory dir;

  @Test // Adds multiple commands to history
  public void multipleCommandsInHistory() {
    commands.push("a");
    commands.push("2");
    commands.push("3");
    commands.push("mkdir 123");
    commands.push("history");
    String expectedVal =
        "1 a\n" + "2 2\n" + "3 3\n" + "4 mkdir 123\n" + "5 history";
    assertEquals(expectedVal, History.showStack(commands));
  }

  @Test // Checks if corrent first user input is returned
  public void oneCommand() {
    commands.push("history");
    String expectedVal = "1 history";
    assertEquals(expectedVal, History.showStack(commands));
  }

  @Test
  public void noCommands() { // Checks if no commands inputed by user
    String expectedVal = "";
    assertEquals(expectedVal, History.showStack(commands));
  }

  @Test // Shows the history of N items specified by user
  public void showNitems() {
    commands.push("hello");
    commands.push("cd poo");
    commands.push("ls");
    commands.push("mkdir 123");
    commands.push("history");
    String expectedVal = "3 ls\n" + "4 mkdir 123\n" + "5 history";
    assertEquals(expectedVal, History.showStack((commands), 3));
  }

  // Checks if user has put in a number greater than the commands that
  // have been used
  @Test
  public void showGreaterThanCommandsEntered() {
    commands.push("hello");
    commands.push("cd poo");
    commands.push("ls");
    commands.push("mkdir 123");
    commands.push("history");
    String expectedVal =
        "1 hello\n" + "2 cd poo\n" + "3 ls\n" + "4 mkdir 123\n" + "5 history";
    assertEquals(expectedVal, History.showStack((commands), 20));
  }
  
  @Test //Tests if user has entered a number that is negative
  public void negativeNumberInput() {
    commands.push("hello");
    commands.push("cd poo");
    commands.push("ls");
    commands.push("mkdir 123");
    commands.push("history");
    String expectedVal = "History out of Bounds";
    assertEquals(expectedVal, History.showStack((commands), -20));
  }

}
