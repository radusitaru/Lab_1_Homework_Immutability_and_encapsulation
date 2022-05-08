import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product.category> categoryArrayList = new ArrayList<>();
        categoryArrayList.add(Product.category.Electronics);

        Product product = new Product("Test", 15, new ArrayList<>(List.of(Product.category.Electronics)), "Its just a test1");
        Product product2 = new Product("Test2", 25, categoryArrayList, "Its just a test2");
        Product product3 = new Product("Test3", 35, new ArrayList<>(List.of(Product.category.DYI)), "Its just a test3");
        Product product4 = new Product("Test4", 45, new ArrayList<>(List.of(Product.category.Food)), "Its just a test4");


        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getCategoriesList());
        System.out.println(product.getDescription());
        System.out.println(product.getClass());

        //Am adaugat getter si setter

    }
}
