package com.sunrise.dental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
        public String home(){
            return "redirect:/dashboard";

    }
    @GetMapping("/dashboard")
    public String Dashboard(){
        return "dashboard";
    }

    @GetMapping("/help")
    public String help(){
        return "help";
    }
}
