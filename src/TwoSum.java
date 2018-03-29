import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sikpeng on 7/25/2017.
 */
public class TwoSum {
  public static void main(String[] args){
    int[] nums = {1,2,4,5,8,13};
    int[] indexes = new TwoSum().twoSum(nums, 7);
    System.out.println(indexes[0]);
    System.out.println(indexes[1]);
  }

  public int[] twoSum(int[] nums, int target) {
    Map checked = new HashMap();
    List needed = new ArrayList();
    int indexA = 0;
    int indexB = 0;

    for(int i =0; i<nums.length; i++){
      if(needed.contains(nums[i])){
        indexA = (int)checked.get(target-nums[i]);
        indexB = i;
        int[] result = {indexA, indexB};
        return result;
      }
      checked.put(nums[i], i);
      needed.add(target-nums[i]);

    }

    return null;
  }
}
