package Application;

public class OrderProduct {
    private int orderId;
    private String customerName;
    private double totalBill;
    private String productName;
    private int productQty;

    public OrderProduct(int orderId, String customerName,String productName, int productQty, double totalBill) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalBill = totalBill;
        this.productName = productName;
        this.productQty = productQty;
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

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}