package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.Customer;
import ee.taltech.oldreece.barbershop.model.HairCut;
import ee.taltech.oldreece.barbershop.model.ReservationDate;
import ee.taltech.oldreece.barbershop.service.DateService;
import ee.taltech.oldreece.barbershop.service.HairCutService;
import ee.taltech.oldreece.barbershop.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public double reserveATimeSlot(@RequestBody Customer customer) throws ResponseStatusException {
        Long hairCutID = customer.getHairCutID();
        Long dateID = customer.getReservationDateID();

        if (!dateService.isDateTaken(dateID)) {
            reservationService.reserveADate(customer);
            dateService.reserveADate(dateID);
            return hairCutService.getHairCutbyID(hairCutID).getHairCutPrice();

        }
        else throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
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
    public boolean updateACustomer(@RequestBody Customer customer) {
        return reservationService.updateCustomer(customer);
    }
}


 
