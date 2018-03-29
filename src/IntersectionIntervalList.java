/* Intersection of two sorted interval lists, with no overlapping in each list,
 A=[(1,2), (5,7)..]
B=[(2,6)...] return [(5,6)..]
end points are exclusive
*/

import java.util.*;



public class IntersectionIntervalList {

  public static void main(String[] args){
    Interval[] i1 = new Interval [4];
    i1[0]= new Interval(1,2);
    i1[1]= new Interval(5,7);
    i1[2]= new Interval(9,16);
    i1[3]= new Interval(17,20);

    Interval[] i2 = new Interval [5];
    i2[0]= new Interval(2,6);
    i2[1]= new Interval(8,10);
    i2[2]= new Interval(12,14);
    i2[3]= new Interval(15,18);
    i2[4]= new Interval(25,28);


    // should return (5,6) (9,10) (12,14) (15,16) (17,18)
    IntersectionIntervalList inter = new IntersectionIntervalList();
    List<Interval> res = inter.intersection(i1,i2);
    for(Interval i : res){
      System.out.println("("+i.start+","+ i.end+")");
    }

  }
  public List<Interval> intersection(Interval[] a1, Interval[] a2){
    List<Interval> result = new ArrayList();
    for(int i=0;i<a1.length; i++){
      for(int j=0; j<a2.length;j++){
        Interval v = intersect(a1[i], a2[j]);
        if(v!=null){
          result.add(v);
        }
      }
    }
    return result;
  }

  private Interval intersect(Interval v1, Interval v2){
    if(v1.start >= v2.end || v1.end <=v2.start){
      return null;
    } else if(v1.start>=v2.start && v1.end <=v2.end) {
      return v1;
    } else if(v2.start>=v1.start && v2.end <=v1.end){
      return v2;
    } else {
      return new Interval( Math.max(v1.start, v2.start), Math.min(v1.end, v2.end));
    }


  }
}
