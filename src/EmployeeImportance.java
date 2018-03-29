import java.util.ArrayList;
import java.util.List;

/**
 * Created by sikpeng on 10/5/2017.
 */
public class EmployeeImportance {
  public static void main(String[] args) {
    EmployeeImportance ei = new EmployeeImportance();
    List<Employee> employees = new ArrayList<Employee>();

    Employee e1 = new Employee();
    e1.setId(1);
    e1.setImportance(2);
    List e1sub = new ArrayList();
    e1sub.add(2);
    e1.setSubordinates(e1sub);

    Employee e2 = new Employee();
    e2.setId(2);
    e2.setImportance(3);
    List e2sub = new ArrayList();
    e2.setSubordinates(e2sub);

    employees.add(e1);
    employees.add(e2);
    System.out.println(ei.getImportance(employees, 1));
  }

  public int getImportance(List<Employee> employees, int id) {
    int importance = 0;
    for (Employee employee : employees) {

      if(employee.getId()==id){

        if(employee.getSubordinates().size()>0){
          // if employee has subs, call method recursively to get importance of his each sub
          for(int i =0; i<employee.getSubordinates().size(); i++){
            int subId = employee.getSubordinates().get(i);
            int subImp = getImportance(employees, subId);
            importance = importance + subImp;
          }
          // add then add himself important value
          importance = importance + employee.getImportance();

        } else {
          // lowest level employee
          importance = employee.getImportance();
        }
      }
    }
    return importance;
  }

}

