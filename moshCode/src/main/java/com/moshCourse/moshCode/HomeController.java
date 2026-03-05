package com.moshCourse.moshCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//define this class as a controller, and spring will automatically create an instance of this class and manage its lifecycle
public class HomeController {
    
    @RequestMapping("/")//define the request to the root
    public String index(){
        String viewName = getViewName();
        System.out.println(viewName);
        return viewName;//return the name of the view to be rendered, and spring will automatically resolve the view and render it
    }

    private String getViewName() {
        return "index.html";//return the name of the view to be rendered, and spring will automatically resolve the view and render it
    }
}//in java all methods are in a class, and the main method is the entry point of the application, but in spring boot we don't need to define a main method, because spring boot will automatically create a main method for us and run the application.