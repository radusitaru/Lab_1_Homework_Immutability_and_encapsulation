import java.util.ArrayList;
import java.util.List;

final public class Product {


    private final String name;
    private final int price;
    private final List<category> categoriesList;
    private final String description;

    enum category {
        Electronics,
        Clothes,
        Food,
        DYI;
    }

    Product(String name, int price, List<category> categoriesList, String description) {
        this.name = name;
        this.price = price;
        this.categoriesList = new ArrayList<>(categoriesList);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<category> getCategoriesList() {
        return new ArrayList<>(categoriesList);
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Category=" + categoriesList +
                ", description='" + description + '\'' +
                '}';
    }


}
