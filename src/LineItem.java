public class LineItem {
    private int quantity;
    private Product product;
    private double total;

    public LineItem(int quantity, Product product, double total) {
        this.quantity = quantity;
        this.product = product;
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public double calculateLineItemTotal() {
        return quantity * product.getUnitPrice();
    }
}
