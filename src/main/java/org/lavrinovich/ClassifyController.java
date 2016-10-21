package org.lavrinovich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ClassifyController {

    @Autowired
    private Classificator classificator;


    @RequestMapping(value = {"/ClassifyNumber", "/ClassifyNumber/"}, method = RequestMethod.GET)
    public String processNumber(@RequestParam Map<String,String> allRequestParams, Map<String, Object> model){
        String number = allRequestParams.get("number");
        if (number == null){
            model.put("acceptNumberParam",false);
            return "/WEB-INF/views/classify.jsp";
        }
        model.put("acceptNumberParam",true);
        try {
            model.put("number", number);
            Integer n = Integer.valueOf(number);
            model.put("classification",classificator.classifyNumber(n));
            model.put("isNumber", true);
        } catch (Exception e){
            model.put("isNumber", false);
        }
        return "/WEB-INF/views/classify.jsp";
    }
}
