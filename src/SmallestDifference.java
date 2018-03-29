import java.util.Arrays;

/**
 * Created by sikpeng on 10/7/2017.
 */
public class SmallestDifference {
  public static void main(String[] args){
    SmallestDifference sd = new SmallestDifference();
    int[] nums1 = {3,5,20,7,33,44,55};
    int[] nums2 = {26,17,23,66,70};
    System.out.println(sd.getSmallestDiff(nums1, nums2));
   // System.out.println(Integer.MAX_VALUE);
    System.out.println(sd.getSmallestDiff2(nums1, nums2));

  }

  // takes O(AB) time, where A=nums1.length B=nums2.length
  public int getSmallestDiff(int[] nums1, int[] nums2){
    int smallestDiff = -1;
    for(int i=0; i<nums1.length; i++){
      for(int j=0; j<nums2.length; j++){
        int diff = Math.abs(nums1[i]-nums2[j]);
        if(smallestDiff<0 || diff<smallestDiff){
          smallestDiff = diff;
        }
      }
    }
    return smallestDiff;
  }

  // sorting takes O(AlogA + BlogB); moving pointers take O(A+B); Overall takes O(AlogA + BlogB)
  public int getSmallestDiff2(int[] nums1, int[] nums2){
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int index1 = 0;
    int index2 = 0;
    int min = Integer.MAX_VALUE;
    while (index1 < nums1.length && index2 < nums2.length ){
      int diff = Math.abs(nums1[index1] - nums2[index2]);
      if (diff < min){
        min = diff;
      }
      // move up the smaller pointer to minimize the diff
      if(nums1[index1]<nums2[index2]){
        index1 ++;
      } else {
        index2 ++;
      }
    }
    return min;
  }
}
