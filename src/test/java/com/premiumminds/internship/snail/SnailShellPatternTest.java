package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  }

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(expected, result);
  }
  @Test
  public void ScreenLockinPatternTestFirst3Length2Test2()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 1, 2, 3 }, { 8, 1, 9, 4 }, { 7, 1, 6, 5 }, { 7, 1, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 1, 2, 3, 4, 5, 5, 6, 1, 7, 7, 8, 1, 9, 6, 1 };
    assertArrayEquals(expected, result);
  }
  @Test
  public void ScreenLockinPatternTestFirst3Length2Test3()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = {};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { };
    assertArrayEquals(expected, result);
  }
}