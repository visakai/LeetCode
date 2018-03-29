import java.util.Arrays;

/**
 * Created by sikpeng on 7/20/2017.
 */
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/#/description
public class MaxProfit {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    int[] prices = {7, 1, 5, 3, 6, 4};
    System.out.println(new MaxProfit().maxProfit(prices));
  }

  public int maxProfit(int[] prices) {
    int minPrice = prices.length>0 ? prices[0]:0;
    int maxProfit = 0;
    for(int i =0; i<prices.length; i++){
      minPrice = Math.min(minPrice, prices[i]);
      maxProfit = Math.max(maxProfit,prices[i]-minPrice);
    }
    return maxProfit;
  }
}
