package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
public class ReservationDate {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private LocalDate reservationDate;

    @Getter @Setter
    private LocalTime reservationTime;

    @Getter @Setter
    private boolean isTakenByCustomer;

    @Getter @Setter
    private Long stylistID;

    public ReservationDate(LocalDate date, LocalTime time, boolean isTaken, Long id) {
        stylistID = id;
        reservationDate = date;
        reservationTime = time;
        isTakenByCustomer = isTaken;
    }
}
