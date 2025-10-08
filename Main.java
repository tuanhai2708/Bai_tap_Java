import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

interface PaymentMethod {
    void pay(double amount);
}

class CashPayment implements PaymentMethod {
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Thanh toán tiền mặt thành công. Số tiền: " + df.format(amount));
    }
}

class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Thanh toán bằng thẻ tín dụng thành công. Số tiền: " + df.format(amount));
    }
}

class MomoPayment implements PaymentMethod {
    public void pay(double amount) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Thanh toán bằng ví Momo thành công. Số tiền: " + df.format(amount));
    }
}

abstract class Product {
    protected String productId;
    protected String productName;
    protected double price;
    protected String category;

    public Product(String productId, String productName, double price, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }
}

class ElectronicProduct extends Product {
    private String imei;
    private int warrantyMonths;

    public ElectronicProduct(String productId, String productName, double price, String imei, int warrantyMonths) {
        super(productId, productName, price, "Electronic");
        this.imei = imei;
        this.warrantyMonths = warrantyMonths;
    }
}

class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String productId, String productName, double price, String expiryDate) {
        super(productId, productName, price, "Food");
        this.expiryDate = expiryDate;
    }
}

class Order {
    private String customerName;
    private List<Product> productList;
    private PaymentMethod paymentMethod;

    public Order(String customerName) {
        this.customerName = customerName;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        double total = 0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }

    public void checkout() {
        double total = getTotal();
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + df.format(total));
        paymentMethod.pay(total);
        System.out.println("-----");
    }
}

public class Main {
    public static void main(String[] args) {
        ElectronicProduct laptop = new ElectronicProduct("E01", "Laptop Dell", 12035000, "IMEI12345", 24);
        ElectronicProduct phone = new ElectronicProduct("E02", "iPhone 15", 25000000, "IMEI67890", 12);
        FoodProduct snack = new FoodProduct("F01", "Snack Oishi", 25000, "2025-12-31");

        Order order1 = new Order("Nguyễn Văn D");
        order1.addProduct(laptop);
        order1.setPaymentMethod(new CashPayment());
        order1.checkout();

        Order order2 = new Order("Nguyễn Văn E");
        order2.addProduct(phone);
        order2.setPaymentMethod(new CreditCardPayment());
        order2.checkout();

        Order order3 = new Order("Nguyễn Văn C");
        order3.addProduct(snack);
        order3.setPaymentMethod(new MomoPayment());
        order3.checkout();

        Order order4 = new Order("Nguyễn Văn A");
        order4.addProduct(snack);
        order4.setPaymentMethod(new CreditCardPayment());
        order4.checkout();
    }
}
