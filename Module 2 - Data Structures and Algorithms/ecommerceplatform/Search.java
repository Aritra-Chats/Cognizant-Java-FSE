package ecommerceplatform;

import java.util.Arrays;

public class Search {
    private static int LinearSearch(Product[] products, int productId) {
        int operations = 0;
        for(int i = 0; i < 5; i++) {
            operations++;
            if(products[i].productId == productId)
                return operations;
        }
        return -1;
    }
    private static int binarySearch(Product[] products, int productId) {
        int L = 0, R = 4, operations = 0;
        while(R-L >= 1) {
            int M = L+(R-L)/2;
            operations++;
            if(products[M].productId == productId)
                return operations;
            else if(products[M].productId < productId)
                L = M+1;
            else
                R = M-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Product[] products = {
            new Product(8472, "Nebula Speaker", "Audio"),
            new Product(1935, "Quantum Bottle", "Lifestyle"),
            new Product(6281, "Velocity Mouse", "Computer Accessories"),
            new Product(4509, "EcoFlex Notebook", "Stationery"),
            new Product(7713, "AeroFit Smartwatch", "Wearables")
        };
        Arrays.sort(products, (a, b) -> (a.productId-b.productId));
        System.out.println("Linear Search Operations: " + LinearSearch(products, 6281) + 
                            "\nBinary Search Operations: " + binarySearch(products, 6281));
    }
    
}
