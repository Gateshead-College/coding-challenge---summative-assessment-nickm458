package stock_check;

public class Stock {

    public int stockID;
    public String manufacturer;
    public String productName;
    public double price;
    public int stockAmount;

    public Stock(int stockID, String manufacturer, String productName, double price, int stockAmount) {
        this.stockID = stockID;
        this.manufacturer = manufacturer;
        this.productName = productName;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public Stock(int stockID) {
    }
}

