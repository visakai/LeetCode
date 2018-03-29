import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sikpeng on 3/10/2018.
 *
 * given a list of movies with length in minutes and a flight length
 * return all possible combinations of two movies so the the total length equals to flight length*
 *
 * flightTime = 120 min
 * movies [("godfather", 130),
 * ("batman", 80),
 * ("fight club", 50),
 * ("love story", 75),
 * ("big fish", 96),
 * ("friday", 40),
 * ("father", 60),
 * ("god", 80),
 * ("superman", 70),
 * ("man", 50),
 * ("gone", 40)
 * ]
 *
 * should return
 * {batman, friday}
 * {batman, gone}
 * {fight club, superman}
 * {friday, god}
 * {superman, man}
 * {god, gone}
 *
 * order does not matter
 */


public class HuluInterview {

  List<List<String>> matchPairs = new ArrayList<>();

  public static void main(String[] args){
    Map<String, Integer> movies = new HashMap<String, Integer>();
    movies.put("godfather", 130);
    movies.put("batman", 80);
    movies.put("fight club", 50);
    movies.put("big fish", 96);
    movies.put("friday", 40);
    movies.put("father", 60);
    movies.put("god", 80);
    movies.put("superman", 70);
    movies.put("man", 50);
    movies.put("gone", 40);
    HuluInterview hulu = new HuluInterview();
    System.out.println(hulu.getMoviePair(movies, 120));
  }

  private List<List<String>> getMoviePair(Map<String, Integer> movies, int flightLength){

    Map<Integer, List<String>> movieGroupByLength = new HashMap<Integer, List<String>>();

    // group movies by length
    for(Map.Entry<String, Integer> movie : movies.entrySet()){
      String movieName = movie.getKey();
      int movieLength = movie.getValue();

      if(movieGroupByLength.containsKey(movieLength)){
        List<String> previousNames = movieGroupByLength.get(movieLength);
        previousNames.add(movieName);
        movieGroupByLength.put(movieLength, previousNames);
      } else {
        List<String> movieNames = new ArrayList<String>();
        movieNames.add(movieName);
        movieGroupByLength.put(movieLength, movieNames);
      }
    }

    // iterate through the group and create combination if needed

    for(int movieTime : movieGroupByLength.keySet()){
      if(movieTime < flightLength/2 && movieGroupByLength.containsKey(flightLength - movieTime)) {
        generatePair(movieGroupByLength.get(movieTime), movieGroupByLength.get(flightLength - movieTime));
      } else if(movieTime == flightLength/2 ) {
        generatePair(movieGroupByLength.get(movieTime));
      }
    }


    return matchPairs;
  }


  private  void generatePair(List<String> list1, List<String> list2){
    for(String n1 : list1){
      for(String n2 : list2){
        List<String> pair = new ArrayList();
        pair.add(n1);
        pair.add(n2);
        matchPairs.add(pair);
      }
    }
  }

  private  void generatePair(List<String> list){
    if(list.size()>1){
      for(int i=0; i<list.size()-1; i++){
        for(int j=i+1; j<list.size(); j++){
          List<String> pair = new ArrayList();
          pair.add(list.get(i));
          pair.add(list.get(j));
          matchPairs.add(pair);
        }
    }
    }
  }
}
