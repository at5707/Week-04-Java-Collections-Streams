import java.util.*;
import java.util.stream.*;
class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductSales{" +
               "productId='" + productId + '\'' +
               ", totalRevenue=" + totalRevenue +
               '}';
    }
}
public class ProductSalesAnalysis {
	public static List<ProductSales> topSales(List<Sale> sales) {
        return sales.stream()
            .filter(s -> s.quantity > 10)
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .sorted((a, b) -> Double.compare(b.totalRevenue, a.totalRevenue))
            .limit(5)
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Sale> salesList = Arrays.asList(
            new Sale("P101", 5, 100.0),
            new Sale("P102", 12, 150.0),
            new Sale("P103", 20, 75.0),
            new Sale("P104", 15, 200.0),
            new Sale("P105", 8, 300.0),
            new Sale("P106", 25, 60.0),
            new Sale("P107", 11, 250.0)
        );

        List<ProductSales> topProducts = topSales(salesList);
        System.out.println("Top 5 Products by Revenue:");
        topProducts.forEach(System.out::println);
    }
}