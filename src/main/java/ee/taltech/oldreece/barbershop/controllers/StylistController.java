package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.Stylist;
import ee.taltech.oldreece.barbershop.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stylist")
public class StylistController {
    @Autowired
    StylistService stylistService;

    @GetMapping
    public List<Stylist> getAllStylist() {
        return stylistService.getAllStylist();
    }

    @PostMapping
    public boolean addAStylist(@RequestBody Stylist stylist) {
        return stylistService.addAStylist(stylist);
    }

    @DeleteMapping("{id}")
    public boolean deleteAStylistbyID(@PathVariable Long id) {
        return stylistService.deleteAStylistByID(id);
    }

    @PutMapping
    public boolean updateAStylist(Stylist stylist) {
        return stylistService.updateAStylist(stylist);
    }

}