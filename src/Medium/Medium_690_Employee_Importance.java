// 690. Employee Importance
package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Medium_690_Employee_Importance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    private static int dfs(HashMap<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int score = employee.importance;

        for (int empId : employee.subordinates)
            score += dfs(map, empId);
        return score;
    }
    public static int getImportance(List<Employee> employees, int id) {
        // Map each employee's id to the Employee object for quick lookup
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees)
            map.put(employee.id, employee);
        return dfs(map, id);
    }
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);

        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();

        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();

        List<Employee> employees = Arrays.asList(e1, e2, e3);
        System.out.println(getImportance(employees, 1));

        Employee e4 = new Employee();
        e4.id = 5;
        e4.importance = -3;
        e4.subordinates = new ArrayList<>();

        employees = List.of(e4);
        System.out.println(getImportance(employees, 5));
    }
}
