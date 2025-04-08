public class Employee {
    private static int emp_counter = 100;
    protected int empID;
    public String name;

    protected double pay;

    public Employee() {
        this.empID = ++emp_counter;
        this.name = "";
        this.pay = 0.0;
    }

    public Employee(String name) {
        this.empID = ++emp_counter;
        this.name = name;
        this.pay = 0.0;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                '}';
    }
}
