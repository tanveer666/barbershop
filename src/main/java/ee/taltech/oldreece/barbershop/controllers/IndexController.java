package ee.taltech.oldreece.barbershop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String greeting() {
        return "index.html";
    }
}
