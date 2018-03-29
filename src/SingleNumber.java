import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 7/25/2017.
 */
public class SingleNumber {
  public static void main(String[] args){
    int[] nums = {3,5,7,5,3,8,8};
    System.out.println(new SingleNumber().singleNumber(nums));
  }

  public int singleNumber(int[] nums) {
    List<Integer> list = new ArrayList<Integer>();
    System.out.println("lengt="+nums.length);
    for(int i =0; i<nums.length; i++){
      System.out.println(i+"th="+nums[i]);
      if(list.contains(nums[i])){
        System.out.println("remove"+nums[i]);
        list.remove((Integer)nums[i]);
      } else {
        System.out.println("add"+nums[i]);
        list.add((Integer)nums[i]);
      }
    }
    return (int)list.get(0);
  }
}
