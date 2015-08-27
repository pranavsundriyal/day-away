package model;

/**
 * Created by psundriyal on 8/23/15.
 */
public class PriceDateModel {
    float price;
    String date;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public PriceDateModel(Float price, String date) {
        this.price = price;
        this.date = date;
    }
}
