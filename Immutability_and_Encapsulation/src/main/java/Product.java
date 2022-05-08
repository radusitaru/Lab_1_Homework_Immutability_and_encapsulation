import java.util.ArrayList;
import java.util.List;

final public class Product {

    private final String name;
    private final int price;
    private final List<Category> Category;
    private final String description;

    enum Category {
        Electronics,
        Clothes,
        Food,
        DYI;
    }

    Product(String name, int price, List<Category> Category, String description) {
        this.name = name;
        this.price = price;
        this.Category = new ArrayList<>(Category);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Category=" + Category +
                ", description='" + description + '\'' +
                '}';
    }


}
