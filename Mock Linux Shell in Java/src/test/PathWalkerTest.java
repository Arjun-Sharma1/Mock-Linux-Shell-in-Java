package test;

import static org.junit.Assert.*;
import helpers.Directory;
import helpers.PathWalker;


import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import helpers.File;
import helpers.Tree;

import commands.Number;
import commands.Cd;
import commands.Cp;
import commands.Ls;
import commands.Mkdir;
import commands.Mv;

public class PathWalkerTest {
  Mkdir mkdir;
  Directory dir;
  Cd cd;
  Cp cp;
  Ls ls;
  Mv mv;
  PathWalker pathWalker;
  
  @Before
  public void setUp() {
    mkdir = new Mkdir();
    dir = new Directory();
    cd = new Cd();
    cp = new Cp();
    ls = new Ls();
    mv = new Mv();
    pathWalker = new PathWalker();
    mkdir.execute(dir, "mkdir this that this/one this/one/two", null);
  }

  @Test
  public void testRelativePath() {
    boolean test =pathWalker.goToPath(dir, "this/one");
    String test2 = ls.listDir(dir, "");
    assertEquals("/this/one: two\n", test2);
    assertEquals(true, test);
  }
  
  @Test
  public void testAbsolutePath() {
    boolean test =pathWalker.goToPath(dir, "this/one");
    boolean test3 = pathWalker.goToPath(dir, "/that");
    String test2 = ls.listDir(dir, "");
    assertEquals("/that:\n", test2);
    assertEquals(true, test);
    assertEquals(true, test3);
  }
  @Test
  public void testWrongPath() {
    boolean test =pathWalker.goToPath(dir, "wrong");
    boolean test3 = pathWalker.goToPath(dir, "/wrong");
    String test2 = ls.listDir(dir, "");
    assertEquals("/: this that\n", test2);
    assertEquals(false, test);
    assertEquals(false, test3);
  }
}
