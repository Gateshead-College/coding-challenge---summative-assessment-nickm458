package stock_check;

import java.io.*;
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

    /**
     *
     * @param stocks
     * @throws IOException
     */
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

    /**
     *
     * @param file
     * @return
     * @throws
     */
    public ArrayList<String> readFile(File file) {

        createFileIfNotExist();

        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
        } catch (IOException ioex) {
            System.out.println("Failed to read the file");
            ioex.printStackTrace();
        }
        return lines;
    }

    /**
     *
     * @param stockString
     * @return
     */

    private Stock getStockFromString(String stockString) {

        Stock s;

        String[] sd = stockString.split(",");
        s = new Stock(Integer.parseInt(sd[0],
                sd[1],
                Integer.parseInt(sd[3]),
                Integer.parseInt(sd[4])));
        return s;
    }

    /**
     *
     * @param stockStrings
     * @return stocks
     */
    public ArrayList<Stock> getStocks(ArrayList<String> stockStrings) {

        ArrayList<Stock> stocks = new ArrayList<>();
        for (String s : stockStrings) {
            stocks.add(getStockFromString(s));
        }
        return stocks;
    }
}
