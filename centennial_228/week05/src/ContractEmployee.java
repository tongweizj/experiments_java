/*
ContractEmployee inherits from Employee class
Employess class is inherited in to ContractEmployee

ContractEmployee IS-A Employee

Employee - parent or super or base class
contractEmployee - child or sub or derived

all the properties and method from the Employee class
can be used in ContractEmployee class
*/

public class ContractEmployee extends Employee {
    private double contractAmount;
    private int duration;


    public ContractEmployee(String name) {
        super(name);
        this.contractAmount = 0.0;
        this.duration = 0;
    }
    public ContractEmployee(String name, double contractAmount, int duration) {
        /*
         super keyword refers to the Parent/super class
         to access properties of parent class, use super.name
         to access the methods of super class, use super.getPay()
         to access constructor of super class, use Super()

         Super(name) will call the Employee class constructor and supply
         */
        super(name);
        this.contractAmount = contractAmount;
        this.duration = duration;
    }

    public ContractEmployee(double contractAmount, int duration) {
        this.contractAmount = contractAmount;
        this.duration = duration;
    }

    public double getContractAmount() {
        return contractAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }
    // method to calculate the pay
    /*
      Override used to override performed by parent class method
      Method overriding - child class modifying the parent class method
             - same method signature in both classess
             - must be marked as @override
      Method overloading - can use anywhere
      - same class multiple methods with same name ubt different signatre

      Constructor OVerloading -
      - multiple constructors with different signuatures
      具有不同签名的多个构造函数
    */

    @Override
    public double getPay() {
        if(this.duration >0 && this.contractAmount > 0.0){
            this.pay = ( this.contractAmount / this.duration);
        }
        return this.pay;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "contractAmount=" + contractAmount +
                ", duration=" + duration +
                ", empID=" + empID +
                ", name=" + name +
                ", pay = " + this.getPay() + '\n'+
                '}';
    }
}
