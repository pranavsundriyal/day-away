package Controller;

import com.csvreader.CsvReader;
import model.PriceDateModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psundriyal on 8/23/15.
 */
@RestController
public class MachineLearningController {

    @RequestMapping("/getData")
    public @ResponseBody
    List getData(String name, Model model) throws IOException{
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        CsvReader reader = new CsvReader(new FileReader("/Users/psundriyal/Desktop/DayAway/gs-spring-boot/day-away/src/main/java/Controller/ORD-BOM-DEC.csv"), ',' );
        reader.readHeaders();
        while (reader.readRecord())
        {
            String price = reader.get("Price");
            String date = reader.get("Date");
            priceDateModels.add(new PriceDateModel(price,date));
        }
        //todo use priceDateModels as sample set to compute other data points and them to model
        return priceDateModels;

    }
}
