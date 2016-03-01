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

import org.junit.Test;
import helpers.File;

public class FileTest {
  File file;
  String name;
  String content;
  

  @Test
  public void testGetName() {
    name = "TestFile";
    content = "this is file content, this is arbitrary";
    file = new File(name, content);
    assertEquals(name, file.getFileName());  
    
  }
  
  @Test
  public void testSetName() {
    name = "TestFile";
    content = "this is file content, this is arbitrary";
    file = new File(name, content);
    file.setFileName("NewName");
    assertEquals("NewName", file.getFileName());
    
    
  }
  
  @Test
  public void testSetContent() {
    name = "TestFile";
    content = "this is file content, this is arbitrary";
    file = new File(name, content);
    file.setContent("New content");
    assertEquals("New content", file.getContent());
    
  }
  
  @Test
  public void testGetContent() {
    name = "TestFile";
    content = "this is file content, this is arbitrary";
    file = new File(name, content);
    assertEquals(content, file.getContent());
    
  }
  

}
