package ee.taltech.oldreece.barbershop.repository;

import ee.taltech.oldreece.barbershop.model.HairCut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairCutRepo extends JpaRepository<HairCut,Long> {
}

