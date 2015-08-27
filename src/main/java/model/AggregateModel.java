package model;

import java.util.List;

/**
 * Created by psundriyal on 8/25/15.
 */
public class AggregateModel {
    List<PriceDateModel> priceDateModels;
    float lowestPrice;
    float averagePrice;
    float medianPrice;
    float lowerPriceLimit;
    float upperPriceLimit;
    float meanDeviation;
    boolean buyToday;
    String query;

    public AggregateModel(List<PriceDateModel> priceDateModels) {
        this.priceDateModels = priceDateModels;
    }

    public List<PriceDateModel> getPriceDateModels() {
        return priceDateModels;
    }

    public void setPriceDateModels(List<PriceDateModel> priceDateModels) {
        this.priceDateModels = priceDateModels;
    }

    public float getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(float lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public float getMedianPrice() {
        return medianPrice;
    }

    public void setMedianPrice(float medianPrice) {
        this.medianPrice = medianPrice;
    }

    public float getLowerPriceLimit() {
        return lowerPriceLimit;
    }

    public void setLowerPriceLimit(float lowerPriceLimit) {
        this.lowerPriceLimit = lowerPriceLimit;
    }

    public float getUpperPriceLimit() {
        return upperPriceLimit;
    }

    public void setUpperPriceLimit(Float upperPriceLimit) {
        this.upperPriceLimit = upperPriceLimit;
    }

    public boolean isBuyToday() {
        return buyToday;
    }

    public void setBuyToday(boolean buyToday) {
        this.buyToday = buyToday;
    }

    public void setUpperPriceLimit(float upperPriceLimit) {
        this.upperPriceLimit = upperPriceLimit;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

    public float getMeanDeviation() {
        return meanDeviation;
    }

    public void setMeanDeviation(float meanDeviation) {
        this.meanDeviation = meanDeviation;
    }




}
