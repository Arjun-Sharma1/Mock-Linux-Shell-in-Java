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
import commands.*;
import helpers.Directory;

public class CatTest {

  String input;
  Directory dir;
  Echo echo;
  Mkdir mkdir;
  Cd cd;
  String output;
  String expected;

  @Before
  public void setUp(){
    dir = new Directory();
    echo = new Echo();
    mkdir = new Mkdir();
    cd = new Cd();
    input = "";
    output = "";
    expected = "";
  }
  
  @Test
  public void testFile() {
    // Cat a file in the home directory
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    expected = "file";
    output = Cat.getFileInfo(dir, "fileName");
    assertEquals(expected, output);
  }

  @Test
  public void testCatNewDir() {
    // Cat a file in a different folder
    input = "echo \"file\" > home";
    echo.execute(dir, input, null);
    expected = "file";
    output = Cat.getFileInfo(dir, "home");
    assertEquals(expected, output);
  }
  @Test
  public void testCatNewDir2() {
    input = "newfile";
    echo.execute(dir, input, null);
    cd.switchDir(dir, input);
    input = "echo \"file\" > fileName";
    echo.execute(dir, input, null);
    output = Cat.getFileInfo(dir, "fileName");
    expected = "file";
    assertEquals(expected, output);
  }

  @Test
  public void testError() {
    // Cat a file in the home directory
    expected = "cat: fileName: No such file or directory";
    output = Cat.getFileInfo(dir, "fileName");
    assertEquals(expected, output);
  }
}

