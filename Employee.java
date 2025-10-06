public class Employee{
    private String name;
    private String lastName;
    private double salaryPerMonth;


    public Employee(String name, String lastName, double salaryPerMonth){
        this.name = name;
        this.lastName = lastName;
        if (salaryPerMonth > 0) {
            this.salaryPerMonth = salaryPerMonth;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setSalaryPerMonth(double salaryPerMonth){
        if (salaryPerMonth > 0) {
            this.salaryPerMonth = salaryPerMonth;
        }
    }

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public double getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public double getSalaryPerYear(){
        return salaryPerMonth * 12;
        }

    public void salaryBoost() {
        this.salaryPerMonth *= 1.1;
    }
}

class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Evgheni", "Lisac", 2000);
        Employee emp2 = new Employee("Daria", "Soldan", 2500);

        System.out.println(emp1.getName() + " " + emp1.getLastName() + " " + emp1.getSalaryPerYear());
        System.out.println(emp2.getName() + " " + emp2.getLastName() + " "+ emp2.getSalaryPerYear());

        emp1.salaryBoost();
        emp2.salaryBoost();

        System.out.println("После повышения:");

        System.out.println(emp1.getName() + " " + emp1.getLastName() + " " + emp1.getSalaryPerYear());
        System.out.println(emp2.getName() + " " + emp2.getLastName() + " " + emp2.getSalaryPerYear());
    }
}

