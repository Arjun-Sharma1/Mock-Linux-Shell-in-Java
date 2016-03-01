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
import commands.*;
import helpers.*;

public class GetTest {

  String expected = "";
  boolean exBool = false;
  String actual = "";
  boolean actBool = false;
  String input = "";
  Mkdir m = new Mkdir();
  Get g = new Get();
  Cat c = new Cat();
  Cd cd = new Cd();
  FileExists f = new FileExists();
  Directory dir = new Directory();

  @Test
  public void testInvalidUrl() {
    // Tests for an invalid url
    input = "get invalidURl";
    g.execute(dir, input, null);
    exBool = false;
    actBool = f.getFileExists(dir, input);
    assertEquals(exBool, actBool); // Checks if file exists
  }

  @Test
  public void testValidUrl() {
    // Tests for an valid url
    input = "get https://raw.github.com/jmflee/t/master/s.txt";
    g.execute(dir, input, null);
    actBool = f.getFileExists(dir, "s.txt"); // Checks if file exists
    exBool = true;
    assertEquals(exBool, actBool);
    actual = c.getFileInfo(dir, "s.txt"); // Checks contents of files
    expected = "this is a test\n";
    assertEquals(expected, actual);
  }

  @Test
  public void testValidUrlDifferetDir() {
    // Tests for an valid url in a different directory
    m.execute(dir, "mkdir folder1", null); // Creates folder1
    cd.execute(dir, "cd folder1", null); // Changes cd to folder1
    input = "get https://raw.github.com/jmflee/t/master/s.txt";
    g.execute(dir, input, null);
    actBool = f.getFileExists(dir, "s.txt"); // Checks if file exists
    exBool = true;
    assertEquals(exBool, actBool);
    actual = c.getFileInfo(dir, "s.txt"); // Checks contents of files
    expected = "this is a test\n";
    assertEquals(expected, actual);
    cd.execute(dir, "cd ..", null);
    actBool = f.getFileExists(dir, "s.txt"); // Checks if file exists
    exBool = false;
    assertEquals(exBool, actBool);
  }
}
