package Controller;

import com.csvreader.CsvReader;
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
        System.out.print(query);
        model.addAttribute("priceDateModels", new Util().getModel(query));
            return "index";
    }
    
}
