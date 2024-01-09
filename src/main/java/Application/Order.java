package Application;

public class Order {

    private int orderId;
    private String customerName;
    private int ProductId;
    private int productQty;
    private double total;

    public Order() {
    }

    public Order(String customerName, int productId, int productQty, double total) {
        this.customerName = customerName;
        ProductId = productId;
        this.productQty = productQty;
        this.total = total;
    }

    public Order(String customerName, int productId, int productQty) {
        this.customerName = customerName;
        ProductId = productId;
        this.productQty = productQty;
    }

    public Order(int orderId, String customerName, int productId, int productQty, double total) {
        this.orderId = orderId;
        this.customerName = customerName;
        ProductId = productId;
        this.productQty = productQty;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}