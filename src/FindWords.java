import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sikpeng on 7/19/2017.
 */

// https://leetcode.com/problems/keyboard-row/#/description

public class FindWords {
  public static void main(String[] args) {

    String[] input = {"Hello", "Alaska", "Dad", "Peace"};
    String[] output = new FindWords().findWords(input);
    for(int i =0 ; i<output.length; i++){
      System.out.println(output[i]);
    }

    new FindWords().isOneLineWord("abcd");
    new FindWords().isOneLineWord("asdf");

  }

  public String[] findWords(String[] words) {
    List<String> results = new ArrayList();
    for(String word : words){
      if(isOneLineWord(word)){
        results.add(word);
      }
    }
    String[] goodWords = results.toArray(new String[results.size()]);
    return  goodWords;

  }

  private boolean isOneLineWord(String word){
    List firstRow = new ArrayList(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
    List secondRow = new ArrayList(Arrays.asList('a','s','d','f','g','h','j','k','l'));
    List thirdRow = new ArrayList(Arrays.asList('z','x','c','v','b','n','m'));
    List row = new ArrayList();
    word = word.toLowerCase();
    char[] letters = word.toCharArray();
    //System.out.println("word length=" + letters.length);
    if(firstRow.contains(letters[0]) ){
      row = firstRow;
    } else if (secondRow.contains(letters[0])) {
      row = secondRow;
    } else if (thirdRow.contains(letters[0])){
      row = thirdRow;
    } else {
    }

    if(allCharsSameRow(row, letters)){
      //System.out.println("good word");
      return true;
    } else {
      return false;
    }
  }

  private boolean allCharsSameRow(List<String> row, char[] letters){
    for(char x : letters){
      if(!row.contains(x)){
        return false;
      }
    }
    return true;
  }

}
