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

public class ExitTest {
  Exit exit;
  Stack a;
  Directory dir;



  @Test
  public void testIfExitWorks() {
    exit = new Exit();
    dir = new Directory();
    assertTrue(exit.checkString("exit"));

  }

  @Test
  public void testIfExitWorksWithWrongInput() {
    exit = new Exit();
    dir = new Directory();
    assertFalse(exit.checkString("wrong input"));
  }


}
