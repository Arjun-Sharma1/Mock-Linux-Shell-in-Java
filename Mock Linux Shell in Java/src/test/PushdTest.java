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

import helpers.*;
import commands.*;

import org.junit.Test;

public class PushdTest {
  Directory explorer = new Directory();
  Tree a = new Tree("FOLDER1");
  Pushd testVar = new Pushd();
  Tree b = new Tree("FOLDER2");

  @Test
  public void invalidInput() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(b, a);// put a in b
    testVar.execute(explorer, "pushd FOLDER6", null);// make it go in folder2\
    assertEquals("/", explorer.workingDir());
  }
  
  @Test
  public void invalidChar() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(b, a);// put a in b
    testVar.execute(explorer, "pushd FOLDER%4//2", null);// make it go in folder2
    assertEquals("/", explorer.workingDir());
  }

  @Test
  public void goToPreviousDirectory() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(b, a);// put a in b
    testVar.execute(explorer, "pushd FOLDER2", null);// make it go in folder2
    // working directory should be folder2
    assertEquals("FOLDER2", explorer.workingDir());
    // stack should contain one directory
    assertEquals(1, testVar.getStack().size());
    // root should be in the stack
    assertEquals("/", testVar.getStack().peek());
  }

  // test / as input

}
