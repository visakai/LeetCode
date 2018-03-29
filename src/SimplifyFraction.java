/**
 * Created by sikpeng on 1/30/2018.
 */

// 12/18 would become 2/3, 24/12 would become 2/1
public class SimplifyFraction {
  public static void main(String[] args){
    SimplifyFraction sf = new SimplifyFraction();
    System.out.println(sf.simplify("12/18"));
    System.out.println(sf.simplify("24/12"));
    System.out.println(sf.simplify("23/13"));


  }
// s: a/b
  public static String simplify(String s){
    String[] parts = s.split("/");
    int a = Integer.parseInt(parts[0]);
    int b = Integer.parseInt(parts[1]);

    int smaller = Math.min(a,b);

    for(int i=2; i<=smaller; i++){
      if(a%i==0 && b%i==0){
        //System.out.println("found common "+i);
        return simplify(a/i+"/"+b/i);
      }
    }
    return s;
  }
}
