package stock_check;

import java.util.Scanner;

public class CheckStock {
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        CurrentStock cs = new CurrentStock();
        cs.stockMenu();
    }
}
