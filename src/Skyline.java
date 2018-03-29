import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by sikpeng on 3/25/2018.
 *
 * suppose all buildings are rectangles
 * given an array of integers representing the height of skyline
 * find out the min number of buildings needed to form the skyline
 * etc [1,2,3] needs at least three buildings with height 1, 2 and 3
 *  [1,2,1] needs at least two buildings with height 1, and 2,
 *  because building 1 might be wide and short and partially hidden by building 2
 *  [2,1,2] needs at least three buildings
 *
 * the idea is, while looping through the array, keeping a collection of foundHeights
 * if current height already exists in foundHeights collection, do not count the current one
 * the collection needs to be trimmed: remove all higher numbers than current height
 * so we need an ordered collection that keeps the smallest values, we should be able to easily get max value
 * and easily remove max value
 * we need something opposite to PriorityQueue
 *
 */
public class Skyline {
  public static void main(String[] args){
    Skyline s = new Skyline();
    int[] nums = new int[]{1,2,4,5,4,2,5};
    System.out.println(s.getMinBuildings(nums));
  }


  public int getMinBuildings(int[] nums){
    int count =0;
    PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Collections.reverseOrder());

    for(int n : nums){

      while(!pq.isEmpty() && pq.peek()>n) {
        pq.poll();
      }

      if(!pq.contains(n)){
        pq.offer(n);
        count ++;
      }
    }

    return count;
  }

}
