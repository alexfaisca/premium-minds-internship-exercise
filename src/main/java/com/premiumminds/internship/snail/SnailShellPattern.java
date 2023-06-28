package com.premiumminds.internship.snail;

import java.util.concurrent.*;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {
  private ExecutorService executor = Executors.newSingleThreadExecutor();

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    return executor.submit(() -> {
      // Traverse parameters
      int left = 0, top = 0, right = matrix.length, bottom = matrix.length, horizontal_increment = 1, vertical_increment = 1;
      // Shell parameters
      int[] snail_shell = new int[matrix.length * matrix.length];
      int shell_piece = 0, row = 0, column = 0;

      while(shell_piece < matrix.length * matrix.length) {
        // Add shell piece
        snail_shell[shell_piece++] = matrix[row][column];
        // Update traverse parameters
        if (horizontal_increment == vertical_increment) { // Check if movement is horizontal
          if(horizontal_increment > 0) { // Check movement direction
            if (column < right - 1) { // Check if right boundary reached
              column += horizontal_increment;
              continue;
            }
            top++; // Top horizontal completed: update top boundary
          } else if (column > left) { // Check if left boundary reached
            column += horizontal_increment;
            continue;
          } else bottom--; // Bottom horizontal completed: update bottom boundary
          // Change movement direction
          horizontal_increment = -horizontal_increment;
          row += vertical_increment;
        } else {
          if (vertical_increment > 0) { // Check movement direction
            if (row < bottom - 1) { // Check if bottom boundary reached
              row += vertical_increment;
              continue;
            }
            right--; // Right vertical completed: update right boundary
          } else if (row > top) { // Check if top boundary reached
            row += vertical_increment;
            continue;
          } else left++; // Left vertical completed: update left boundary
          // Change movement direction
          vertical_increment = -vertical_increment;
          column += horizontal_increment;
        }
    }

    return snail_shell;
    });
  }
}
