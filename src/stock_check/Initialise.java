package stock_check;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Initialise {

    static File stocksFile = new File("C:/Users/Nick1/Desktop/Products.txt");

    public void createFileIfNotExist() {
        try {
            if (!stocksFile.isFile()) {
                stocksFile.createNewFile();
            }
        } catch (IOException ioEx) {
            System.out.println("Encountered an error trying to create text file");
            ioEx.printStackTrace();
        }
    }

    public static void writeData(ArrayList<Stock> stocks) {
        try {
            FileWriter writer = new FileWriter(stocksFile);

            for (Stock s : stocks) {

                writer.write(s.stockID + "," + s.manufacturer + "," + s.productName
                        + "," + s.price + "," + s.stockAmount);

                writer.write("/n");
            }
            writer.close();
        } catch (IOException ioex) {
            System.out.println("Failed to write to file");
            ioex.printStackTrace();

        }
    }
}
