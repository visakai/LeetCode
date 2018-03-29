import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sikpeng on 10/7/2017.
 *  given an array of distinct int, and an targetInt, found all pair of int and sum is targetInt
 */
public class NumberPair {
  public static void main(String[] args){
    int[] nums = {2,6,9,14,7,11,13,4,10,5,20,8,16};
    int target = 15;
    NumberPair np = new NumberPair();
    System.out.println(np.findPair(nums,target));
  }
  public List<List<Integer>> findPair(int[] nums, int target){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Set<Integer> diff = new HashSet<Integer>();

    for(int i=0; i<nums.length; i++){
      if (diff.contains(nums[i])) {
        List<Integer> pair = new ArrayList<Integer>();
        pair.add(nums[i]);
        pair.add(15-nums[i]);
        result.add(pair);
      } else{
        diff.add(target - nums[i]);
      }
    }
    return result;
  }
}
