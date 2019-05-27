package ee.taltech.oldreece.barbershop.repository;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDateRepo extends JpaRepository<ReservationDate,Long> {
}


//Maybe add queries if JPA does not offer existing methods