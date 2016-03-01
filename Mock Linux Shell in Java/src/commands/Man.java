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


package commands;

import java.util.Hashtable;
import java.util.Stack;

import helpers.Directory;


/**
 * Class Name: Man This class hold all the manuals for all the commands and
 * prints them upon.
 *
 * @return man.get(command), the corresponding manual for the given input
 */
public class Man implements CommandInterface {

  /**
   * Returns the  string correlated to the input.
   *
   * @param command the command given by the user
   * @return String, the string related to the given command
   */
  public static String checkString(String command) {
    Hashtable<String, String> man = new Hashtable<String, String>();

    String printMkdir = "NAME:\n     -mkdir (make directory)\n\nDESCRIPTION:\n"
        + "     -Create directories, each of which may\n be relative to the "
        + "current directory or may\n be a full path.";

    String printExit =
        "NAME:\n     -exit \n\nDESCRIPTION:\n     -Quit the " + "program.";

    String printPwd = "NAME:\n     -pwd (print working directory)"
        + "\n\nDESCRIPTION:\n     -Print the current working directory path";

    String printPushd = "NAME:\n     -pushd (push directory)\n\nDESCRIPTION:\n"
        + "     -Saves the current working directory by\n pushing onto the"
        + " directory stack and then\n changes the new current working"
        + " directory\n to DIR. The push must be consistent as per\n the LIFO"
        + " behavior of a stack. The pushd\n command saves the old current"
        + " working\n directory in directory of stack so that it\n can be "
        + "returned to at any time (via the\n popd command). The size of the"
        + " directory\n stack is dynamic and dependent on the pushd\n and popd"
        + " commands.";

    String printPopd = "NAME:\n     -popd (pop directory)\n\nDESCRIPTION:\n"
        + "     -Remove the top"
        + " entry from the directory\n stack, and cd into it. The removal must "
        + "be\n consistent as per the LIFO behavior of a\n stack. The popd "
        + "command removes the top\n most directory from the directory stack "
        + "and\n makes it to the current working directory.\n If there is no "
        + "directory onto the stack,\n then give appropriate error message.";

    String printLs = "NAME:\n     -ls (list directory contents)\n\nDESCRIPTION"
        + ":\n     -If no paths are given, print the\n contents "
        + "(file or directory) of the current\n directory, with a new line "
        + "following each of\n the content (file or directory). If -R is\n"
        + " present, recursively list all subdirectories.";

    String printCat = "NAME:\n     -cat (concatenate and print files)\n\n"
        + "DESCRIPTION:\n     -Display the contents of FILE in the\n shell.";

    String printEcho = "NAME:\n     -echo \n\nDESCRIPTION:\n     -If OUTFILE is"
        + " not provided, print STRING\n on the shell. Otherwise, put STRING "
        + "into file\n OUTFILE. STRING is a string of characters\n surrounded "
        + "by double quotation marks.\n This creates a new file if OUTFILE does"
        + " not\n exists and erases the old contents if OUTFILE\n already "
        + "exists. In either case, the only\n thing in OUTFILE should be "
        + "STRING.";

    String printCd = "NAME:\n     -cd (change directory)\n\nDESCRIPTION:\n     "
        + "-Change directory to DIR, which may be\n relative to the current "
        + "directory or may be\n a full path. The directory "
        + "separator must\n be '/', the forward slash.";

    String printHistory = "NAME:\n     -history \n\nDESCRIPTION:\n     "
        + "-This command will print out recent\n commands, one command "
        + "per line.";

    String printMan = "NAME:\n     -man \n\nDESCRIPTION:\n     "
        + "-Print documentation for CMD";
    
    String printGrep = "NAME:\n     -grep \n\nDESCRIPTION:\n     "
        + "-If –R is not supplied, print any lines\n containing "
        + "REGEX in PATH, which must be a\n file. If –R is supplied, and "
        + "PATH is a\n directory, recursively traverse the directory\n and,"
        + " for all lines in all files that contain\n REGEX, print the path"
        + " to the file (including\n the filename), then a colon, then the"
        + " line\n that contained REGEX";
    
    String printMv = "NAME:\n     -mv \n\nDESCRIPTION:\n     "
        + "-Move item OLDPATH to NEWPATH. Both\n OLDPATH and NEWPATH may"
        + " be relative to\n the current directory or may be full\n paths."
        + " If NEWPATH is a directory, move\n the item into the directory.";
    
    String printCp = "NAME:\n     -mv \n\nDESCRIPTION:\n     "
        + "-Copy item OLDPATH to NEWPATH. Both\n OLDPATH and NEWPATH may"
        + " be relative to\n the current directory or may be full\n paths."
        + " If NEWPATH is a directory, move\n the item into the directory."
        + "If OLDPATH\n is a directory, recursively copy the\n contents.";
    
    String printGet = "NAME:\n     -get \n\nDESCRIPTION:\n     "
        + "- Retrieve the file at that URL and\n add "
        + "it to the current working directory.";
    
    String printNumber = "NAME:\n     -!number \n\nDESCRIPTION:\n     "
        + "-This command will recall any of\n previous history by its"
        + " number(>=1)\n preceded by an exclamation point (!).\n For instance,"
        + " if your history looks like\n above, you could type the following"
        + " on\n the command line of your JShell";

    // All the names of the different functions are stored
    String[] collection = {"mkdir", "exit", "pwd", "pushd", "popd", "ls", "cat",
        "echo", "cd", "history", "man", "grep", "mv", "cp", "get", "!number"};

    // All the variable names where the manual for the function is stored
    String[] variables =
        {printMkdir, printExit, printPwd, printPushd, printPopd, printLs,
            printCat, printEcho, printCd, printHistory, printMan, printGrep,
            printMv, printCp, printGet, printNumber};

    // Adds all the string and variable combinations to the hashtable
    for (int index = 0; index < collection.length; index++) {
      man.put(collection[index], variables[index]);
    }

    if (man.get(command) != null) {

      return man.get(command);
    } else {
      return "Command not in manual";
    }

  }

  /**
   * Used by Jshell interface to execute the above methods.
   *
   * @param dir the dir
   * @param input the input
   * @param Holder the holder
   */
  public void execute(Directory dir, String input, Stack Holder) {
    input = input.trim().substring(3);
    if(input.trim().length()==0){
      System.out.println("Please Enter an argument after man.");
    }
    else{
    System.out.println(Man.checkString(input));
    }
  }
  
  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    Directory dir = new Directory();
    Man man = new Man();
    man.execute(dir, "man cat", null);
    man.execute(dir, "man !number", null);
  }
}
