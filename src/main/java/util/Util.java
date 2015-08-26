package util;

import com.csvreader.CsvReader;
import model.AggregateModel;
import model.PriceDateModel;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by psundriyal on 8/25/15.
 */

public class Util {

    private static final float PRICE_MARGIN=8;
    public List<PriceDateModel> getModel(String query) {
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        try {
            CsvReader reader = new CsvReader(new FileReader("src/main/resources/data/" + query + ".csv"), ',');
            reader.readHeaders();
            while (reader.readRecord()) {
                String price = reader.get("Price");
                String date = reader.get("Date");
                priceDateModels.add(new PriceDateModel(Float.parseFloat(price), date,getDaysOut(date)));

                // perform program logic here
            }
        }catch (IOException e){
            System.out.print("not found");
            return priceDateModels;
        }
        return priceDateModels;
    }

    public AggregateModel createAggregateModels(List<PriceDateModel> priceDateModels) {
        AggregateModel aggregateModel = new AggregateModel(priceDateModels);
        aggregateModel.setAveragePrice(calculateAveragePrice(priceDateModels));
        aggregateModel.setLowestPrice(calculateLowestPrice(priceDateModels));
        aggregateModel.setLowerPriceLimit(aggregateModel.getAveragePrice()-(aggregateModel.getAveragePrice()*PRICE_MARGIN/100));
        aggregateModel.setUpperPriceLimit(aggregateModel.getAveragePrice()+(aggregateModel.getAveragePrice()*PRICE_MARGIN/100));
        return aggregateModel;
    }

    private float calculateAveragePrice(List<PriceDateModel> priceDateModels){
        float sum = 0;
        for(PriceDateModel priceDateModel : priceDateModels){
            sum = sum + priceDateModel.getPrice();
        }
        return sum/priceDateModels.size();
    }

    private float calculateLowestPrice(List<PriceDateModel> priceDateModels){
        float lowestprice= 100000000;
        for(PriceDateModel priceDateModel : priceDateModels){
            if (priceDateModel.getPrice()<lowestprice)
                lowestprice=priceDateModel.getPrice();
        }
        return lowestprice;
    }

    private int getDaysOut(String date) {
        String [] d = date.split("/");
        int month = Integer.parseInt(d[0]);
        int day = Integer.parseInt(d[1]);
        int year = Integer.parseInt(d[2]);
        Date datesearched = new Date(2015,month,day,0,0,0);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        int currentMonth = dateobj.getMonth();
        int currentDay = dateobj.getDay();
        return 0;
    }
}
