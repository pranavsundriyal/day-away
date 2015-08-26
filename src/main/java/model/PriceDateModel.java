package model;

/**
 * Created by psundriyal on 8/23/15.
 */
public class PriceDateModel {
    int daysOut;
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

    public int getDaysOut() {
        return daysOut;
    }

    public void setDaysOut(int daysOut) {
        this.daysOut = daysOut;
    }


    public PriceDateModel(Float price, String date, int daysOut) {
        this.price = price;
        this.date = date;
        this.daysOut =daysOut;
    }
}
