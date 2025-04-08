/*
 implements 继承 interface
 没有数量限制
 */
public class Invoice implements Payable, Receivable {
    private String partId;
    private String partName;
    private int quantity;
    private double unitPrice;

    public Invoice(String partId, String partName, int quantity, double unitPrice) {
        this.partId = partId;
        this.partName = partName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "partId='" + partId + '\'' +
                ", partName='" + partName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }

    @Override
    public double getPayableAmount() {
        return ( this.quantity * this.unitPrice);
    }

    public double getReceivableAmount(){
        double amount;
        if(this.quantity < 20) {
            amount = (this.quantity * (this.unitPrice - 10) * 1.13);
        }else{
            amount = (this.quantity * (this.unitPrice + 0.30 ) * 1.13);
        }
        return amount;
    }


}
