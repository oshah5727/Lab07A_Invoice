public class Invoice {
    private LineItem lineItem;
    private CustomerAddress customerAddress;
    private double amountDue;

    public Invoice(LineItem lineItem, CustomerAddress customerAddress, double amountDue) {
        this.lineItem = lineItem;
        this.customerAddress = customerAddress;
        this.amountDue = amountDue;
    }

    public LineItem getLineItem() {
        return lineItem;
    }

    public void setLineItem(LineItem lineItem) {
        this.lineItem = lineItem;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
}
