/*** p3.java ******************************************************************\
 * Author:         twisted_nematic57                                          *
 * Date Created:   2025-12-27                                                 *
 * Description:    Solution to Project Euler problem #3                       *
 \******************************************************************************/

package ProjectEuler;

public class p3 {
  public static void main() {
    long num = 13195;
    long factor = 0;
    boolean divisorIsPrime = false;

    for(long i = num; i > 0; i--) { // Naive algorithm
      if(num % i == 0) { // For every number that num is divisible by...
        for(int j = 1; j < (int)Math.ceil(Math.sqrt(i)); j++) { // Use trial division to see if it's prime.
          if(i % j == 0) {
            divisorIsPrime = true;
          } else {
            divisorIsPrime = false;
          }
          if(divisorIsPrime) break;
        }
        if(divisorIsPrime) break;
      }
      if(divisorIsPrime) break;
    }

    System.out.println("Largest prime factor of 600851475143:\n" + factor);
  }
}
