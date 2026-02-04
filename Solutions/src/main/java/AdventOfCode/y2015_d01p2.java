/*** y2015_d01p1.java *********************************************************\
 * Author:         twisted_nematic57                                          *
 * Date Created:   2025-12-26                                                 *
 * Description:    Solution to Advent of Code 2015 Day 1 Part 2               *
\******************************************************************************/

package AdventOfCode;

public class y2015_d01p2 {
  public static void main(String[] input) {
    int floor = 0;
    int basementStepIndex = 0;

    for(int step = 0; step < input[0].length(); step++) {
      if(input[0].charAt(step) == '(') {
        floor++;
      } else {
        floor--;
      }

      System.out.println("Step = " + step + "; Current floor = " + String.format("% d", floor));
      if(floor == -1) {
        basementStepIndex = step + 1;
        break;
      }
    }

    System.out.println("\nResult = " + basementStepIndex);
  }
}

