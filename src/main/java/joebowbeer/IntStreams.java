package joebowbeer;

import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class IntStreams {

  private IntStreams() { }

  /**
   * Returns IntStream containing elements of given matrix traversed along an inward spiral.
   * @param matrix two-dimensional array of ints
   * @return stream produced by a spiral traversal of the matrix
   */
  public static IntStream spiralIntStream(int[][] matrix) {
    int numRows = matrix.length;
    int numCols = (numRows != 0) ? matrix[0].length : 0;
    return StreamSupport.intStream(new SpiralSpliterator(matrix, numRows, numCols), false);
  }
}
