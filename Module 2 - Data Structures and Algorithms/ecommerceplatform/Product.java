package ecommerceplatform;

public class Product {
    public int productId;
    private String productName;
    private String category;
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product ID: " + this.productId + "\nProduct Name: " + this.productName + "\nCategory: " + this.category;
    }
}