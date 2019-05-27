package ee.taltech.oldreece.barbershop.repository;

import ee.taltech.oldreece.barbershop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}


//Maybe add queries if JPA does not offer existing methods
