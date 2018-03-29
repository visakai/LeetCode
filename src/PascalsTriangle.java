import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 10/6/2017.
 each number is the sum of two numbers above
     1            row 0
    1 1           row 1
   1 2 1          row 2
  1 3 3 1         row 3
 1 4 6 4 1        row 4
1 5 10 10 5 1     row 5
 */
public class PascalsTriangle {
  public static void main(String[] args) {
    PascalsTriangle pt = new PascalsTriangle();
    System.out.println(pt.getRow(3));
    System.out.println(pt.generate(5));

  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> row = new ArrayList<Integer>();
    if(rowIndex==0){
      row.add(1);
    } else {
      List<Integer> upperRow = getRow(rowIndex -1);
      row.add(1);
      for(int i=0; i<upperRow.size()-1; i++){
        row.add(upperRow.get(i) + upperRow.get(i+1));
      }
      row.add(1);
    }
    return row;
  }

  /*
  generate the first numRows of Pascal's triangle. (numRows=5)
      [
      [1],
      [1,1],
      [1,2,1],
      [1,3,3,1],
      [1,4,6,4,1]
      ]
      */
  public List<List<Integer>> generate(int numRows) {
    List<Integer> upperRow = new ArrayList<Integer>();
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();

    List<Integer> row = new ArrayList<Integer>();
    row.add(1);
    triangle.add(row);

    for(int j = 0; j <numRows-1; j++){
      row = new ArrayList<Integer>();
      row.add(1);
      for(int i=0; i<upperRow.size()-1; i++){
        row.add(upperRow.get(i) + upperRow.get(i+1));
      }
      row.add(1);
      upperRow = row;// persist current row outside the loop, so that next loop can use it
      triangle.add(row);
    }
      return triangle;
  }

}
