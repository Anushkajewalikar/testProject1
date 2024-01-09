package Application;

import java.util.List;

public interface Services {
    List<Product> displayAllProduct();
    int removeProduct(Product product);
    int updateProduct(Product product);
    boolean placeOrder(Order newOrder);
    List<OrderProduct> displayAllOrders();
}