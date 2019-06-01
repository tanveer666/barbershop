package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/addDate")
@RestController
public class AddDateController {

    @GetMapping
    public List<ReservationDate> getAllTimeslots() {
        return null;
    }

    @PostMapping
    public boolean addATimeslot(@RequestBody ReservationDate reservationDate) {
        return false;
    }

    @PutMapping("{id}")
    public boolean updateATimeslot(@PathVariable Long id, @RequestBody ReservationDate reservationDate){
        return false;
    }

    @DeleteMapping("{id")
    public boolean deleteATimeslot(@PathVariable Long id){
        return false;
    }
}

