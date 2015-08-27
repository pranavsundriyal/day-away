package Controller;

import com.csvreader.CsvReader;
import model.AggregateModel;
import model.PriceDateModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import util.Util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DefaultController {
    
    @RequestMapping("/")
    public String index(@RequestParam(value="query", required=false, defaultValue="ORD-BOM-DEC")String query, Model model) throws IOException{
        Util util =new Util();
        List<PriceDateModel> priceDateModels = util.getModel(query);
        //todo use priceDateModels as sample set to compute other data points and them to model

        if (priceDateModels.size() == 0 || query== null) {
            AggregateModel aggregateModel = new AggregateModel(priceDateModels);
            model.addAttribute("aggregateModel", aggregateModel);
        }
        else
            model.addAttribute("aggregateModel", util.createAggregateModels(priceDateModels,query));
        return "index";
    }
    
}
