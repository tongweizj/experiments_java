public class CommissionedEmployee extends Employee
/*
properties:
grossSales(230)
commissionRate (3.5%)

 method:
 getPay()
 - 3.5% for each item sold
 */
{
    private double grossSales;
    private double commissionRate;

    public CommissionedEmployee() {
    }

    public CommissionedEmployee(String name, double grossSales, double commissionRate) {
        super(name);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public double getPay() {
        if(commissionRate > 0 && grossSales > 0){
            this.pay = (commissionRate * grossSales);
        }
        return this.pay;
    }

    @Override
    public String toString() {
        return "CommissionedEmployee{" +
                "grossSales=" + grossSales +
                ", commissionRate=" + commissionRate +
                ", empID=" + empID +
                ", name='" + name + '\'' +
                ", pay=" + this.getPay() +
                '}';
    }
}
