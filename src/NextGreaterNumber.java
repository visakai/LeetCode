/**
 * Created by sikpeng on 10/5/2017.
 */
public class NextGreaterNumber {
  public static void main(String[] args){
    NextGreaterNumber ngn = new NextGreaterNumber();
    int[] nums1 = {4,1,2};
    int[] nums2 = {1,3,4,2};
    ngn.nextGreaterElement(nums1, nums2);
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length]; // be careful, not length -1
    System.out.println("length="+ result.length);
    for(int i=0; i<nums1.length; i++){
      System.out.println("i="+i);
      System.out.println("nums1[i]="+nums1[i]);

      int targetIndex=-1;
      boolean found = false;
      for(int j=0; j<nums2.length; j++){
        System.out.println("j="+j);
        System.out.println("nums2[j]="+nums2[j]);
        if(nums2[j]==nums1[i]){
          targetIndex = j;
          System.out.println("targetIndex="+targetIndex);

        }
        if(targetIndex>-1 && j>targetIndex && nums2[j]>nums1[i]){
          System.out.println("found next greater value = "+nums2[j]);
          result[i] = nums2[j];
          found = true;
          break;
        }
      }

      if(!found){
        System.out.println("not found next greater value");
        System.out.println("result length = " + result.length);

        result[i]=-1;
      }

    }

    return result;
  }
}
