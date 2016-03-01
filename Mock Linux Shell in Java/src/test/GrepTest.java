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
import org.junit.Before;
import org.junit.Test;
import commands.Cd;
import commands.Echo;
import commands.Grep;
import commands.Mkdir;
import helpers.Directory;

public class GrepTest {
  Directory dir;
  Mkdir mkdir;
  Cd cd;
  Grep grep;
  Echo echo;
  String expected;
  String actual;
  
  @Before
  public void setUp(){
    dir = new Directory();
    mkdir = new Mkdir();
    cd = new Cd();
    grep = new Grep();
    echo = new Echo();
    expected = "";
    actual = "";
  }
  @Test
  public void testCorrectSingleLine () {
    echo.execute(dir,
        "echo " + "\"hello\"" + " > test.txt", null);
    expected = "/test.txt:\nhello";
    actual = grep.findRegex(dir, "hello test.txt");
    assertEquals(expected, actual);
  }
  @Test
  public void testCorrectMultipleLine() {
    echo.execute(dir,
        "echo " + "\"hello\nhello\"" + " > test.txt", null);
    expected = "/test.txt:\nhello\nhello";
    actual = grep.findRegex(dir, "hello test.txt");
    assertEquals(expected, actual);
  }
  @Test
  public void testCorrectMultipleLineMultipleRegex() {
    echo.execute(dir,
        "echo " + "\"hellotanayhello\nhello\"" + " > test.txt", null);
    expected = "/test.txt:\nhellotanayhello\nhellotanayhello\nhello";
    actual = grep.findRegex(dir, "hello test.txt");
    assertEquals(expected, actual);
  }
  
}
