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

public class FileExistsTest {
  String input = ""; // First input
  Directory dir = new Directory();
  Echo e = new Echo();
  Mkdir m = new Mkdir();
  Cd c = new Cd();
  Stack<String> holder = new Stack<String>();
  FileExists exists = new FileExists();
  boolean output;
  boolean expected;
  
  @Test
  public void testExistsRoot() {
    // Tests if the file exists at the root
    input = "echo \"Hello world\" > file"; 
    e.execute(dir, input, null); //Creates file in root
    output = exists.getFileExists(dir, "file"); // Looks for file
    expected = true; // Should be true
    assertEquals(expected, output);
  }
  
  @Test
  public void testNotExistsRoot() {
    // Tests if the file exists at the root
    input = "echo \"Hello world\" > file";
    e.execute(dir, input, null); //Creates file in root
    output = exists.getFileExists(dir, "notFile");  // Looks for notFile
    expected = false; // Should be true
    assertEquals(expected, output);
  }
  
  @Test
  public void testExistsNewPath() {
    // Tests if the file exists at a different path
    input = "mkdir folder1";
    m.execute(dir, input, null); // Makes the folder folder1
    c.execute(dir, "cd folder1", null); // Switches to folder1
    input = "echo \"hello world\" > file";
    e.execute(dir, input, null); //Creates file in folder1
    output = exists.getFileExists(dir, "file"); //Looks for file
    expected = true; // Should be true
    assertEquals(expected, output);
  }
  
  @Test
  public void testNotExistsNewPath() {
    // Tests if the file doesn't exists at a different path
    input = "mkdir folder1";
    m.execute(dir, input, null); //Makes folder folder1 
    c.execute(dir, "cd folder1", null); // Switches to folder 1
    input = "echo \"hello world\" > notFile";
    e.execute(dir, input, null); // Creates files in folder1
    output = exists.getFileExists(dir, "file");  // Looks for file
    expected = false; // Should be false
    assertEquals(expected, output);
  }
  
  @Test
  public void testFileNotSamePath() {
    // Tests accessing a file of different path but the file doesn't exists
    // in the current path 
    input = "echo \"hello world\" > file"; 
    e.execute(dir, input, null);//Creates file in root
    input = "mkdir folder1";
    m.execute(dir, input, null); //Makes folder folder1
    c.execute(dir, "cd folder1", null); //Navigate to folder1
    output = exists.getFileExists(dir, "file"); //Looks for file
    expected = false; // Should be false because file is in root not folder1
    assertEquals(expected, output);
  }
}