import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product product = new Product("Test", 15, new ArrayList<>(List.of(Product.Category.Electronics)), "Its just a test1");
        Product product2 = new Product("Test2", 25, new ArrayList<>(List.of(Product.Category.Clothes)), "Its just a test2");
        Product product3 = new Product("Test3", 35, new ArrayList<>(List.of(Product.Category.DYI)), "Its just a test3");
        Product product4 = new Product("Test4", 45, new ArrayList<>(List.of(Product.Category.Food)), "Its just a test4");
        System.out.println(product);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);

        //No getter, no setter method, object is immutable & encapsulated.

    }
}
