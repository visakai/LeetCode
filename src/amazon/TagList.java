package amazon;

import java.util.*;

/**
 * Created by sikpeng on 3/28/2018.
 *
 * 寻找最短的sub sequence contains 所有的tag

 input 大概是这样
 tag_list = ["made","in","china"]
 all_tags = ["made", "a","b","c","in", "china","made","b","c","d"]
 答案则为 [4,6], 不需要保存顺序，只需返回最短的subsequence包含所有tag_list的元素
 当时时间有点紧，开始也用错了方法，后来想到应该是用前向型双指针，希望可以帮到大家
 */
public class TagList {

  public static int[] shortSubseq(String[] allTagList, String[] targetList) {
    /*
     loop through all tags, find the first tag contained in target list, mark index as start1,
     continue to find first remaining target tags, the last location as end1, length1=end1-start1+1,

     loop from node[start1 + 1], repeat above logic, have start2, end2, length2=end2-start2+1,
     loop from node[start2 + 1], repeat above logic, have start3, end3, length3=end3-start3+1,
     after all these, compare all length, return the shortest one

     there are some optimization can be made
     we can keep track the min length, then in next loop, we can exit loop early if current length already longer than min
    length
     */
    //System.out.println(Arrays.toString(allTagList));
    int searchFrom = 0;
    List<List<Integer>> subseqs = new ArrayList<>();

    while(searchFrom < allTagList.length){
      Set<String> target = new HashSet<String>(Arrays.asList(targetList));
      List<Integer> subseq = new ArrayList<>();
      for(int i=searchFrom; i<allTagList.length; i++){
        String tag = allTagList[i];
        if(target.contains(tag)){
          target.remove(tag);
          subseq.add(i);
        }
      }
      if(subseq.size()<targetList.length){
        break;
      }
      subseqs.add(subseq);
      searchFrom = subseq.get(0) + 1; // next loop will start search from next node
    }

    int minLength = Integer.MAX_VALUE;
    int start = -1;
    int end = -1;
    for(List<Integer> subseq : subseqs){
      int length = subseq.get(subseq.size()-1) - subseq.get(0) +1;
      if(length<minLength){
        minLength = length;
        start = subseq.get(0);
        end = subseq.get(subseq.size()-1);
      }
    }
    return new int[]{start,end};
  }


    public static int[] q1(String[] availableTagList, String[] targetList) {
    Map<String, Integer> map = new HashMap<>();
    for (String t : targetList) {
      map.put(t.toLowerCase(), 0);
    }

    int i = 0, start = 0, len = availableTagList.length + 1, missing = targetList.length;
    for (int j=0; j<availableTagList.length; j++) {
      Integer count = map.get(availableTagList[j].toLowerCase());
      if (count != null) {
        map.put(availableTagList[j].toLowerCase(), ++count);
        if (count == 1) {
          missing--;
        }
        while (missing == 0) {
          if (j-i+1 < len) {
            start = i;
            len = j-i+1;
          }

          Integer c = map.get(availableTagList[i].toLowerCase());
          if (c != null) {
            map.put(availableTagList[i].toLowerCase(), --c);
            if (c == 0) {
              missing++;
            }
          }
          i++;
        }
      }
    }

    if (len > availableTagList.length) {
      return new int[]{0};
    }

    return new int[]{start, start+len-1};
  }

  // find out all subtrings with length num that has no repeat letters
  public static List<String> q2(String inputStr, int num) {

    if (num == 0 || num > inputStr.length()) return new ArrayList<>();

    int[] dict = new int[26];
    Set<String> set = new LinkedHashSet<>();
    int start = 0, end = 0;
    while (end < inputStr.length()) {
      if (dict[inputStr.charAt(end) - 'a'] == 0) {
        dict[inputStr.charAt(end) - 'a']++;
        if (end - start + 1 == num) {
          set.add(inputStr.substring(start, end+1));
          dict[inputStr.charAt(start) - 'a']--;
          start++;
        }
        end++;
      } else {
        dict[inputStr.charAt(start) - 'a']--;
        start++;
      }
    }

    return new ArrayList<>(set);
  }

  public static void main(String[] args) {
    String[] targetList = {"made", "in", "spain"};
    String[] availableTagList = {"made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays"};
    //System.out.println("T11");
    System.out.println(Arrays.toString(q1(availableTagList, targetList)));
    System.out.println(Arrays.toString(shortSubseq(availableTagList, targetList)));



    String[] targetList2 = {"2abc", "bcd", "cab"};
    String[] availableTagList2 = {"dbc", "2abc", "cab", "bcd", "bcb"};
    System.out.println("T12");
    System.out.println(Arrays.toString(q1(availableTagList2, targetList2)));
    System.out.println(Arrays.toString(shortSubseq(availableTagList2, targetList2)));

    String[] targetList3 = {"in", "the", "spain"};
    String[] availableTagList3 = {"the", "spain", "that", "the", "rain", "in", "spain", "stays", "forecast", "in", "the"};
    System.out.println("T13");
    System.out.println(Arrays.toString(q1(availableTagList3, targetList3)));
    System.out.println(Arrays.toString(shortSubseq(availableTagList3, targetList3)));


    String inputStr = "awaglknagawunagwkwagl";
    System.out.println("T21");
    System.out.println(q2(inputStr, 5));

    String inputStr2 = "aaabbcccc";
    System.out.println("T22");
    System.out.println(q2(inputStr2, 2));

  }
}
