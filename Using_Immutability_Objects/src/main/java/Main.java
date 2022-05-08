import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //This is the shop creation
        Shop newShop = new Shop();

        //Method calling the shop driver - run main to play shop application
        //Everything is encapsulated and immutable because shop can only be accessed by running the application shop
        newShop.shopDriver();

    }
}
