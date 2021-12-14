package stock_check;

import views.MainMenuView;

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


    public void stockMenu() {
        addStock();
        System.out.println("Welcome to Shoes R' Us, Please select an option from below:");
        System.out.println("1 - Check Stock");
        handleChoice( Integer.parseInt(new Scanner(System.in).nextLine()));
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                checkStock();
                break;
            default:
                System.out.println("Invalid option provided, please try again.");
                displayMenu();
        }
    }
    public void displayMenu() {
        MainMenuView mmv = new MainMenuView();
        handleChoice((int) mmv.displayMenu());
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
                }

            }
        }
    }

}



