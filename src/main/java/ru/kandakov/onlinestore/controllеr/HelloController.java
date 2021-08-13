package ru.kandakov.onlinestore.controllеr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/online-store")
    public String outputHello() {
        return "product/firstPage";
    }
}
