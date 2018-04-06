package microsoft;

import java.util.Arrays;

/**
 * Created by sikpeng on 4/1/2018.
 *
 * reverse a char array in-place, note the punctuation handling
 * "How are you doing?"  =>
 * "?doing you are How"
 */
public class ReverseCharArray {
  public static void main(String[] args){
    String a  = "How are you doing?";
    System.out.println(reverse(a.toCharArray()));
  }

  public static char[] reverse(char[] text){
    // first step, reverse it to "?gniod uoy era woH"
    for(int i=0; i<text.length/2; i++){
      char temp = text[i];
      text[i] = text[text.length-1-i];
      text[text.length-1-i] = temp;
    }

    // second step, reverse within word
    int lettersCount = 0;
    for(int i=0; i<text.length; i++){
      if(Character.isAlphabetic(text[i])){
        lettersCount ++;
      }

     // System.out.println("lettersCount="+lettersCount);

      if(text[i]==' '){
        reverseBetween(text, i-lettersCount, i-1);
        lettersCount = 0;
      }

      if(i==text.length-1){
        reverseBetween(text, i-lettersCount+1, i);
      }
    }
    return text;
  }

  private static void reverseBetween(char[] text, int startIndex, int endIndex){
    //System.out.println(Arrays.toString(text));
    //System.out.println("startIndex="+startIndex);
    //System.out.println("endIndex="+endIndex);

    while(startIndex < endIndex){
      char temp = text[startIndex];
      text[startIndex]= text[endIndex];
      text[endIndex] = temp;
      startIndex++;
      endIndex--;
    }

    //System.out.println(Arrays.toString(text));

  }
}
