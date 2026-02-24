/*** y2015_d02p1.java *********************************************************\
 * Author:         twisted_nematic57                                          *
 * Date Created:   2025-12-26                                                 *
 * Description:    Solution to Advent of Code 2015 Day 2 Part 1               *
\******************************************************************************/

package AdventOfCode;

import java.util.Arrays;

public class y2015_d02p1 {
  public static void main(String[] input) {
    int[] dimensions = new int[3];
    int[] areas = new int[3];
    long total = 0;

    for(int i = 0; i < input.length; i++) {
      String[] dimensions_raw = input[i].split("x");


      dimensions[0] = Integer.parseInt(dimensions_raw[0]); // Length
      dimensions[1] = Integer.parseInt(dimensions_raw[1]); // Width
      dimensions[2] = Integer.parseInt(dimensions_raw[2]); // Height

      areas[0] = dimensions[0]*dimensions[1];
      areas[1] = dimensions[1]*dimensions[2];
      areas[2] = dimensions[2]*dimensions[0];
      Arrays.sort(areas); // The "slack" (area of smallest side) will be the last element.

      total += (2L*dimensions[0]*dimensions[1] + // -----------------------
          2L*dimensions[1]*dimensions[2] + // Surface area calculation (2*l*w + 2*w*h + 2*h*l)
          2L*dimensions[2]*dimensions[0] + // -----------------------
          areas[0]); // Gotta add the slack too!

      System.out.println("Step: " + i + "; Total: " + total);
    }

    System.out.println("\nGrand total wrapping paper needed: " + total);
  }
}
