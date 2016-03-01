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

import helpers.File;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Class Name: Tree Operates a tree with nodes holds children parents and items
 * of nodes.
 *
 * @param <T> the generic type
 */
public class Tree<T> {
  
  /** The children. */
  private List<Tree<T>> children = new ArrayList<Tree<T>>();
  
  /** The parent. */
  private Tree<T> parent = null;
  
  /** The items. */
  private T items = null;

  /**
   * Instantiates a new tree.
   *
   * @param data the data
   */
  public Tree(T data) {
    // constructor for the tree with one input
    this.items = data;
  }

  /**
   * Instantiates a new tree.
   *
   * @param item the item
   * @param parent the parent
   */
  public Tree(T item, Tree<T> parent) {
    // constructor for the tree object with two inputs
    this.items = item;
    this.parent = parent;
  }

  /**
   * Gets the children.
   *
   * @return the children
   */
  public String getChildren() {
    String names = "";
    for (int i = 0; i < children.size(); i++) {
      names = names + " " + children.get(i).getItems();
    }
    return names;
  }

  /**
   * Gets the raw children.
   *
   * @return the raw children
   */
  public List<Tree<T>> getRawChildren() {
    // Returns an ArrayList of children
    return children;
  }

  /**
   * Sets the parent.
   *
   * @param parent the new parent
   */
  public void setParent(Tree<T> parent) {
    // Adds a new tree to the tree as a parent
    this.parent = parent;
  }

  /**
   * Gets the parent.
   *
   * @return the parent
   */
  public Tree getParent() {
    // Returns the parent of tree
    return parent;
  }

  /**
   * Adds the child.
   *
   * @param data the data
   */
  public void addChild(T data) {
    // Adds a child to the current tree object
    // Creates a tree object with "data"
    Tree<T> child = new Tree<T>(data);
    // Sets parent of "child" to current tree
    child.setParent(this);
    // Adds "child" as child for tree
    this.children.add(child);
  }

  /**
   * Adds the child.
   *
   * @param child the child
   */
  public void addChild(Tree<T> child) {
    // Adds the "child" tree object to the current tree
    child.setParent(this);
    // Sets the child of current object to "child"
    this.children.add(child);
  }

  /**
   * Gets the items.
   *
   * @return the items
   */
  public String getItems() {
    if (this.items instanceof File) {
      return ((File) this.items).getFileName();
    } else {
      return (String) this.items;
    }
  }

  /**
   * Gets the raw items.
   *
   * @return the raw items
   */
  public T getRawItems() {
    return this.items;
  }

  /**
   * Sets the items.
   *
   * @param data the new items
   */
  public void setItems(T data) {
    this.items = data;
  }

  /**
   * Checks if is root.
   *
   * @return true, if is root
   */
  public boolean isRoot() {
    return (this.parent == null);
  }

  /**
   * Checks if is leaf.
   *
   * @return true, if is leaf
   */
  public boolean isLeaf() {
    if (this.children.size() == 0)
      return true;
    else
      return false;
  }

  /**
   * Removes the parent.
   */
  public void removeParent() {
    this.parent = null;
  }
}

