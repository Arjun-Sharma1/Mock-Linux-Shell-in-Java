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

import helpers.FormatMe;

public class FormatMeTest {
  String input = "";
  boolean output;
  boolean expected;
  String [] out;
  helpers.FormatMe test = new helpers.FormatMe();
  @Test
  public void singleIllegal() {
    // Checks for a single illegal character
    input = "$ajdhsajhdjk";
    output = FormatMe.testDirString(input);
    expected = false;
    assertEquals(expected, output);
  }
  
  @Test
  public void multiIllegal() {
    // Checks for multiple illegal characters
    input = "$aj#dhsa/jhdjk";
    output = FormatMe.testDirString(input);
    expected = false;
    assertEquals(expected, output);
  }
  
  @Test
  public void pass() {
    // Checks for multiple illegal characters
    input = "ajdhsajhdjk";
    output = FormatMe.testDirString(input);
    expected = true;
    assertEquals(expected, output);
  }
  
  @Test
  public void cutSingleDir() {
    // Checks for single split paths
    input = "mkdir one/two/three";
    out = FormatMe.cutDirMkdir(input);
    String [] ex = {"one/two/three"};
    assertArrayEquals(ex, out);
  }
  
  @Test
  public void cutTwoDir() {
    // Checks for two split paths
    input = "mkdir one/two/three 1/2/3";
    out = FormatMe.cutDirMkdir(input);
    String [] ex = {"one/two/three", "1/2/3"};
    assertArrayEquals(ex, out);
  }
  
  @Test
  public void cutInvalid() {
    // Checks for paths with invalid characters
    input = "mkdir one/two/th>/ree 1/2/3";
    out = FormatMe.cutDirMkdir(input);
    String [] ex = {null};
    assertArrayEquals(ex, out);
  }
  
}
