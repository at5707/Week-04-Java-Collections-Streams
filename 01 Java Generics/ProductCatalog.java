import java.util.ArrayList;
import java.util.List;

enum BookCategory {
    FICTION,NONFICTION,SCIENCE,HISTORY
}
enum ClothingCategory {
    MEN,WOMEN,KIDS
}
enum GadgetCategory {
    MOBILE,LAPTOP,ACCESSORY
}
class Product<T extends Enum<T>> {
    private String name;
    private T category;
    private double price;
    public Product(String name,T category,double price) {
        this.name=name;
        this.category=category;
        this.price=price;
    }
    public String getName() {
        return name;
    }
    public T getCategory() {
        return category;
    }
    public void applyDiscount(double percentage) {
        price-=price * (percentage/100);
    }
    @Override
    public String toString() {
        return name+" ["+category+"]-Rs"+String.format("%.2f", price);
    }
}
class ProductUtils {
    public static <T extends Enum<T>> void applyDiscount(Product<T> product,double percentage) {
        System.out.println("Applying "+percentage+"% discount on "+product.getName());
        product.applyDiscount(percentage);
    }
}
public class ProductCatalog {
    public static void main(String[] args) {
        Product<BookCategory> book=new Product<>("The Alchemist", BookCategory.FICTION, 500.0);
        Product<ClothingCategory> shirt=new Product<>("Cotton Shirt", ClothingCategory.MEN, 1200.0);
        Product<GadgetCategory> phone=new Product<>("Smartphone X", GadgetCategory.MOBILE, 15000.0);
        List<Product<?>> catalog=new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        System.out.println("Catalog before discounts:");
        catalog.forEach(System.out::println);
        ProductUtils.applyDiscount(book, 10);
        ProductUtils.applyDiscount(shirt, 20);
        ProductUtils.applyDiscount(phone, 15);
        System.out.println("\nCatalog after discounts:");
        catalog.forEach(System.out::println);
    }
}