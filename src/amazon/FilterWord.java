package amazon;

import java.util.*;

/**
 * Created by sikpeng on 3/27/2018.
 */

/*
*
* 1. Literature text and exclusion list of words.
* Find the maximum frequency of the words in the literature text
* and don't include the words in the exclusion list.
Input: This is a sample text. This sample text is just text.
Exclusion list: {is, a}
Output: text - 3
*
*
*
* 是这个题目的简化版http://www.lintcode.com/zh-cn/problem/top-k-frequent-words/
可行的做法是，把exclude word list放进一个Set中，每次遍历字符串中的单词，然后用一个Map来统计单词出现的次数，最后找到出现最多的即可
* */
public class FilterWord {
  public static void main(String[] args){
    String text = "This is a sample text. This sample text is just text. That is a dog? This is a cat!! you're nice, it's good.";
    List<String> exclusionList = new ArrayList();
    exclusionList.add("is");
    exclusionList.add("a");
    FilterWord fw = new FilterWord();
    System.out.println(fw.getMostFrequentWord(text, exclusionList));
  }

  private List<String> getMostFrequentWord(String text, List<String> exclusionList){
    // first parse text to string array and trimmed comma, periods, etc
    String[] words = text.split("\\W+");
    System.out.println(Arrays.toString(words));

    Map<String, Integer> map = new HashMap();
    for(String word : words){
      if(!exclusionList.contains(word)){
        if(map.containsKey(word)){
          map.put(word, map.get(word) + 1);
        } else {
          map.put(word, 1);
        }
      }
    }
    int maxValue = 0;
    for(int value : map.values()){
      maxValue = Math.max(maxValue, value);
    }
    List<String> result = new ArrayList();
    for(String key : map.keySet()){
      if(map.get(key)==maxValue){
        result.add(key);
      }
    }

    return result;
  }
}

