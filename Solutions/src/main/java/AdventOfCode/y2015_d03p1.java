/*** y2015_d03p1.java *********************************************************\
 * Author:         twisted_nematic57                                          *
 * Date Created:   2026-02-24                                                 *
 * Description:    Solution to Advent of Code 2015 Day 3 Part 1               *
\******************************************************************************/

package AdventOfCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class House {
  int[] coords = new int[2];
  int receivedPresents = 1;
}

public class y2015_d03p1 {
  public static void processDelivery(List<House> houseList, int[] coords) {
    List<House> houseSearch = houseList.stream() // See if there are any houses with the coords we're on now
        .filter(h -> Arrays.equals(h.coords, coords))
        .toList();

    if(houseSearch.isEmpty()) { // If no house exists with current coords, add a new house.
      houseList.add(new House());
      houseList.getLast().coords = coords.clone();
    } else { // If a house exists at this coordinate pair, record another present delivered to this one.
      houseSearch.getFirst().receivedPresents++;
    }
  }

  public static void main(String[] input) {
    int[] currCoords = new int[]{0,0};

    List<House> houses = new ArrayList<>();
    houses.add(new House());
    houses.getFirst().coords = currCoords.clone();
    System.out.println("Starting coords: " + Arrays.toString(currCoords));

    final int len = input[0].length();
    for(int step = 0; step < len; step++) {
      switch(input[0].charAt(step)) {
        case '>': // Right (East)
          currCoords[0]++;
          processDelivery(houses, currCoords);
          break;
        case '<': // Left (West)
          currCoords[0]--;
          processDelivery(houses, currCoords);
          break;
        case '^': // Up (North)
          currCoords[1]++;
          processDelivery(houses, currCoords);
          break;
        case 'v': // Down (South)
          currCoords[1]--;
          processDelivery(houses, currCoords);
          break;
      }
      System.out.println("Step: " + step + "; Current coords: " + Arrays.toString(currCoords));
    }

    System.out.println("Total houses that received at least one present: " + houses.size());
  }
}
