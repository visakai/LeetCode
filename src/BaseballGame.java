import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 10/5/2017.
 */
public class BaseballGame {
  public static void main(String[] args){

    String[] input = {"5","2","D","+"};
    BaseballGame bg = new BaseballGame();
    System.out.println(bg.calPoints(input));

  }

  public int calPoints(String[] ops) {

    List<Integer> scores = new ArrayList<Integer>();

    int totalScore = 0;

    for(int i=0; i<ops.length; i++){
      int s = 0; // score value of current round
      if(ops[i]=="+" && scores.size()>1){
        s = scores.get(scores.size()-1) + scores.get(scores.size()-2);
        scores.add(s);
      } else if(ops[i]=="D"){
        s = 2 * scores.get(scores.size()-1);
        scores.add(s);
      } else if(ops[i]=="C"){
        scores.remove(scores.size()-1);
      } else {
        s = Integer.parseInt(ops[i]);
        scores.add(s);
      }
    }

    for(int k=0; k<scores.size(); k++){
      totalScore = totalScore + scores.get(k);
    }
    return totalScore;
  }
}

