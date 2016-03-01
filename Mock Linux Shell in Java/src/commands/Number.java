package commands;

import java.util.Stack;

import helpers.Directory;
import helpers.Reflection;

// TODO: Auto-generated Javadoc
/**
 * The Class Number is used to recall previous commands.
 */
public class Number implements CommandInterface {
  
  /**
   * Recall previous command that has has been stored in History and invokes it
   *
   * @param dir the dir
   * @param input the input
   * @param history the history
   * @return the string
   */
  public static String recallCommand(Directory dir, String input,
      Stack history) {
    int commandNumber = Integer.parseInt(input);
    Stack holder = history;
    if (!(commandNumber >= history.size()) && !(commandNumber <= 0)) {
      Stack itemHolder = new Stack();
      // Places items from history stack into a holder stack
      while (history.size() != commandNumber) {
        itemHolder.push(history.pop());
      }
      String topStack = (String) history.peek(); // Item on top of the stack
      if (helpers.InputParser.validate(topStack)) { // checks if item is valid
        Reflection.execute(dir, topStack, holder);
      } else if (topStack.startsWith("!")) {
        input = "Number " + input;
        helpers.Reflection.execute(dir, input, holder);
      } else {
        for (int command = 0; command < itemHolder.size(); command++) {
          history.push(itemHolder.pop());
        }
        return "Invalid input! Please try again";
      }
      // Puts everything back into the history stack
      for (int command = 0; command < itemHolder.size(); command++) {
        history.push(itemHolder.pop());
      }
      return "";
    } else {
      return "Error out of bounds";
    }
  }
  
  /**
   * Used by Jshell interface to execute the above methods
   * 
   */
  public void execute(Directory dir, String input, Stack holder) {
    input = input.replaceAll("\\D+", "");
    System.out.println(recallCommand(dir, input, holder));
  }
}
