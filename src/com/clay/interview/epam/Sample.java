package interview.epam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * I/P
 *  * [{name:'a',salary:20000,age:25},
 *  * {name:'b',salary:25000,age:23},
 *  * {name:'c',salary:34000,age:25}
 *  * {name:'d',salary:13000,age:30}]
 *  *
 *  * Sort it first on the basis of age then on the basis of salary.
 */
public class Sample {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        initialize(employees);

        employees.sort(Comparator.comparing(Employee::getSalary));
        
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void initialize(List<Employee> employees) {
        employees.add(new Employee("a", 20000, 25));
        employees.add(new Employee("b", 25000, 23));
        employees.add(new Employee("c", 34000, 25));
        employees.add(new Employee("d", 13000, 30));
    }

}

class Employee {

    public Employee(String name, Integer salary, Integer age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    private String name;
    private Integer salary;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}