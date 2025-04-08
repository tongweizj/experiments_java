public class FullTimeEmployee extends Employee {
    double annualSalary;
    double pay;

    public FullTimeEmployee(double annualSalary, double pay) {
        this.annualSalary = annualSalary;
        this.pay = pay;
    }
    public FullTimeEmployee(String name, double annualSalary) {
        super(name);
        this.annualSalary = annualSalary;

    }

    public FullTimeEmployee(String name, double annualSalary, double pay) {
        super(name);
        this.annualSalary = annualSalary;
        this.pay = pay;
    }

    public  double getPAy(){
        this.pay = (this. annualSalary / 26);
        return this.pay;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "annualSalary=" + annualSalary +
                ", pay=" + pay +
                ", empID=" + empID +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                '}';
    }
}
