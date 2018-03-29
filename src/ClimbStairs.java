/**
 * Created by sikpeng on 10/9/2017.
 * there is a n steps stair (n>0)
 * you can either climb 1 or 2 steps each time, how many ways to climb to top?
 * n=1 = 1
 *     1 way
 *
 * n=2 = 1+1
 *     = 2
 *     2 ways
 *
 * n=3 = 1+1+1
 *     = 1+2
 *     = 2+1
 *     3 ways
 *
 * n=4 = 1+1+1+1
 *     = 1+1+2
 *     = 1+2+1
 *     = 2+1+1
 *     = 2+2
 *     5 ways
 *
 * n=5 = 1+1+1+1+1
 *     = 1+1+1+2
 *     = 1+1+2+1
 *     = 1+2+1+1
 *     = 2+1+1+1
 *     = 1+2+2
 *     = 2+1+2
 *     = 2+2+1
 *     8 ways
 *
 *     The number 1,2,3,5,8 reminds fibonacci number
 *
 * Think it backward, the last step has only two possible ways:
 * either a 1-step from n-1 or a 2-step from n-2
 * ways(n) = ways(n-1) + ways(n-2)
 */
public class ClimbStairs {
  public static void main(String[] args){
    ClimbStairs cs = new ClimbStairs();
    for(int i=0; i<20; i++){
      System.out.println("n="+i+", ways="+cs.climbStairs2(i));
    }
  }
  // recursion works but not efficient
  public int climbStairs(int n){
    if(n<=1){
      return 1;
    } else if(n==2){
      return 2;
    } else {
      return climbStairs(n-1) + climbStairs(n-2);
    }
  }
  // iterative
  public int climbStairs2(int n){
    if(n<=1){
      return 1;
    } else if(n==2) {
      return 2;
    } else {
      int ways =0;
      int waysTwoStepsEarlier = 1;
      int waysOneStepEarlier = 2;
      for(int i=3; i<=n; i++){
        ways = waysOneStepEarlier + waysTwoStepsEarlier;
        waysTwoStepsEarlier = waysOneStepEarlier;
        waysOneStepEarlier = ways;
      }
      return ways;

    }
  }
}
