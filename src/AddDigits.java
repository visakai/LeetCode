/**
 * Created by sikpeng on 10/5/2017.
 */
public class AddDigits {
  public static void main(String[] args){
    AddDigits ad = new AddDigits();
    System.out.println(ad.addDigits(3456));

  }

  public int addDigits(int num) {
    if(num<10){
      return num;
    } else {
      String s = new Integer(num).toString();
      char[] c = s.toCharArray();
      int x = 0;
      for(int i=0; i<c.length; i++){
        x = x + Integer.parseInt(c[i]+"");
      }
      return addDigits(x);//recursively
    }
  }
}
