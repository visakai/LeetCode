package quick;

import java.util.*;

/**
 * Created by sikpeng on 12/14/2017.
 */
public class QuickTest {
  public static void main(String[] args){
    QuickTest qt = new QuickTest();

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
      public int compare(Integer int1, Integer int2){
        if(int1<int2){
          return 1;
        } else if(int1==int2){
          return 0;
        } else {
          return -1;
        }
      }
    });
    pq.offer(Integer.MAX_VALUE);
    pq.offer(7);
    pq.offer(Integer.MIN_VALUE);
    pq.offer(6);

    System.out.println(pq.peek());
  }
}
