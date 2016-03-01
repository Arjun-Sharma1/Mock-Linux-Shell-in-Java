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

import org.junit.Before;
import org.junit.Test;

import commands.Cat;
import commands.Echo;
import commands.Mkdir;
import helpers.Directory;
import helpers.FileExists;

public class EchoTest {
  String input;
  Directory dir;
  Echo echo;
  Mkdir mkdir;
  String output;
  String expected;

  @Before
  public void setUp() {
    input = "";
    output = "";
    expected = "";
    dir = new Directory();
    echo = new Echo();
    mkdir = new Mkdir();
  }

  @Test
  public void testAddBase() {
    // Adds a file to the base directory
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    expected = "file";
    output = Cat.getFileInfo(dir, "fileName");
    assertEquals(expected, output);
  }

  @Test
  public void testAddAppend() {
    // Adds and appends a file
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    input = "echo \"add\" >> fileName";
    echo.execute(dir, input, null);
    expected = "fileadd";
    output = Cat.getFileInfo(dir, "fileName");
    assertEquals(expected, output);
  }

  @Test
  public void testAddAppendEdit() {
    // Adds and appends a file and rewrites the file
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    input = "echo \"add\" >> fileName";
    echo.execute(dir, input, null);
    output = Cat.getFileInfo(dir, "fileName");
    expected = "fileadd";
    assertEquals(expected, output);
    input = "echo \"reset\" > fileName";
    echo.execute(dir, input, null);
    expected = "reset";
    output = Cat.getFileInfo(dir, "fileName");
    assertEquals(expected, output);
  }

  @Test
  public void testCheckFileExists() {
    // Checks if file exists
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    boolean status = FileExists.getFileExists(dir, "fileName");
    assertEquals(true, status);
  }

  @Test
  public void testCheckFileNotExists() {
    // Checks if file doesn't exists
    boolean status = FileExists.getFileExists(dir, "fileName");
    assertEquals(false, status);
  }
}
