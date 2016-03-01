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

import helpers.Directory;
import helpers.File;
import helpers.Tree;

import org.junit.Test;

import commands.Number;
import commands.Cd;
import commands.Cp;
import commands.Ls;
import commands.Mkdir;
import commands.Mv;

  
public class TestNumber {
  Mkdir mkdir;
  Directory dir;
  Cd cd;
  Cp cp;
  Ls ls;
  Mv mv;
  Number number;
  
  @Before
  public void setUp() {
    mkdir = new Mkdir();
    dir = new Directory();
    cd = new Cd();
    cp = new Cp();
    ls = new Ls();
    mv = new Mv();
    number = new Number();
  }
  
  @Test
  public void testEmptyHistory() {
    Stack history = new Stack();
    String test = number.recallCommand(dir, "3", history);
    assertEquals("Error out of bounds", test);
  }
  
  @Test
  public void testOutOfBoundsHistory() {
    Stack history = new Stack();
    history.push("ONE");
    String test = number.recallCommand(dir, "3", history);
    assertEquals("Error out of bounds", test);
  }
  
  @Test
  public void testWrongCommandHistory() {
    Stack history = new Stack();
    history.push("WRONG");
    history.push("WRONG");
    history.push("WRONG");
    String test = number.recallCommand(dir, "3", history);
    assertEquals("Invalid input! Please try again", test);
  }
  @Test
  public void testFunctionCallHistory() {
    Stack history = new Stack();
    history.push("WRONG");
    history.push("WRONG");
    history.push("mkdir this");
    String test = number.recallCommand(dir, "3", history);
    String test2 = ls.listDir(dir,"" );
    assertEquals("/: this\n", test2);
    assertEquals("", test);
  }
}
