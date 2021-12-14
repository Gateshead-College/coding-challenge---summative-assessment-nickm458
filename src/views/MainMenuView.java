package views;

import java.util.Scanner;

public class MainMenuView {
    public int displayMenu() {
        System.out.println("Welcome to Shoes R' Us, Please select an option from below:");
        System.out.println("1 - Check Stock");
        return Integer.parseInt(new Scanner(System.in).nextLine());
        }
    }

