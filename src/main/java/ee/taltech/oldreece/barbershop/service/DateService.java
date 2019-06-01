package ee.taltech.oldreece.barbershop.service;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import ee.taltech.oldreece.barbershop.repository.DateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DateService {
    @Autowired
    private DateRepo dateRepo;

    public List<ReservationDate> getAllDates() {
        return dateRepo.findAll();
    }

    public ReservationDate getDatebyID(Long id) throws NullPointerException {
        Optional<ReservationDate> reservationDate = dateRepo.findById(id);

        if (reservationDate.isPresent()) {
            return reservationDate.get();
        } else throw new NullPointerException();
    }

    public boolean addADate(ReservationDate reservationDate) {
        reservationDate.setId(null);
        dateRepo.save(reservationDate);
        return true;
    }

    public boolean updateADate(ReservationDate reservationDate) {
        dateRepo.save(reservationDate);
        return true;
    }

    public boolean removeDateByID(Long id) {
        dateRepo.deleteById(id);
        return true;
    }


    public List<ReservationDate> getAllFreeDates() {
        return dateRepo.getAllFreeDates();
    }

    public boolean reserveADate(Long id) {
        return dateRepo.reserveADate(id);
    }

    public boolean isDateTaken(Long id) {
        return dateRepo.isDateTaken(id);
    }


}


