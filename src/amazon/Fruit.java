package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 3/28/2018.\
 *
 *https://yidongzhang.gitbooks.io/-oa-1/content/mai-shui-guo.html
 *
 * public static int checkWinner (List<List<String>> codeList, List<String> shoppingCart) {}
 说的是小明要帮公司买水果，给了一个codeList， 里面装的是target水果，shoppingCart里面装的是他买的水果，
 目标是检查codelist里的水果顺序是否和shoppingCart里的顺序匹配。
 注意的是只有codelist中的所有链表的item之后加起来小于等于shoppingcart里item之和才可能返回1。
 另外在codelist中有可能出现item时 "anything"， 它可以和任意的单一水果匹配。
 *
 *
 */
public class Fruit {
  public static void main(String[] args){
/*
* Ex1:
 codelist: [apple, apple], [orange, banana, orange]
 shoppingCart: [orange, apple, apple, orange, banana, orange].
 return 1, 因为codelist里的顺序和shoppingcart里除了第一个orange之后的水果顺序匹配.

*/
    List<List<String>> codeList1 = new ArrayList<>();
    List<String> code1 = new ArrayList<>();
    code1.add("apple");
    code1.add("apple");
    List<String> code2 = new ArrayList<>();
    code2.add("orange");
    code2.add("banana");
    code2.add("orange");
    codeList1.add(code1);
    codeList1.add(code2);

    List<String> shoppingCart1 = new ArrayList<String>();
    shoppingCart1.add("orange");
    shoppingCart1.add("apple");
    shoppingCart1.add("apple");
    shoppingCart1.add("orange");
    shoppingCart1.add("banana");
    shoppingCart1.add("orange");
    System.out.println("ex1: " + checkWinner(codeList1, shoppingCart1) );
/*
 Ex2:
 codelist: [orange, banana, orange]， [apple, apple]
 shoppingCart: [orange, apple, apple, orange, banana, orange]
 return 0, 因为codeList里的顺序和shoppingcart没法匹配。
*/
    List<List<String>> codeList2 = new ArrayList<>();
    List<String> code21 = new ArrayList<>();
    code21.add("orange");
    code21.add("banana");
    code21.add("orange");
    List<String> code22 = new ArrayList<>();
    code22.add("apple");
    code22.add("apple");
    codeList2.add(code21);
    codeList2.add(code22);

    List<String> shoppingCart2 = new ArrayList<String>();
    shoppingCart2.add("orange");
    shoppingCart2.add("apple");
    shoppingCart2.add("apple");
    shoppingCart2.add("orange");
    shoppingCart2.add("banana");
    shoppingCart2.add("orange");
    System.out.println("ex2: " + checkWinner(codeList2, shoppingCart2) );

/*
 Ex3:
 codelist: [apple, apple], [orange, banana, orange], [pear, orange, grape]
 shoppingCart: [orange, apple, apple, orange, banana, orange, pear, grape]
 return 0, 因为codelist里最后一个[pear, orange, grape]中的orange没法和shoppingcart里的水果匹配。
*/
    List<List<String>> codeList3 = new ArrayList<>();
    List<String> code31 = new ArrayList<>();
    code31.add("apple");
    code31.add("apple");
    List<String> code32 = new ArrayList<>();
    code32.add("orange");
    code32.add("banana");
    code32.add("orange");
    List<String> code33 = new ArrayList<>();
    code33.add("pear");
    code33.add("orange");
    code33.add("grape");
    codeList3.add(code31);
    codeList3.add(code32);
    codeList3.add(code33);

    List<String> shoppingCart3 = new ArrayList<String>();
    shoppingCart3.add("orange");
    shoppingCart3.add("apple");
    shoppingCart3.add("apple");
    shoppingCart3.add("orange");
    shoppingCart3.add("banana");
    shoppingCart3.add("orange");
    shoppingCart3.add("pear");
    shoppingCart3.add("grape");
    System.out.println("ex3: " + checkWinner(codeList3, shoppingCart3) );

/*
 Ex4:
 codeList: [apple, apple], [orange, anything, orange].
 shoppingCart: [orange, apple, apple, orange, mango, orange]
 return 1。

*/
    List<List<String>> codeList4 = new ArrayList<>();
    List<String> code41 = new ArrayList<>();
    code41.add("apple");
    code41.add("apple");
    List<String> code42 = new ArrayList<>();
    code42.add("orange");
    code42.add("anything");
    code42.add("orange");
    codeList4.add(code41);
    codeList4.add(code42);

    List<String> shoppingCart4 = new ArrayList<String>();
    shoppingCart4.add("orange");
    shoppingCart4.add("apple");
    shoppingCart4.add("apple");
    shoppingCart4.add("orange");
    shoppingCart4.add("mango");
    shoppingCart4.add("orange");
    System.out.println("ex4: " + checkWinner(codeList4, shoppingCart4) );
/*

 Ex5:
 codeList: [apple, apple], [banana, orange].
 shoppingCart: [orange, apple, apple, orange, peach, melon, apple, banana, orange, grape]
 return 1.  codeList之间可以插入任何数量的任何水果
*
* */

    List<List<String>> codeList5 = new ArrayList<>();
    List<String> code51 = new ArrayList<>();
    code51.add("apple");
    code51.add("apple");
    List<String> code52 = new ArrayList<>();
    code52.add("banana");
    code52.add("orange");
    codeList5.add(code51);
    codeList5.add(code52);

    List<String> shoppingCart5 = new ArrayList<String>();
    shoppingCart5.add("orange");
    shoppingCart5.add("apple");
    shoppingCart5.add("apple");
    shoppingCart5.add("orange");
    shoppingCart5.add("peach");
    shoppingCart5.add("melon");
    shoppingCart5.add("apple");
    shoppingCart5.add("banana");
    shoppingCart5.add("orange");
    shoppingCart5.add("grape");

    System.out.println("ex5: " + checkWinner(codeList5, shoppingCart5) );

  }
  public static int checkWinner(List<List<String>> codeList, List<String> shoppingCart){

    //System.out.println(codeList);
    //System.out.println(shoppingCart);

    int i = 0; // outer index for codeList, codeList[1]= {"banana", "orange"}
    int j = 0; // inner index within each list,  codeList[1][0]="banana"

    int cart = 0; // index for shoppingCart fruits

    while(i<codeList.size() && cart<shoppingCart.size()){
      if(shoppingCart.get(cart).equals(codeList.get(i).get(j)) || codeList.get(i).get(j).equals("anything")){
        //System.out.println("match");

        cart ++; // move the pointer of shoppingCart
        if(j+1 <= codeList.get(i).size()-1){
          j++;
        } else {// means current list OK, move to next codelist
          i++;
          j=0;
        }

      } else {
        // not match
        //System.out.println("not match");
        if(j==0){
          // current shoppingcart fruit does not match with first fruit in one codelist, move cart pointer to next
          cart ++;
        } else {
          // current shoppingcart fruit does not match with a non leading fruit in a codelist
          // means nodelist should return to beginning of current list
          // and shoppingCart should stay on current fruit and enter the next loop to re-try with nodelist
          j=0;
        }
      }
    }
    //System.out.println("loop done");

    if(i==codeList.size()){
      return 1;
    }

    return 0;
  }
}
