package ee.taltech.oldreece.barbershop.repository;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DateRepo extends JpaRepository<ReservationDate,Long> {
    @Query(value = "SELECT * FROM ReservationDate RD WHERE RD.isTakenByCustomer = FALSE ;",nativeQuery = true)
    List<ReservationDate> getAllFreeDates();

    @Transactional
    @Modifying
    @Query(value = "UPDATE ReservationDate SET isTakenByCustomer = true WHERE id = :inputID ;",nativeQuery = true)
    void reserveADate(@Param("inputID") Long id);

    @Query(value = "SELECT isTakenByCustomer FROM ReservationDate WHERE id = :inputID ;",nativeQuery = true)
    boolean isDateTaken(@Param("inputID")Long id);


}


