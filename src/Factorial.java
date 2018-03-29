/**
 * Created by sikpeng on 10/7/2017.
 */
// n! = 1*2*3*4*5*...*(n-1)*n
public class Factorial {
  public static void main(String[] args){
    Factorial f = new Factorial();
    for(int i=1; i<10; i++) {
      System.out.println(i+ "!=" +f.getFactorial(i));
    }
  }
  public long getFactorial(int n){
    if(n<=1){
      return 1L;
    } else {
      return 1L*n*getFactorial(n-1);
    }
  }
}
