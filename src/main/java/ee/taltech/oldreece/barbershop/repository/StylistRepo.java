package ee.taltech.oldreece.barbershop.repository;

import ee.taltech.oldreece.barbershop.model.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylistRepo extends JpaRepository<Stylist,Long> {
}


//Maybe add queries if JPA does not offer existing methods