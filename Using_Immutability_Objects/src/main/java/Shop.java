import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

final public class Shop {


    /**
     * 1. Class members
     */

    //1.1 Lists
    private final HashMap<Product, Integer> productInventory;
    private final List<Product.category> categoriesList = new ArrayList<>();
    private Product boughtProduct;
    private int categoriesNumber;

    //1.2 Constructors
    Shop() {
        this.productInventory = new HashMap<>();
    }

    /**
     * 2. Methods
     */

    //2.1 Check if product exists under given name
    boolean productNameExists(String productName) {
        boolean foundProduct = false;
        for (Product i : productInventory.keySet()) {
            if (i.getName().equalsIgnoreCase(productName)) {
                foundProduct = true;
                break;
            }
        }
        return foundProduct;
    }

    //2.2 Check if product has stock
    boolean isLeftInStock(Product product, int quantityBought) {
        //2.2.1 Check if productList is not empty and if product name exists in list
        if (productInventory.size() != 0 && productNameExists(product.getName())) {
            if (productInventory.get(product) - quantityBought > 0) {
                return true;
            } else {
                System.out.println("Product out of stock");
                return false;
            }
        } else {
            System.out.println("Product does not exist");
            return false;
        }
    }


    //2.3 Add product
    void addProduct(Product product, int productCount) {

        //2.3.1 Add product name and quantity to inventory
        productInventory.put(product, productCount);

        System.out.println("You added " + productCount + " x " + product.getName() + " to the shop.");
    }

    //2.4 Buy product
    void buyProduct(Product product, int quantityBought) {

        //2.4.1 Check if enough quantity in stock
        if (isLeftInStock(product, quantityBought)) {
            //2.4.2 Removing quantity bought from stock
            productInventory.put(product, productInventory.get(product) - quantityBought);
            System.out.println("You bought " + quantityBought + " x " + product.getName() + ".");
            System.out.println("There are " + productInventory.get(product) + " x " + product.getName() + " left in stock");
        }
    }

    //2.5 Show shop inventory
    void showShopInventory() {
        int counter = 1;
        if (productInventory.size() == 0) System.out.println("Empty shop");
        for (Product i:productInventory.keySet()) {
            System.out.println("---------------" + "Product #:" + (counter) + "---------------------");
            System.out.println("---------------" + "inventory: "+ productInventory);
            System.out.println("-----------------------------------------------");
            counter++;
        }
    }

    //2.6 Shop command driver
    void shopDriver() {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        int command = 4;
        while (command != 0) {
            switch (command) {
                case 1 -> {

                    boolean productExists=true;
                    String name="";

                    //2.6.1 Make sure product doesn't exist under this name
                    while(productExists) {
                        System.out.println("Insert name");
                        name = sc2.nextLine();
                        if (productNameExists(name)) {
                            System.out.println("Product already exists under this name, try again");
                        }
                        else productExists=false;
                    }


                    System.out.println("Insert product price");
                    int price = sc.nextInt();
                    System.out.println("Insert description of product");
                    String description = sc2.nextLine();
                    System.out.println("Insert product count");
                    int productCount = sc.nextInt();
                    System.out.println("Select category");
                    selectCategory();
                    Product product = new Product(name, price, categoriesList, description);
                    addProduct(product, productCount);
                }
                case 2 -> {
                    System.out.println("Insert product name to buy it");
                    String productName = sc2.nextLine();
                    System.out.println("Insert quantity you want to buy");
                    int productQuantity = sc.nextInt();
                    if (checkIfProductMatches(productName)) {
                        buyProduct(boughtProduct, productQuantity);
                    }
                }
                case 3 -> showShopInventory();
                case 4 -> showMenu();
                default -> {
                }
            }
            try {
                command = sc3.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong command input");
            }
        }
    }

    //2.7 Show menu
    void showMenu() {
        System.out.println("-------------------------------");
        System.out.println("-------------MENU--------------");
        System.out.println("1. Add product-----------------");
        System.out.println("2. Buy product-----------------");
        System.out.println("3. List shop products----------");
        System.out.println("4. Show menu-------------------");
        System.out.println("0. Exit shop-------------------");
        System.out.println("-------------------------------");
    }

