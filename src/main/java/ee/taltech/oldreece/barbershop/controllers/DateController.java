package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import ee.taltech.oldreece.barbershop.service.DateService;
import ee.taltech.oldreece.barbershop.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/date")
@RestController
public class DateController {
    @Autowired
    private DateService dateService;

    @GetMapping
    public List<ReservationDate> showAllDates() {
        return dateService.getAllDates();
    }

    @PostMapping
    public boolean addADate(@RequestBody ReservationDate reservationDate) {
        return dateService.addADate(reservationDate);
    }

    @PutMapping
    public boolean updateADate(@RequestBody ReservationDate reservationDate) {
        return dateService.updateADate(reservationDate);
    }

    @DeleteMapping("{id}")
    public boolean deleteADatebyID(@PathVariable Long id) {
        return dateService.removeDateByID(id);
    }

}
