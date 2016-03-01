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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Stack;

/**
 * The Class Reflection.
 */
public class Reflection {
  
  /**
   * Turns a user input into a Class object and executes the execute method
   *
   * @param dir the dir
   * @param input the input from the user
   * @param holder the holder
   */
  public static void execute(Directory dir, String input, Stack holder) {
    String command[] = input.trim().split("\\s+");
    // Checks if the command is valid
    String userInput = "commands." + command[0].substring(0, 1).toUpperCase()
        + command[0].substring(1);
    try {
      Class<?> classCommand = Class.forName(userInput);
      Object obj = classCommand.newInstance();
      classCommand.getClass();
      Method method = classCommand.getDeclaredMethod("execute", dir.getClass(),
          userInput.getClass(), holder.getClass());
      method.invoke(obj, dir, input, holder);
    } catch (InstantiationException | IllegalAccessException
        | ClassNotFoundException | IllegalArgumentException
        | InvocationTargetException | NoSuchMethodException
        | SecurityException e) {
      e.printStackTrace();
    }
  }
}
