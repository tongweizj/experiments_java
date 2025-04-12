public abstract class Account extends Consumer{
    private int accountNum;

    public Account(String id, String name, int accountNum) {
        super(id, name);
        this.accountNum = accountNum;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }
    abstract void withdraw(double amount);
    abstract void deposit(double amount);

    @Override
    public String toString() {
        return "Account = {" +
                "id = " + getId()  + '\''+
                " name = " + getName()  + '\''+
                " accountNum =" + accountNum  + '\''+
                '}';
    }
}
