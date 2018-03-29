import java.util.List;

/**
 * Created by sikpeng on 10/5/2017.
 */
public class Employee {

  public int id;
  // the importance value of this employee
  public int importance;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getImportance() {
    return importance;
  }

  public void setImportance(int importance) {
    this.importance = importance;
  }

  public List<Integer> getSubordinates() {
    return subordinates;
  }

  public void setSubordinates(List<Integer> subordinates) {
    this.subordinates = subordinates;
  }

  // the id of direct subordinates
  public List<Integer> subordinates;

}
