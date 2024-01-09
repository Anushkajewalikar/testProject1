package Application;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc1=new Scanner(System.in);
    static Services service=new Implementation();
    public static void main(String[] args) {
        System.out.println("SELECT OPERATION");
        System.out.println("1. DISPLAY ALL PRODUCTS");
        System.out.println("2. REMOVE PRODUCT");
        System.out.println("3. UPDATE PRODUCT");
        System.out.println("4. PLACE ORDER");
        System.out.println("5. DISPLAY ALL ORDERS");
        System.out.println("6. EXIT");
        int choice = sc1.nextInt();

        switch (choice) {
            case 1:
                displayAllProduct();
                break;

            case 2:
                removeProduct();
                break;

            case 3:
                updateProduct();
                break;

            case 4:
                placeOrder();
                break;

            case 5:
                displayAllOrders();
                break;

            case 6:
                System.exit(0);
                break;

            default:
                System.err.println("INVALID INPUT");
        }
        main(args);

    }

    public static void displayAllProduct(){
        List<Product> productList = service.displayAllProduct();
        System.out.println("===============================");
        System.out.println("ID \t\t NAME \t\t PRICE");
        System.out.println("===============================");
        for(Product p: productList){
            System.out.println(p.getProductId() + "\t\t" + p.getProductName() + "\t\t" + p.getProductPrice());
        }
        System.out.println("===============================");

    }

    public static void removeProduct(){
        System.out.println("ENTER THE PRODUCT ID YOU WANT TO DELETE");
        int productId = sc1.nextInt();

        Product newProduct = new Product(productId);

        int n = service.removeProduct(newProduct);
        System.out.println(n + " RECORD DELETED");
        System.out.println("-----------------");
    }

    public static void updateProduct(){
        System.out.println("ENTER THE PRODUCT ID YOU WANT TO UPDATE");
        int productId = sc1.nextInt();
        System.out.println("ENTER UPDATED PRODUCT NAME");
        String productName = sc1.next();
        System.out.println("ENTER UPDATED PRODUCT PRICE");
        double productPrice = sc1.nextDouble();
        System.out.println("ENTER UPDATED PRODUCT QUANTITY");
        int productQty = sc1.nextInt();
        Product newProduct = new Product(productId, productName, productPrice, productQty);
        int n = service.updateProduct(newProduct);
        System.out.println(n + " PRODUCT UPDATED");
        System.out.println("-----------------");
    }

    public static void placeOrder(){
        System.out.println("PROVIDE YOUR NAME");
        String name = sc1.next();
        System.out.println("PROVIDE PRODUCT ID");
        int pid = sc1.nextInt();
        System.out.println("PROVIDE YOUR QUANTITY");
        int qty = sc1.nextInt();
        Order newOrder = new Order(name,pid,qty);
        boolean n = service.placeOrder(newOrder);
        if(n) {
            System.out.println("ORDER PLACED!!");
            System.out.println("-----------------");
        }
        else {
            System.out.println("CANNOT PLACE ORDER. SORRY! OUT OF STOCK.");
            System.out.println("-----------------");
        }

    }

    public static void displayAllOrders(){
        List<OrderProduct> orderList = service.displayAllOrders();
        System.out.println("===================================================");
        System.out.println("OID \t NAME \t PNAME \t\t QTY \t TOTAL");
        System.out.println("===================================================");
        for (OrderProduct o: orderList){
            System.out.println(o.getOrderId() + "\t\t" + o.getCustomerName() + "\t\t" + o.getProductName()+ "\t\t" + o.getProductQty() +"\t\t" + o.getTotalBill());
        }
        System.out.println("===================================================");


    }
}