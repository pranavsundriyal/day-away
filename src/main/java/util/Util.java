package util;

import com.csvreader.CsvReader;
import model.AggregateModel;
import model.PriceDateModel;

import java.io.FileReader;
import java.io.IOException;

import java.util.*;

/**
 * Created by psundriyal on 8/25/15.
 */

public class Util {

    private static final float PRICE_MARGIN = 8;

    public List<PriceDateModel> getModel(String query) {
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        try {
            CsvReader reader = new CsvReader(new FileReader("src/main/resources/data/" + query + ".csv"), ',');
            reader.readHeaders();
            while (reader.readRecord()) {
                String price = reader.get("Price");
                String date = reader.get("Date");
                priceDateModels.add(new PriceDateModel(Float.parseFloat(price), date));

                // perform program logic here
            }
        } catch (IOException e) {
            System.out.print("not found");
            return priceDateModels;
        }
        return priceDateModels;
    }

    public AggregateModel createAggregateModels(List<PriceDateModel> priceDateModels, String query) {
        AggregateModel aggregateModel = new AggregateModel(priceDateModels);
        aggregateModel.setQuery(query);
        aggregateModel.setAveragePrice(calculateAveragePrice(priceDateModels));
        aggregateModel.setLowestPrice(calculateLowestPrice(priceDateModels));
        aggregateModel.setMedianPrice(calculateMedian(priceDateModels));
        aggregateModel.setMeanDeviation(calculateMeanDeviation(priceDateModels, aggregateModel.getAveragePrice()));
        aggregateModel.setLowerPriceLimit(aggregateModel.getAveragePrice() - aggregateModel.getMeanDeviation());
        aggregateModel.setUpperPriceLimit(aggregateModel.getAveragePrice() + aggregateModel.getMeanDeviation());
        if (aggregateModel.getUpperPriceLimit()> aggregateModel.getPriceDateModels().get(aggregateModel.getPriceDateModels().size()-1).getPrice())
            aggregateModel.setBuyToday(true);
        return aggregateModel;
    }

    private float calculateAveragePrice(List<PriceDateModel> priceDateModels) {
        float sum = 0;
        for (PriceDateModel priceDateModel : priceDateModels) {
            sum = sum + priceDateModel.getPrice();
        }
        return sum / priceDateModels.size();
    }

    private float calculateLowestPrice(List<PriceDateModel> priceDateModels) {
        float lowestprice = 100000000;
        for (PriceDateModel priceDateModel : priceDateModels) {
            if (priceDateModel.getPrice() < lowestprice)
                lowestprice = priceDateModel.getPrice();
        }
        return lowestprice;
    }

    private float calculateMedian(List<PriceDateModel> priceDateModels) {
        float [] sortprice = new float[priceDateModels.size()];
        int i=0;
        for(PriceDateModel priceDateModel : priceDateModels) {
            sortprice[i] = priceDateModel.getPrice();
            i++;
        }
        Arrays.sort(sortprice);
        return  sortprice[sortprice.length/2];
    }

    private float calculateMeanDeviation(List<PriceDateModel> priceDateModels, float mean) {
        float [] deviation = new float[priceDateModels.size()];
        int i =0;
        for (PriceDateModel priceDateModel : priceDateModels) {
            deviation[i] = Math.abs(priceDateModel.getPrice() - mean);
            i++;
        }
        float sum =0;
        for (int j =0; j<deviation.length;j++){
            sum = sum + deviation[j];
        }
        return sum/deviation.length;
    }
}
