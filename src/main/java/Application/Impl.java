package Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Implementation implements Services{

    private static Connection conn;
    static {
        String url = "jdbc:mysql://localhost:3306/test2db";
        String username = "root";
        String password = "tiger";
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.err.println("CONNECTION UNSUCCESSFUL !! ");
            System.exit(1);
        }
    }

    @Override
    public List<Product> displayAllProduct() {
        String displayProductQuery = "SELECT * FROM PRODUCT_INFO";
        List<Product> productList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(displayProductQuery);
            while (rs.next()){
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                double productPrice = rs.getDouble(3);
                int productQty = rs.getInt(4);
                Product product = new Product(productId,productName,productPrice,productQty);
                productList.add(product);
            }
        } catch (SQLException e) {

        }
        return productList;
    }

    @Override
    public int removeProduct(Product product) {
        int n =0;
        String deleteQuery = "DELETE FROM PRODUCT_INFO WHERE PRODUCT_ID= ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1,product.getProductId());
            n=pstmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("PRODUCT NOT FOUND");
        }
        return n;
    }

    @Override
    public int updateProduct(Product product) {
        int n =0;
        String updateQuery = "UPDATE PRODUCT_INFO SET PRODUCT_NAME=?, PRODUCT_PRICE=?, PRODUCT_QTY=? WHERE PRODUCT_ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1,product.getProductName());
            pstmt.setDouble(2,product.getProductPrice());
            pstmt.setInt(3,product.getProductQty());
            pstmt.setInt(4,product.getProductId());
            n=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            System.err.println("PRODUCT ID NOT FOUND");
        }
        return n;
    }

    @Override
    public boolean placeOrder(Order newOrder) {
        boolean n =false;
        try {
            CallableStatement cstmt = conn.prepareCall("{CALL placeOrder(?,?,?,?)}");
            cstmt.setString(1,newOrder.getCustomerName());
            cstmt.setInt(2,newOrder.getProductId());
            cstmt.setInt(3, newOrder.getProductQty());
            cstmt.execute();
            n=cstmt.getBoolean(4);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    @Override
    public List<OrderProduct> displayAllOrders() {
        String query="SELECT O.ORDER_ID, O.CUSTOMER_NAME,P.PRODUCT_NAME, O.PRODUCT_QTY,O.PRODUCT_QTY * P.PRODUCT_PRICE AS TOTAL FROM ORDER_INFO O INNER JOIN PRODUCT_INFO P ON O.PRODUCT_ID=P.PRODUCT_ID ORDER BY O.ORDER_ID ASC";
        List<OrderProduct> orderList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int orderId = rs.getInt(1);
                String customerName = rs.getString(2);
                String productName = rs.getString(3);
                int productQty = rs.getInt(4);
                double totalBill = rs.getDouble(5);
                OrderProduct order = new OrderProduct(orderId,customerName,productName,productQty,totalBill);
                orderList.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderList;
    }
}