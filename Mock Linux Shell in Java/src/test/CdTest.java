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

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;
import commands.*;
import helpers.*;
import static org.junit.Assert.*;

public class CdTest {
  Directory dir;
  Mkdir mkDir;
  Cd cd;

  @Before
  public void setUp() {
    dir = new Directory();
    mkDir = new Mkdir();
    cd = new Cd();
  }

  @Test
  public void testChanginDirectoryFromRoot() {
    // Test changing the directory from the root directory
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /Folder1", null);
    assertEquals("Folder1", dir.workingDir());
  }

  @Test
  public void testInputWithoutSlash() {
    // Test if the method accepts with the "/"
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd Folder1", null);
    assertEquals("Folder1", dir.workingDir());
  }

  @Test
  public void testInputWithSlash() {
    // Test if accepts with the "/"
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /Folder1", null);
    assertEquals("Folder1", dir.workingDir());
  }

  @Test
  public void testChangeDirToPath() {
    // Test if cd accepts a full path
    mkDir.execute(dir,
        "mkdir /Folder1 /Folder1/Folder2 /Folder1/Folder" + "2/Folder3", null);
    cd.execute(dir, "cd Folder1/Folder2/Folder3", null);
    assertEquals("Folder3", dir.workingDir());
  }

  @Test
  public void testGoingUpAndDownATree() {
    // Test if cd can go up and down a directory
    mkDir.execute(dir,
        "mkdir /Folder1 /Folder1/Folder2 /Folder1/Folder2/Folder3", null);
    cd.execute(dir, "cd Folder1/Folder2/Folder3", null);
    cd.execute(dir, "cd ..", null);
    assertEquals("Folder2", dir.workingDir());
  }

  @Test
  public void testGoingToRoot() {
    // Test going to root (cd /) as input
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testGoingUpWhileInRoot() {
    // Test trying to go up from root
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /..", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testChangeDirToNonExistentDir() {
    // Test trying to go up from root
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd Folder2", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testUsingDotDotWithFilePath() {
    // Test if cd can go up and down a directory using a single path
    mkDir.execute(dir,
        "mkdir /Folder1 /Folder1/Folder2 /Folder1/Folder" + "2/Folder3", null);
    cd.execute(dir, "cd Folder1/Folder2/Folder3/..", null);
    assertEquals("Folder2", dir.workingDir());
  }

  @Test
  public void testWithIncorrectFilePath() {
    // Test full path where some folder does not exist
    mkDir.execute(dir,
        "mkdir /Folder1 /Folder1/Folder2 /Folder1/Folder2/Folder3", null);
    cd.execute(dir, "cd /Folder1/Folder3", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testChangeDirToRootContinually() {
    // Test trying to go up from root
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /////////////", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testNonsensicalInput() {
    // Test weird characters as input
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd @$^#$@#^#%&$ro69ky8ornr5h3", null);
    assertEquals("/", dir.workingDir());
  }

  @Test
  public void testGoUpDirContinually() {
    // Test trying to go up from root
    mkDir.execute(dir, "mkdir /Folder1", null);
    cd.execute(dir, "cd /......................", null);
    assertEquals("/", dir.workingDir());
  }

}
