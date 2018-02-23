package com.pipelines.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HomeController {  
	@Autowired
	ProductService productService;
    @RequestMapping("/")  
    public String index(){  
        return"index";  
    }  
    // this is to save your data from web input to mongodb
   
    @RequestMapping(value="/save", method=RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute ProductRecord productRecord){
    	productService.save(productRecord);
    
        ModelAndView modelAndView = new ModelAndView();  
modelAndView.setViewName("user-data");      
modelAndView.addObject("productRecord", productRecord);    
return modelAndView;  
    }  
    
    
    @RequestMapping("/displayAll")  
    public ModelAndView getAll(Model model){

      Map<String, Object> params = new HashMap<>();
        params.put("products", productService.getAll());

        return new ModelAndView("displayAll", params);
    }  
    
}