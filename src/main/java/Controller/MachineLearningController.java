package Controller;

import model.AggregateModel;
import model.AverageDeviationModel;
import model.PriceDateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by psundriyal on 8/23/15.
 */
@RestController
public class MachineLearningController {
    @Autowired
    private ApplicationContext ctx;


    @RequestMapping("/getData")
    public @ResponseBody
    AggregateModel getData(@RequestParam(value="query", required=false, defaultValue="")String query, Model model) throws IOException{
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        System.out.print(query);
        Util util = new Util();
        priceDateModels = util.getModel(query);
        //todo use priceDateModels as sample set to compute other data points and them to model
        if (priceDateModels.size() == 0 || query== null){
            return null;
        }
        else
            return util.createAggregateModels(priceDateModels,query);
    }

    @RequestMapping("/getLowest")
    public @ResponseBody
    float getLowestPrice(@RequestParam(value="query", required=false, defaultValue="")String query, Model model) throws IOException{
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        System.out.print(query);
        Util util = new Util();
        priceDateModels = util.getModel(query);
        //todo use priceDateModels as sample set to compute other data points and them to model
        if (priceDateModels.size() == 0 || query== null){
            return 0;
        }
        else {
            AggregateModel aggregateModel = util.createAggregateModels(priceDateModels, query);
            return aggregateModel.getLowestPrice();
        }
    }

    @RequestMapping("/getAverageDeviation")
    public @ResponseBody
    AverageDeviationModel getAverageDeviation(@RequestParam(value="query", required=false, defaultValue="")String query, Model model) throws IOException{
        List<PriceDateModel> priceDateModels = new ArrayList<PriceDateModel>();
        System.out.print(query);
        Util util = new Util();
        priceDateModels = util.getModel(query);
        //todo use priceDateModels as sample set to compute other data points and them to model
        if (priceDateModels.size() == 0 || query== null){
            return null;
        }
        else {
            AggregateModel aggregateModel = util.createAggregateModels(priceDateModels, query);
            AverageDeviationModel averageDeviationModel = new AverageDeviationModel();
            averageDeviationModel.setAverage(aggregateModel.getAveragePrice());
            averageDeviationModel.setDeviation(aggregateModel.getMeanDeviation());
            return averageDeviationModel;
        }
    }
}
