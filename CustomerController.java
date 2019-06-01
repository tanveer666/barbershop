package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.Customer;
import ee.taltech.oldreece.barbershop.model.HairCut;
import ee.taltech.oldreece.barbershop.model.ReservationDate;
import ee.taltech.oldreece.barbershop.service.DateService;
import ee.taltech.oldreece.barbershop.service.HairCutService;
import ee.taltech.oldreece.barbershop.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private HairCutService hairCutService;
    @Autowired
    private DateService dateService;


    @PostMapping
    public boolean reserveATimeSlot(@RequestBody Customer customer) {
        return reservationService.reserveADate(customer);
    }

    @GetMapping("/dates")
    public List<ReservationDate> showAllFreeSlots() {
        return dateService.getAllFreeDates();
    }

    @GetMapping("/service")
    public List<HairCut> showAllHairCuts() {
        return hairCutService.showAllHairCut();
    }

    @GetMapping("/admin")
    public List<Customer> getAllCustomer() {
        return reservationService.getAllCustomer();
    }

    @GetMapping("/admin/{id}")
    public Customer getACustomer(@PathVariable Long id) {
        return reservationService.getCustomerByID(id);
    }

    @DeleteMapping("/admin/{id}")
    public boolean deleteACustomer(@PathVariable Long id) {
        return reservationService.deleteCustomerByID(id);
    }

    @PutMapping("/admin")
    public boolean updateACustomer( @RequestBody Customer customer) {
        return reservationService.updateCustomer(customer);
    }
}


 
