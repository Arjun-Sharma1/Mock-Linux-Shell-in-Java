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

import commands.Man;

public class ManTest {
  String expectedVal;
  String command;

  @Test
  public void testMkdirInput() {
    // Testing the man class when the input is mkdir
    expectedVal = "NAME:\n     -mkdir (make directory)\n\nDESCRIPTION:\n"
        + "     -Create directories, each of which may\n be relative to the "
        + "current directory or may\n be a full path.";
    command = "mkdir";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testExitInput() {
    // Testing the man class when the input is exit
    expectedVal =
        "NAME:\n     -exit \n\nDESCRIPTION:\n     -Quit the " + "program.";
    command = "exit";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testPwdInput() {
    // Testing the man class when the input is pwd
    expectedVal = "NAME:\n     -pwd (print working directory)"
        + "\n\nDESCRIPTION:\n     -Print the current working directory path";
    command = "pwd";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testPushdInput() {
    // Testing the man class when the input is pushd
    expectedVal = "NAME:\n     -pushd (push directory)\n\nDESCRIPTION:\n"
        + "     -Saves the current working directory by\n pushing onto the"
        + " directory stack and then\n changes the new current working"
        + " directory\n to DIR. The push must be consistent as per\n the LIFO"
        + " behavior of a stack. The pushd\n command saves the old current"
        + " working\n directory in directory of stack so that it\n can be "
        + "returned to at any time (via the\n popd command). The size of the"
        + " directory\n stack is dynamic and dependent on the pushd\n and popd"
        + " commands.";
    command = "pushd";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testPopdInput() {
    // Testing the man class when the input is popd
    expectedVal = "NAME:\n     -popd (pop directory)\n\nDESCRIPTION:\n"
        + "     -Remove the top"
        + " entry from the directory\n stack, and cd into it. The removal must "
        + "be\n consistent as per the LIFO behavior of a\n stack. The popd "
        + "command removes the top\n most directory from the directory stack "
        + "and\n makes it to the current working directory.\n If there is no "
        + "directory onto the stack,\n then give appropriate error message.";
    command = "popd";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testLsInput() {
    // Testing the man class when the input is ls
    expectedVal = "NAME:\n     -ls (list directory contents)\n\nDESCRIPTION"
        + ":\n     -If no paths are given, print the\n contents "
        + "(file or directory) of the current\n directory, with a new line "
        + "following each of\n the content (file or directory).";
    command = "ls";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testCatInput() {
    // Testing the man class when the input is cat
    expectedVal = "NAME:\n     -cat (concatenate and print files)\n\n"
        + "DESCRIPTION:\n     -Display the contents of FILE in the\n shell.";
    command = "cat";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testEchoInput() {
    // Testing the man class when the input is echo
    expectedVal = "NAME:\n     -echo \n\nDESCRIPTION:\n     -If OUTFILE is"
        + " not provided, print STRING\n on the shell. Otherwise, put STRING "
        + "into file\n OUTFILE. STRING is a string of characters\n surrounded "
        + "by double quotation marks.\n This creates a new file if OUTFILE does"
        + " not\n exists and erases the old contents if OUTFILE\n already "
        + "exists. In either case, the only\n thing in OUTFILE should be "
        + "STRING.";
    command = "echo";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testCdInput() {
    // Testing the man class when the input is cd
    expectedVal = "NAME:\n     -cd (change directory)\n\nDESCRIPTION:\n     "
        + "-Change directory to DIR, which may be\n relative to the current "
        + "directory or may be\n a full path. The directory "
        + "separator must\n be '/', the forward slash.";
    command = "cd";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testHistoryInput() {
    // Testing the man class when the input is history
    expectedVal = "NAME:\n     -history \n\nDESCRIPTION:\n     "
        + "-This command will print out recent\n commands, one command "
        + "per line.";
    command = "history";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

  @Test
  public void testManInput() {
    // Testing the man class when the input is man
    expectedVal = "NAME:\n     -man \n\nDESCRIPTION:\n     "
        + "-Print documentation for CMD";
    command = "man";
    // Test
    assertEquals(expectedVal, Man.checkString(command));
  }

}
