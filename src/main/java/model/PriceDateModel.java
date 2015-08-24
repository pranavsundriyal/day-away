package model;

/**
 * Created by psundriyal on 8/23/15.
 */
public class PriceDateModel {
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String price;
    String date;

    public PriceDateModel(String price, String date) {
        this.price = price;
        this.date = date;
    }
}
