import java.util.HashSet;
import java.util.Set;

/**
 * Created by sikpeng on 10/5/2017.
 */
public class HappyNumber {
  public static void main(String[] args){
    HappyNumber hn = new HappyNumber();
    System.out.println(hn.isHappy(5));
  }
  public boolean isHappy(int n) {
    System.out.println("n=" + n);
    Set results = new HashSet();
    return abc(results, n);
  }

  private boolean abc(Set results, int n){
    String[] digits = Integer.toString(n).split("");
    int result = 0;
    for(int i=0; i<digits.length; i++){
      int digit = Integer.parseInt(digits[i]);
      System.out.println("digit="+digit);
      int square = digit * digit;
      System.out.println("square="+square);

      result += square;
    }
    System.out.println("result="+result);
    if(result==1){
      return true;
    } else if(results.contains(result)) {
      return false;
    } else {
      results.add(result);
      System.out.println("results size="+results.size());

      return abc(results, result);
    }
  }
}
