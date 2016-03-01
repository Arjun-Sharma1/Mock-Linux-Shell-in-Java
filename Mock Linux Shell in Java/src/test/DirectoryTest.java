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
import helpers.*;
import org.junit.Test;
import commands.Cd;
import commands.Echo;
import commands.Mkdir;

public class DirectoryTest {
  Directory dir;
  Mkdir mkdir;
  Cd cd;
  Echo echo;

  @Before
  public void setUp(){
    dir = new Directory();
    mkdir = new Mkdir();
    cd = new Cd();
    echo = new Echo();
  }
  
  @Test // Checks current working directory
  public void testWorkingDirEmpty() {
    assertEquals("/", dir.workingDir());
  }
  
  @Test // Checks current working directory
  public void testWorkingDir() {
    mkdir.execute(dir, "mkdir Folder1", null);
    cd.execute(dir, "cd Folder1", null);
    assertEquals("Folder1", dir.workingDir());
  }
  
  @Test // Checks current working directory
  public void testWorkingDirWithMultipleSubFolders() {
    mkdir.execute(dir, 
        "mkdir Folder1 Folder1/Folder2 Folder1/Folder2/Folder3", null);
    cd.execute(dir, "cd Folder1/Folder2/Folder3", null);
    assertEquals("Folder3", dir.workingDir());
  }
  
  @Test // tests contents of current directory
  public void testGetContentsEmpty() {
    assertEquals("", dir.getContents());
  }
  
  @Test // Checks current working directory
  public void testGetContentsWithOneFolder() {
    mkdir.execute(dir, "mkdir Folder1", null);
    assertEquals(" Folder1", dir.getContents());
  }
  
  @Test // Checks current working directory
  public void testGetContentsWithMultipleFolders() {
    mkdir.execute(dir, "mkdir Folder1 Fodler2 Folder3 Folder4", null);
    assertEquals(" Folder1 Fodler2 Folder3 Folder4", dir.getContents());
  }
  
  @Test // 
  public void testCheckDirEmpty(){
    assertEquals(false, dir.checkDir("any directory"));
  }
  
  @Test // 
  public void testHasChildrenWithoutChildren(){
    assertEquals(false, dir.hasChildren());
  }

  @Test // 
  public void testHasChildrenWithChild(){
    mkdir.execute(dir, "mkdir Folder1", null);
    assertEquals(true, dir.hasChildren());
  }
  
  @Test // 
  public void testHasChildrenWithChildren(){
    mkdir.execute(dir, "mkdir Folder1 Folder2 Folder3 Folder4", null);
    assertEquals(true, dir.hasChildren());
  }
  
  @Test // 
  public void testHasChildrenWhenFile(){
    echo.execute(dir, "echo \"test\" > test.txt", null);
    assertEquals(true, dir.hasChildren());
  }
}
