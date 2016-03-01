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

public class SplitPathsTest {
  String input = ""; // First input
  String[] actual = new String[2]; // Actual output
  String[] expected = new String[2]; // Expected output
  SplitPaths s = new SplitPaths();

  @Test
  public void testSplitFull() {
    // Tests a split full path
    input = "/file1/file2/file3/file4/text.txt"; 
    expected[0] = "/file1/file2/file3/file4/";
    expected[1] = "text.txt";
    actual = s.pathSplit(input);
    assertEquals(expected[0], actual[0]);
    assertEquals(expected[1], actual[1]);
  }
  
  @Test
  public void testSplitPartial() {
    // Tests a split partial path
    input = "file1/file2/file3/file4/text.txt"; 
    expected[0] = "file1/file2/file3/file4/";
    expected[1] = "text.txt";
    actual = s.pathSplit(input);
    assertEquals(expected[0], actual[0]);
    assertEquals(expected[1], actual[1]);
  }
  
  @Test
  public void testSplitRoot() {
    // Tests a split root
    input = "/text.txt"; 
    expected[0] = "/";
    expected[1] = "text.txt";
    actual = s.pathSplit(input);
    assertEquals(expected[0], actual[0]);
    assertEquals(expected[1], actual[1]);
  }
  
  @Test
  public void testSplitNoPath() {
    // Tests a split with no path
    input = "text.txt"; 
    expected[0] = "";
    expected[1] = "text.txt";
    actual = s.pathSplit(input);
    assertEquals(expected[0], actual[0]);
    assertEquals(expected[1], actual[1]);
  }
}
