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

import commands.*;
import static org.junit.Assert.*;
import java.util.Stack;
import org.junit.Test;
import helpers.Directory;

public class PwdTest {
  String expectedVal;
  Directory dir;
  Mkdir m;
  Stack a;


  @Test
  public void testWhenDirectorycetoryIsAtRoot() {
    // tests when the current directory is at root
    dir = new Directory();
    // m = new Mkdir();
    expectedVal = "/";
    assertEquals(expectedVal, Pwd.printDir(dir));
  }


  @Test
  public void testWhenDirectorycetoryAtTheEndOfTree() {
    // tests if the pwd command works when the current directory is
    // at the very end of the tree
    dir = new Directory();
    m = new Mkdir();
    a = new Stack();
    // Populating the tree
    m.execute(dir, "mkdir folder1", a);
    Cd.switchDir(dir, "/folder1");
    m.execute(dir, "mkdir folder2", a);
    Cd.switchDir(dir, "/folder2");
    m.execute(dir, "mkdir folder3", a);
    Cd.switchDir(dir, "/folder3");
    // Testing the pwd class
    expectedVal = "/folder1/folder2/folder3";
    assertEquals(expectedVal, Pwd.printDir(dir));

  }

  @Test
  public void testWhenDirectoryectoryIsInTheMiddleOfTree() {
    // test if the pwd command works when the current directory is
    // anywhere between the root and the last child of the tree
    dir = new Directory();
    m = new Mkdir();
    a = new Stack();
    // Populating the tree
    m.execute(dir, "mkdir folder1", a);
    Cd.switchDir(dir, "/folder1");
    m.execute(dir, "mkdir folder2", a);
    Cd.switchDir(dir, "/folder2");
    m.execute(dir, "mkdir folder3", a);
    Cd.switchDir(dir, "/folder3");
    m.execute(dir, "mkdir folder4", a);
    Cd.switchDir(dir, "/folder4");
    m.execute(dir, "mkdir folder5", a);
    Cd.switchDir(dir, "/folder5");
    // Making the current directory somewhere in the middle of the tree
    Cd.switchDir(dir, "/..");
    Cd.switchDir(dir, "/..");
    Cd.switchDir(dir, "/..");
    // Testing the pwd class
    expectedVal = "/folder1/folder2";
    assertEquals(expectedVal, Pwd.printDir(dir));
  }

}
