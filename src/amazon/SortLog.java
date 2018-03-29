package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sikpeng on 3/28/2018.
 * Given a log file, each string in the list of log file represents an identifier which is alphanumeric
 * rest of the substrings can be numbers or letters. Sort the substring following the id, the string in lexicographically.
 * 给你一个log file，List，每个元素代表log file一行，在每个元素里面，有substring，他们用空格分开，比如"a1ws efg7 i90s",
 * String里面只有字母和数字，第一个substring是id，依据id后面的substring给log file排序，字母在top。
 *
 * 这个题目的考点是写compare的比较，可以先把这个String分成id和log，然后用一个类来表示，写这个类的比较函数，再调用sort()排序即可
 *
 */
public class SortLog {

  public static void main(String[] args){
    List<String> log = new ArrayList<String>();
    log.add("id33 book something good");
    log.add("id11 amazing view");
    log.add("id25 888 issues found really loooooong line very long");
    log.add("id55 zigzag shape");
    log.add("id22 this is a car");
    log.add("1126 this is a cartoon");
    log.add("id15 how are you");
    log.add("id99 user log in");
    log.add("id66 user log in");
    log.add("id72 user log in");

    Collections.sort(log, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int firstSpace1 = s1.indexOf(" ");
        String id1 = s1.substring(0, firstSpace1);
        String content1 = s1.substring(firstSpace1 + 1);

        int firstSpace2 = s2.indexOf(" ");
        String id2 = s2.substring(0, firstSpace2);
        String content2 = s2.substring(firstSpace2 + 1);

        int diff = content1.compareTo(content2);

        if(diff!=0){
          return diff;
        } else {
          return id1.compareTo(id2); // if content same, compare unique id
        }
      }
    });

    System.out.println(log);

  }
}
