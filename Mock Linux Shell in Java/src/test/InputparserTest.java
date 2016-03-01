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

import static org.junit.Assert.assertEquals;
import helpers.*;
import org.junit.Test;

public class InputparserTest {

  String input = ""; // First input
  boolean output ;
  boolean expected;
  
  @Test //Tests if input is valid
  public void validInput() {
    input = "mkdir League of Legends";
    expected = true;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
  @Test //Tests if input is invalid
  public void invalidInput() {
    // Cat a file in the home directory
    input = "I love League of Legends";
    expected = false;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
  @Test //Tests if input is invalid
  public void invalidInputWithCapitals() {
    // Cat a file in the home directory
    input = "MKDIR My IGN IS L1ttle Noob";
    expected = false;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
  @Test //Tests if input is invalid
  public void multipleCommandsTogether() {
    // multiple commands together
    input = "mkdir echo ls"; 
    expected = true;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
  @Test //Tests if input is invalid
  public void noSpacesInCommands() {
    // no spaces in the command
    input = "mkdirechos"; 
    expected = false;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
  @Test //Tests if input is invalid
  public void CommandsInMiddle() {
    // command in middle of invalid inputs
    input = "League mkdir Is Life"; 
    expected = false;
    output = InputParser.validate(input);
    assertEquals(expected, output); 
  }
  
}



  


