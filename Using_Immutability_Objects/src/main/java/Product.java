import java.util.ArrayList;
import java.util.List;

final public class Product {


    /**
     * 1. Class members
     */

    //1.1 Primitive variables
    private final int price;

    //1.2 Reference variables
    private final String name;
    private final String description;

    //1.3 Lists
    private final List<category> categoryList;

    //1.4 Enums
    enum category {
        Electronics,
        Clothes,
        Food,
        DYI
    }

    //1.5 Constructors
    Product(String name, int price, List<category> categoryList, String description) {
        this.name = name;
        this.price = price;
        this.categoryList = new ArrayList<>(categoryList);
        this.description = description;
    }



    /**
     * 2. Methods
     */

    //2.1 Getter and setters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<category> getCategoryList() {
        return new ArrayList<>(categoryList);
    }


    //2.2 toStrings
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", Category=" + categoryList +
                ", description='" + description + '\'' +
                '}';
    }


}
