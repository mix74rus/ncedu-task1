package org.lavrinocich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Mix74rus on 20.10.16.
 */
@Controller
public class ClassifyController {

    @Autowired
    Classificator classificator;

    @RequestMapping("/Test/{number}")
    public String processNumber(@PathVariable String number, Map<String, Object> model){
        return "/WEB-INF/views/SimpleJSP.jsp";
    }
}
