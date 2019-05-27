package ee.taltech.oldreece.barbershop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class indexController {
    @GetMapping
    public String greeting() {
        return "Welcome to Reece's Hair and Facial Studio";
    }
}
