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

import java.util.Stack;

import org.junit.Test;

import commands.Cd;
import commands.Mkdir;

public class MkdirTest {

  Directory dir = new Directory();
  Mkdir mkdir = new Mkdir();

  @Test
  public void testCreatingDirectory() {
    mkdir.execute(dir, "mkdir /Folder1", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals(" Folder1", dir.rawWorkingDir().getChildren()); // checking
                                                                 // children
  }

  @Test
  public void testCreatingCreatingMultipleDirectories() {
    mkdir.execute(dir,
        "mkdir Folder1 Folder1/Folder2 Folder1/Folder2/" + "Folder3", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals(" Folder1", dir.rawWorkingDir().getChildren());
    // checking children
  }

  @Test // Tests for invalid characters in the name
  public void testCreatingInvalidCharacters() {
    mkdir.execute(dir,
        "mkdir /Foas.%$#$%lder1 Folder1 Folder1/Folder2/" + "Folde$r3", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals("", dir.rawWorkingDir().getChildren());
  }

  @Test // Tests if path exists or not
  public void testPathDoesntExist() {
    mkdir.execute(dir, "mkdir /Folder1/Folder2/Hi", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals("", dir.rawWorkingDir().getChildren());
  }

  @Test // Tests if multiple paths at once are made
  public void MultiplePathsAtOnce() {
    mkdir.execute(dir, "mkdir Folder1 /Folder1/Folder2/Hi", null);
    Cd.switchDir(dir, "Folder1");
    assertEquals("Folder1", dir.workingDir()); // make sure no switch was made
    assertEquals("", dir.rawWorkingDir().getChildren());
  }

  @Test // Tests if directory can be made after using ..
  public void testCreationOfFolderUsingDotDot() {
    mkdir.execute(dir, "mkdir Folder1", null);
    Cd.switchDir(dir, "Folder1");
    mkdir.execute(dir, "mkdir ../HelloWorld", null);
    assertEquals("Folder1", dir.workingDir()); // make sure no switch was made
    assertEquals("", dir.rawWorkingDir().getChildren());
  }

  @Test // Tests if directory of already existing name can be made
  public void testFolderWithExistingName() {
    mkdir.execute(dir, "mkdir Folder1 Folder1", null);
    mkdir.execute(dir, "mkdir Folder1", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals(" Folder1", dir.rawWorkingDir().getChildren());
  }

  @Test // Tests if directory with 1 letter can be made
  public void testOneLetterFolders() {
    mkdir.execute(dir, "mkdir B", null);
    assertEquals("/", dir.workingDir()); // make sure no switch was made
    assertEquals(" B", dir.rawWorkingDir().getChildren());
  }


}
