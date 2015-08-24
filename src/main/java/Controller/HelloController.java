package Controller;

import com.csvreader.CsvReader;
import model.PriceDateModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    
    @RequestMapping("/")
    public String index(@RequestParam(value="query", required=false, defaultValue="ORD-BOM")String query, Model model) throws IOException{
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        CsvReader reader = new CsvReader(new FileReader("/Users/psundriyal/Desktop/DayAway/gs-spring-boot/day-away/src/main/java/Controller/ORD-BOM-DEC.csv"), ',' );
        reader.readHeaders();
        while (reader.readRecord())
        {
            String price = reader.get("Price");
            String date = reader.get("Date");
            priceDateModels.add(new PriceDateModel(price,date));
            // perform program logic here
        }
        model.addAttribute("priceDateModels", priceDateModels);
        return "index";
    }
    
}
