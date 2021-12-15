package stock_check;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrentStock {

    Scanner scn = new Scanner(System.in);

    Stock[] stocks = new Stock[6];

    void addStock() {
        stocks[0] = new Stock(111, "Nike", "Air Force One", 95, 50);
        stocks[1] = new Stock(112, "Nike", "Air Max 90", 80, 200);
        stocks[2] = new Stock(113, "Nike", "Air Max 95", 160, 25);
        stocks[3] = new Stock(114, "Nike", "Air Max 97", 185, 15);
        stocks[4] = new Stock(115, "Adidas", "Ozuwego", 65, 100);
        stocks[5] = new Stock(115, "Adidas", "Stan Smiths", 50, 150);
    }

    private ArrayList<Stock> stock = new ArrayList<Stock>();
    ArrayList<String> guestList = new ArrayList<String>();


    public void stockMenu() {
        addStock();
        System.out.println("Welcome to Shoes R' Us, Please select an option from below:");
        System.out.println("1 - Check stock");
        System.out.println("2 - Edit current product");
        System.out.println("3 - Add stock");
        System.out.println("4 - Remove stock");
        System.out.println("5 - Add new item");
        System.out.println("6 - Remove an item");
        System.out.println("7 - View list of stock");
        handleChoice(Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                checkStock();
                break;
            case 2:
                editProduct();
                break;
            case 3:
                editStock();
                break;
            case 4:
                removeStock();
                break;
            case 5:
                addNewItem();
                break;
            case 6:
                removeItem();
                break;
            case 7:
                viewStock();
                break;
            default:
                System.out.println("Invalid option provided, please try again.");
                stockMenu();
        }
    }


    private void viewStock() {
        for (Stock s : stocks) {
            System.out.println("ID: " + s.stockID + " - Manufacturer: " + s.manufacturer + " - Name: " + s.productName
            + " - Price: " + s.price + " - Current Stock: " +s.stockAmount);
        }
    }

    private void editProduct() {
    }

    private void editStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which item are you looking to add stock to?");
        String stockID = scn.nextLine();
        for (Stock s : stocks) {
            if (s.productName.equalsIgnoreCase(stockID)) {
                System.out.println("How many more items would you like to add?");
                String num1 = scn.nextLine();
                System.out.println(Integer.parseInt(num1) + (s.stockAmount));
                stockMenu();
            }
        }
    }

    private void removeStock() {
        System.out.println("What item would you like to remove stock from?");
        String stockID = scn.nextLine();
        for (Stock s : stocks) {
            if (s.productName.equalsIgnoreCase(stockID)) {
                System.out.println("How much stock would you like to remove? (Please enter a minus before the number)");
                String num2 = scn.nextLine();
                System.out.println(Integer.parseInt(num2) + (s.stockAmount));
                stockMenu();
            }
        }
    }

    private void addNewItem() {
        System.out.println("Please enter the new products details.");
        System.out.println("Stock ID:");
        int stockID = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Product Manufacturer:");
        String manufacturer = new Scanner(System.in).nextLine();
        System.out.println("Product name:");
        String productName = new Scanner(System.in).nextLine();
        System.out.println("Product price:");
        double price = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Stock quantity:");
        int stockAmount = Integer.parseInt(new Scanner(System.in).nextLine());
        stocks.add(new Stock(stockID, manufacturer, productName, price, stockAmount));
    }

    private void removeItem() {
        System.out.println("Please select the item you want to remove:");
        int count = 1;
        for (Stock s : stocks) {
            System.out.println(count + " - " + s.productName);
            count++;
        }
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        stocks.remove(choice - 1);
    }


    private void checkStock() {
        System.out.println("What is the name the product you would like to check for?");
        String product = scn.nextLine();
        if (stocks[0] != null) {
            for (Stock s : stocks) {
                if (s.productName.equalsIgnoreCase(product)) {
                    System.out.println("We currently stock: " + s.productName);
                    System.out.println("Product information:");
                    System.out.println("Stock ID: " + s.stockID + ", Manufacturer: " + s.manufacturer + ", Price: £"
                            + s.price + ", Stock amount:" + s.stockAmount);
                    stockMenu();

                }
            }
        }
    }

}



