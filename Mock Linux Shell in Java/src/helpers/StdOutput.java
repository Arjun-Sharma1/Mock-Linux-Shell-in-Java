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

package helpers;

import java.util.List;
import java.util.Stack;
import commands.Cat;
import commands.Echo;
import commands.Grep;
import commands.History;
import commands.Ls;
import commands.Man;
import commands.Pushd;
import commands.Pwd;

/**
 * The Class StdOutput.
 * Creates a file for the commands output
 */
public class StdOutput {
  
  /**
   * Std output. Stores the output of commands in a test file
   *
   * @param dir the directory the function works off of
   * @param input the input string
   * @param Holder the holder stack
   */
  public static void stdOutput(Directory dir, String input, Stack Holder) {
    String argument[] = input.trim().split(" ");
    String content = "";
    Echo echo = new Echo();
    String redirection = "";
    if(input.contains(">")){
      redirection = " > ";
    }
    else if(input.contains(">>")){
      redirection = " >> ";
    }
    if (InputParser.validate(argument[0])) {
      if (argument[0].equals("ls")) {
        input = formatInput(input).substring(2).trim();
        if (argument[1].equals("-r") || argument[1].equals("-R")) {
          input = input.substring(2).trim();
          content = Ls.recursivelyListAllDir(dir);
          echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
              + argument[argument.length - 1], null);
        } else {
          content = Ls.listDir(dir, input);
          echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
              + argument[argument.length - 1], null);
        }
      } else if (argument[0].equals("man")) {
        content = Man.checkString(argument[1]);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("cat")) {
        input = formatInput(input).substring(3).trim();
        content = Cat.getFileInfo(dir, input);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("cp")) {
        input = formatInput(input).substring(2).trim();
        content = "";
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("grep")) {
        input = formatInput(input).substring(4).trim();
        content = Grep.findRegex(dir, input);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("history")) {
        content = History.showStack(Holder);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("popd")) {
        content = History.showStack(Holder);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("pushd")) {
        input = formatInput(input).substring(5).trim();
        content = Pushd.pushd(dir, input);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      } else if (argument[0].equals("pwd")) {
        input = formatInput(input).substring(3).trim();
        content = Pwd.printDir(dir);
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      }
      else if (argument[0].equals("mkdir")) {
        content = "";
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      }
      else if (argument[0].equals("cd")) {
        content = "";
        echo.execute(dir, "echo " + "\"" + content + "\"" + redirection
            + argument[argument.length - 1], null);
      }
    }
  }
  

  /**
   * Format input.
   *
   * @param input1 the input1 
   * @return the string
   */
  private static String formatInput(String input1) {
    String commands[] = input1.trim().split(" ");
    int i = 0;
    String finalOutput = "";
    while (!commands[i].equals(">>") && !commands[i].equals(">")) {
      finalOutput += commands[i] + " ";
      i++;
    }
    return finalOutput;

  }
}
