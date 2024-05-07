import java.util.*;

//======================================================================================================================
abstract class Employee{
    private String name;
    private int id;
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;

    }

    public abstract double calculate_salary();


    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+", salary="+calculate_salary()+"]";
     }

}
//======================================================================================================================

class FullTimeEmployee extends Employee{

    private double montlySalary;


    public FullTimeEmployee(String name,int id,double montlySalary){
        super(name,id);
        this.montlySalary=montlySalary;
    }
    @Override
     public double calculate_salary(){
        return montlySalary;
    }
}
//======================================================================================================================

class Part_Time_Employee extends Employee{
    private int Hours_Worked;
    private double hourlyRate;

    public Part_Time_Employee(String name,int id,int Hours_Worked,double hourlyRate){
        super(name,id);
        this.Hours_Worked=Hours_Worked;
        this.hourlyRate=hourlyRate;
    }
     @Override
    public double calculate_salary(){
        return hourlyRate*Hours_Worked;
     }

}
//======================================================================================================================

class Payroll_System{
    private ArrayList<Employee>employeeList;

    public Payroll_System(){
        employeeList = new ArrayList<>();
    }
    public void add_Employee(Employee employee){
        employeeList.add(employee);
    }
    public void remove_Employee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployess(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }

}
//======================================================================================================================
public class Main {
    public static void main(String[] args) {
        Payroll_System payrollSystem=new Payroll_System();
        FullTimeEmployee  emp1= new FullTimeEmployee("Gaurav",1,700000);
        Part_Time_Employee emp2=new Part_Time_Employee("Rahul",2,5,300);
        payrollSystem.add_Employee(emp1);
        payrollSystem.add_Employee(emp2);
        System.out.println("Initial Emoloyee Details: ");
        payrollSystem.displayEmployess();
        System.out.println("Removing Employee");
        payrollSystem.remove_Employee(2);
        System.out.println("Remaining Employee Details: ");
        payrollSystem.displayEmployess();

        }
    }
