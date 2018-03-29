import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 7/19/2017.
 */
public class SplitString {
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  public List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList();
    for(int i = 0; i<n; i++){
      System.out.println("hi");
      result.add(Integer.toString(i));
    }

    return result;
  }
}
