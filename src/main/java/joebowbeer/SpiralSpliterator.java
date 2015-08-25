package joebowbeer;

import java.util.Spliterators;
import java.util.function.IntConsumer;

/**
 * Traverses matrix of ints along an inward spiral.
 */
class SpiralSpliterator extends Spliterators.AbstractIntSpliterator {

  enum Move { RIGHT, DOWN, LEFT, UP, NONE }

  private final int[][] matrix;
  private int rowTop;
  private int rowBottom;
  private int colLeft;
  private int colRight;
  private int iRow;
  private int jCol;
  private Move move;

  public SpiralSpliterator(int[][] matrix, int numRows, int numCols) {
    super(numRows * numCols, IMMUTABLE | ORDERED | SIZED);
    assert matrix != null && numRows >= 0 && numCols >= 0;
    this.matrix = matrix;
    this.rowBottom = numRows - 1;
    this.colRight = numCols - 1;
    move = (numRows * numCols > 0) ? Move.RIGHT : Move.NONE;
  }

  @Override
  public boolean tryAdvance(IntConsumer action) {
    if (move == Move.NONE) {
      return false;
    }
    action.accept(matrix[iRow][jCol]);
    // advance to next cell
    switch (move){
      default: {
        throw new IllegalStateException();
      }
      case RIGHT: {
        if (jCol == colRight) {
          iRow++;
          rowTop++;
          move = (rowTop <= rowBottom) ? Move.DOWN : Move.NONE;
        } else {
          jCol++;
        }
        break;
      }
      case DOWN: {
        if (iRow == rowBottom) {
          jCol--;
          colRight--;
          move = (colLeft <= colRight) ? Move.LEFT : Move.NONE;
        } else {
          iRow++;
        }
        break;
      }
      case LEFT: {
        if (jCol == colLeft) {
          iRow--;
          rowBottom--;
          move = (rowTop <= rowBottom) ? Move.UP : Move.NONE;
        } else {
          jCol--;
        }
        break;
      }
      case UP: {
        if (iRow == rowTop) {
          jCol++;
          colLeft++;
          move = (colLeft <= colRight) ? Move.RIGHT : Move.NONE;
        } else {
          iRow--;
        }
        break;
      }
    }
    return true;
  }
}
