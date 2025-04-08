
public class ContractEmployee extends Employee implements Receivable{

    private double contractAmount;
    private int duration;

    public ContractEmployee() {
        super();
        this.contractAmount = 0.0;
        this.duration = 0;
    }

    public ContractEmployee(String name, double contractAmount, int duration) {
        super(name);

        this.contractAmount = contractAmount;
        this.duration = duration;
    }

    public double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public double getReceivableAmount() {
        return this.contractAmount / this.duration;
    }

    @Override
    public double getPay() {
        if (this.duration > 0 && this.contractAmount > 0.0){
            //calculate pay according to rules given
            this.pay = (this.contractAmount / this.duration);
        }
        return this.pay;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "contractAmount=" + contractAmount +
                ", duration=" + duration +
                ", empID=" + empID +
                ", name='" + name + '\'' +
                ", pay=" + this.getPay() +
                '}';
    }
}
