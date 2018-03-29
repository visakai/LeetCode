/**
 * Created by sikpeng on 10/6/2017.
 */
public class SecondLargestNumber {
  public static void main(String[] args){
    SecondLargestNumber sln = new SecondLargestNumber();
    int[] nums = {2,5,6,4,8,9,34,55,4,2,7,5,2,22}; // a non-negative int array
    System.out.println(sln.findSecondLargestNumber(nums));
  }

  public int findSecondLargestNumber(int[] nums){

    int largest = -1;
    int secondLargest = -1;
    for(int i=0; i<nums.length; i++){
      if(nums[i] >= largest){
        secondLargest = largest;
        largest = nums[i];
      } else if (nums[i] >= secondLargest){
        secondLargest = nums[i];
      }
    }
    return secondLargest;
  }
}
