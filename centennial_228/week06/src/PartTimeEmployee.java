public class PartTimeEmployee extends Employee{
    private double hourlyWage;
    private int weeklyHours;

    public PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(String name, double hourlyWage, int weeklyHours) {
        super(name);
        this.hourlyWage = hourlyWage;
        this.weeklyHours = weeklyHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getWeeklyHours() {
        return weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public double getPay() {
        if (this.hourlyWage > 0 && this.weeklyHours > 0){
            this.pay = (this.hourlyWage * this.weeklyHours * 2);
        }
        return this.pay;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hourlyWage=" + hourlyWage +
                ", weeklyHours=" + weeklyHours +
                ", empID=" + empID +
                ", name='" + name + '\'' +
                ", pay=" + this.getPay() +
                '}';
    }
}
