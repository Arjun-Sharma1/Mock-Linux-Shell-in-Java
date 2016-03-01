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
import helpers.File;
import helpers.Tree;

import org.junit.Test;

import commands.Cd;
import commands.Cp;
import commands.Ls;
import commands.Mkdir;
import commands.Mv;

public class MvTest {
  Mkdir mkdir = new Mkdir();
  Directory dir = new Directory();
  Cd cd = new Cd();
  Cp cp = new Cp();
  Ls ls = new Ls();
  Mv mv = new Mv();
  
  @Test 
  public void testOneMove() {
    mkdir.execute(dir, "mkdir this that", null);
    mv.execute(dir, "mv this that", null);
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "that");
    assertEquals("/: that\n", dirs);
    assertEquals("that: this\n", dirs2);
  }
  @Test 
  public void testMultipleMove() {
    mkdir.execute(dir, "mkdir this this/one this/one/two that", null);
    mv.execute(dir, "mv this that", null);
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "that");
    String dirs3 = ls.listDir(dir, "that/this");
    String dirs4 = ls.listDir(dir, "that/this/one");
    assertEquals("/: that\n", dirs);
    assertEquals("that: this\n", dirs2);
    assertEquals("that/this: one\n", dirs3);
    assertEquals("that/this/one: two\n", dirs4);
  }
  
  @Test 
  public void testWrongFirstMove() {
    mkdir.execute(dir, "mkdir this this/one this/one/two that", null);
    mv.execute(dir, "mv Wrong that", null);
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "that");
    assertEquals("/: this that\n", dirs);
    assertEquals("that:\n", dirs2);
    
  }
  @Test
  public void testWrongSecondMove() {
    mkdir.execute(dir, "mkdir this this/one this/one/two that", null);
    mv.execute(dir, "mv this WRONG", null);
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "that");
    assertEquals("/: this that\n", dirs);
    assertEquals("that:\n", dirs2);
    
  }
  
  @Test
  public void testFileMove() {
    mkdir.execute(dir, "mkdir this that", null);
    File demo =  new File("NAME","CONTENT");
    Tree demoCont = new Tree(demo);
    dir.insertMe(demoCont, dir.rawWorkingDir());
    mv.execute(dir, "mv NAME this", null);
    
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "this");
    assertEquals("/: this that\n", dirs);
    assertEquals("this: NAME\n", dirs2);
  
  }
  
  @Test
  public void testFileAndFolderMove() {
    mkdir.execute(dir, "mkdir this this/one this/one/two that", null);
    File demo =  new File("NAME","CONTENT");
    Tree demoCont = new Tree(demo);
    cd.execute(dir, "cd this/one", null);
    dir.insertMe(demoCont, dir.rawWorkingDir());
    cd.execute(dir, "cd ../..", null);
    mv.execute(dir, "mv this that", null);
    
    String dirs = ls.listDir(dir, "");
    String dirs2 = ls.listDir(dir, "that");
    String dirs3 = ls.listDir(dir, "that/this/one");
    assertEquals("/: that\n", dirs);
    assertEquals("that: this\n", dirs2);
    assertEquals("that/this/one: two NAME\n", dirs3);
  }
}
