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

      // Matrix traverse parameters
      int left = 0, top = 0, right = matrix.length, bottom = matrix.length, horizontal_increment = 1, vertical_increment = 1;

      // Shell parameters
      int[] snail_shell = new int[matrix.length * matrix.length];
      int shell_piece = 0, row = 0, column = 0;

      // Build shell
      while(shell_piece < snail_shell.length) {
        // Add shell piece
        snail_shell[shell_piece++] = matrix[row][column];

        // Update matrix traverse parameters
        if (horizontal_increment == vertical_increment) { // Case movement is horizontal

          if(horizontal_increment > 0) {  // Case movement is left to right
            if (column < right - 1) { // Keep current direction if right boundary not reached
              column += horizontal_increment;
              continue;
            }
            top++; // Right boundary reached: constrict top boundary
          } else if (column > left) { // Keep current direction if left boundary not reached
            column += horizontal_increment;
            continue;
          } else bottom--; // Left boundary reached: constrict bottom boundary

          // Change movement direction
          horizontal_increment = -horizontal_increment;
          row += vertical_increment;

        } else { // Case movement is vertical

          if (vertical_increment > 0) { // Case movement is top to bottom
            if (row < bottom - 1) { // Keep current direction if bottom boundary not reached
              row += vertical_increment;
              continue;
            }
            right--; // Bottom boundary reached: constrict right boundary
          } else if (row > top) { // Keep current direction if top boundary not reached
            row += vertical_increment;
            continue;
          } else left++; // Top boundary reached: constrict left boundary

          // Change movement direction
          vertical_increment = -vertical_increment;
          column += horizontal_increment;

        }
      }

      return snail_shell;
    });
  }
}
