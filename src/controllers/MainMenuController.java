package controllers;

import views.MainMenuView;

public class MainMenuController {
    public void displayMenu() {
        MainMenuView mmv = new MainMenuView();
        handleChoice(mmv.displayMenu());
    }

    private void handleChoice(int selection) {
        switch (selection) {
            case 1:
                System.out.println("Check stocking stock for you now...");
                break;

            default:
                System.out.println("Invalid option provided, please try again.");
                displayMenu();
        }
        displayMenu();
    }
}
