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
import helpers.Directory;
import helpers.Tree;

import java.util.Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import commands.Popd;
import commands.Pushd;

public class PopdTest {
  Directory explorer = new Directory();
  Tree a = new Tree("FOLDER1");
  Pushd push = new Pushd();
  Tree b = new Tree("FOLDER2");
  Popd pop = new Popd();

  @Test
  public void creation() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(a, b);// so /root/folder2/folder1 workingDir = root
    push.getStack().push("/FOLDER2"); // format here has to be same as if
                                      // pwd.printDir() returns
    pop.execute(explorer, null, null);// goes into folder2
    // working directory should be folder2
    assertEquals("FOLDER2", explorer.workingDir());
    // stack should contain nothing
    assertEquals(2, push.getStack().size());
  }

  // test switching more then once
  @Test
  public void switchMultipleTimes() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(a, b);// so /root/folder2/folder1 workingDir = root
    push.getStack().push("/FOLDER2"); // format here has to be same as if
                                      // pwd.printDir() returns
    push.getStack().push("/FOLDER3"); // format here has to be same as if
                                      // pwd.printDir() returns
    pop.execute(explorer, null, null);// goes into folder2
    // working directory should be folder2
    assertEquals("/", explorer.workingDir());
    // stack should contain nothing
    assertEquals(1, Pushd.getStack().size());
  }
  
  @Test
  public void emptyStack() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(a, b);// so /root/folder2/folder1 workingDir = root
    pop.execute(explorer, null, null);// goes into folder2
    // working directory should be folder2
    assertEquals("FOLDER2", explorer.workingDir());
    // stack should contain nothing
    assertEquals(0, Pushd.getStack().size());
  }
  
  @Test
  public void multipleItemsInPopd() {
    explorer.insertMe(b, explorer.rawWorkingDir());// put b in root
    explorer.insertMe(a, b);// so /root/folder2/folder1 workingDir = root
    push.getStack().push("/FOLDER2"); // format here has to be same as if
    // pwd.printDir() returns
    push.getStack().push("/FOLDER3"); // format here has to be same as if
    // pwd.printDir() returns
    push.getStack().push("/FOLDER4"); // format here has to be same as if
    // pwd.printDir() returns
    pop.execute(explorer, null, null);// goes into folder2
    // working directory should be folder2
    assertEquals("/", explorer.workingDir());
    // stack should contain nothing
    assertEquals(2, Pushd.getStack().size());
  }



}
