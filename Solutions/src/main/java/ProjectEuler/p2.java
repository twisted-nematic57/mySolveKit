/*** p2.java ******************************************************************\
 * Author:         twisted_nematic57                                          *
 * Date Created:   2025-12-27                                                 *
 * Description:    Solution to Project Euler problem #2                       *
 \******************************************************************************/

package ProjectEuler;

import org.apfloat.Apint;

public class p2 {
  public static void main() {
    int[] rollingElementWindow = new int[] {1,2};
    int current = 0;
    Apint sum = new Apint(2); // The second term is even!

    while(current < 4000000) { // 4 million
      current = rollingElementWindow[0] + rollingElementWindow[1];
      rollingElementWindow[0] = rollingElementWindow[1];
      rollingElementWindow[1] = current;

      if(current % 2 == 0) {
        sum = sum.add(new Apint(current));
      }
    }

    System.out.println("Sum of all even Fibonacci numbers in [1,4_million]:\n" + sum);
  }
}
