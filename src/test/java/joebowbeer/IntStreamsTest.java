package joebowbeer;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntStreamsTest {

  public IntStreamsTest() {
  }

  @Test
  public void spiralIntStreamFrom0x0() {
    assertArrayEquals(new int[0], IntStreams.spiralIntStream(new int[][]{}).toArray());
  }

  @Test
  public void spiralIntStreamFrom1x1() {
    assertArrayEquals(new int[]{1}, IntStreams.spiralIntStream(new int[][]{{1}}).toArray());
  }

  @Test
  public void spiralIntStreamFrom1x2() {
    assertArrayEquals(new int[]{1, 2}, IntStreams.spiralIntStream(new int[][]{{1, 2}}).toArray());
  }

  @Test
  public void spiralIntStreamFrom2x1() {
    assertArrayEquals(new int[]{1, 2}, IntStreams.spiralIntStream(new int[][]{{1}, {2}}).toArray());
  }

  @Test
  public void spiralIntStreamFrom4x4() {
    assertArrayEquals(new int[]{1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10},
        IntStreams.spiralIntStream(
            new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}).toArray());
  }

  @Test
  public void spiralIntStreamFrom4x3() {
    assertArrayEquals(new int[]{1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8},
        IntStreams.spiralIntStream(
            new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}}).toArray());
  }
}
