public class Employee {
    private static int emp_counter = 100;
    public int empID;
    public String name;
    /*
    protected members can be inherited within child class
    but can not be accessed elsewhere
     */
    protected double pay;

    public Employee() {
        this.empID = ++emp_counter;
        this.name = "";
        this.pay = 0.0;
    }
    public Employee( String name) {
        this.empID = ++emp_counter;
        this.name = name;
        this.pay = 0.0;
    }

    public int getEmpID() {
        return empID;
    }

    public String getName() {
        return name;
    }

    public double getPay() {
        return pay;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setName(String name) {
        this.name = name;
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