    //2.8 Select product category
    void selectCategory() {
        boolean categoryNumberExit = false;
        Scanner intInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);

        int categoryCounter = 0;
        boolean exitCategory = false;

        //2.8.1 Loop for selecting number of categories for desired product
        while (!categoryNumberExit) {
            System.out.println("How many categories does this product have? [Max 4]");
            categoriesNumber = intInput.nextInt();

            //2.8.2 If category number is too big, try again
            if (categoriesNumber > 4 || categoriesNumber < 1) {
                System.out.println("Max categoriesNumber = 4, min = 1, try again");
            }

            //2.8.3 If category number is within range, allow user to insert desired categories
            else {
                categoryNumberExit = true;
            }
        }

        //2.8.3.1 Display possible categories to user
        showProductCategories();

        //2.8.3.2 Use switch to allow user to insert the desired amount of categories
        switch (categoriesNumber) {
            case 1 -> {
                categoriesList.clear();

                //2.8.3.2.1 Keep inserting until user selects correct category
                while (!exitCategory) {
                    System.out.println("Insert category");
                    categoriesList.add(Product.category.valueOf(stringInput.nextLine()));

                    //2.8.3.2.2 Check if category is in list, if it is, break loop,
                    if (checkCategoryInput(String.valueOf(categoriesList.get(categoryCounter)))) {
                        exitCategory = true;
                    }

                    //2.8.3.2.3 Else keep repeating
                    else {
                        System.out.println("Category inserted is invalid, try again");
                    }
                }
            }


            //2.8.3.2.4 Same principle as with previous case, just that here it keeps inserting until desired
            //          amount of correct categories has been inserted
            case 2 -> {
                categoriesList.clear();

                //2.8.3.2.5 Using categoryCounter to keep track of correctly inserted categories
                while (categoryCounter < 2) {
                    System.out.println("Insert category #" + (categoryCounter + 1));
                    String insertedCategory = stringInput.nextLine();
                    if (checkCategoryInput(insertedCategory)) {
                        categoriesList.add(Product.category.valueOf(insertedCategory));
                        categoryCounter++;
                    } else {
                        System.out.println("Category inserted is invalid, try again");
                    }
                }
            }
            case 3 -> {
                categoriesList.clear();
                while (categoryCounter < 3) {

                    System.out.println("Insert category #" + (categoryCounter + 1));
                    String insertedCategory = stringInput.nextLine();
                    if (checkCategoryInput(insertedCategory)) {
                        categoriesList.add(Product.category.valueOf(insertedCategory));
                        categoryCounter++;
                    } else {
                        System.out.println("Category inserted is invalid, try again");
                    }
                }
            }
            case 4 -> {
                categoriesList.clear();
                while (categoryCounter < 4) {

                    System.out.println("Insert category #" + (categoryCounter + 1));
                    String insertedCategory = stringInput.nextLine();
                    if (checkCategoryInput(insertedCategory)) {
                        categoriesList.add(Product.category.valueOf(insertedCategory));
                        categoryCounter++;
                    } else {
                        System.out.println("Category inserted is invalid, try again");
                    }
                }
            }
            default -> {
            }
        }
    }


    //2.9 Show product categories
    void showProductCategories() {
        System.out.println("--------------");
        System.out.println("1. Electronics");
        System.out.println("2. Clothes");
        System.out.println("3. Food");
        System.out.println("4. DYI");
        System.out.println("--------------");
    }

    //2.10 Check if category is inserted correctly
    boolean checkCategoryInput(String category) {
        if (!category.equals("Electronics")
                &&
                !category.equals("Clothes")
                &&
                !category.equals("Food")
                &&
                !category.equals("DYI")
        ) {
            System.out.println("Wrong category input");
            return false;
        } else {

            return true;
        }
    }

    boolean checkIfProductMatches(String productName) {
        boolean foundProduct = false;
        for (Product i : productInventory.keySet()) {
            if (i.getName().equalsIgnoreCase(productName)) {
                boughtProduct = i;
                foundProduct = true;
            }
        }
        return foundProduct;
    }
}
