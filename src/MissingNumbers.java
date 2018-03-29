import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 10/6/2017.
 * leetcode NO 448
 */
public class MissingNumbers {
  public static void main(String[] args) {
    MissingNumbers mn = new MissingNumbers();
    int[] nums = {4,3,5,6,1,4,1,8};
    System.out.println(mn.findDisappearedNumbers(nums));
  }

  public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<Integer>();

    for(int i = 0; i < nums.length; i++) {
      System.out.println("i="+i);
      System.out.println("nums["+i+"]="+nums[i]);
      int index = Math.abs(nums[i]) - 1;
      System.out.println("index="+index);

      if(nums[index] > 0) {
        nums[index] = -nums[index];
      }
      System.out.println("after negation nums["+index+"]="+nums[index]);

    }

    for(int i = 0; i < nums.length; i++) {
      if(nums[i] > 0) {
        ret.add(i+1);
      }
    }
    return ret;
  }
}
