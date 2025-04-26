import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public abstract String getItemType();
    @Override
    public String toString() {
        return getItemType()+": "+name;
    }
}
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
    @Override
    public String getItemType() {
        return "Electronics";
    }
}
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
    @Override
    public String getItemType() {
        return "Groceries";
    }
}
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
    @Override
    public String getItemType() {
        return "Furniture";
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items;
    public Storage() {
        items=new ArrayList<>();
    }
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
}
class WarehouseUtility {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage=new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));
        Storage<Groceries> groceriesStorage=new Storage<>();
        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Rice"));
        Storage<Furniture> furnitureStorage=new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));
        System.out.println("\nDisplaying Electronics:");
        WarehouseUtility.displayItems(electronicsStorage.getItems());
        System.out.println("\nDisplaying Groceries:");
        WarehouseUtility.displayItems(groceriesStorage.getItems());
        System.out.println("\nDisplaying Furniture:");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}