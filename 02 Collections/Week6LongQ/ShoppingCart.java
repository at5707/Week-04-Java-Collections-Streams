import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
    private Map<String,Double> productPrices=new HashMap<>();
    private LinkedHashMap<String,Integer> cart=new LinkedHashMap<>();
    public void addProduct(String name,double price) {
        productPrices.put(name, price);
    }
    public void addToCart(String name,int quantity) {
        if (!productPrices.containsKey(name)) {
            System.out.println("Product not found: "+name);
            return;
        }
        cart.put(name, cart.getOrDefault(name, 0)+quantity);
    }
    public void displayCartInInsertionOrder() {
        System.out.println("== Cart (Insertion Order) ==");
        for (Map.Entry<String,Integer> entry : cart.entrySet()) {
            String product=entry.getKey();
            int qty=entry.getValue();
            double price=productPrices.get(product);
            System.out.printf("%s-Qty: %d-Unit Price: %.2f-Total:%.2f%n",product,qty,price,qty*price);
        }
    }
    public void displayCartSortedByPrice() {
        System.out.println("== Cart (Sorted by Price) ==");
        TreeMap<Double,List<String>> priceMap=new TreeMap<>();
        for (String product : cart.keySet()) {
            double price=productPrices.get(product);
            priceMap.computeIfAbsent(price, k->new ArrayList<>()).add(product);
        }
        for (Map.Entry<Double,List<String>> entry : priceMap.entrySet()) {
            double price=entry.getKey();
            for (String product : entry.getValue()) {
                int qty=cart.get(product);
                System.out.printf("%s-Qty: %d-Unit Price: %.2f-Total:%.2f%n",product,qty,price,qty*price);
            }
        }
    }
    public static void main(String[] args) {
        ShoppingCart cart=new ShoppingCart();
        cart.addProduct("Apple", 1.99);
        cart.addProduct("Banana", 0.99);
        cart.addProduct("Milk", 2.49);
        cart.addProduct("Bread", 1.49);
        cart.addToCart("Milk", 1);
        cart.addToCart("Apple", 3);
        cart.addToCart("Bread", 2);
        cart.addToCart("Banana", 5);
        cart.displayCartInInsertionOrder();
        System.out.println();
        cart.displayCartSortedByPrice();
    }
}