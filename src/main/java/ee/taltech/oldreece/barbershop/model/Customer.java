package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(length = 60)
    private String customerName;

    @Getter @Setter
    private Long phoneNum;

    @Getter @Setter
    private Long hairCutID;

    @Getter @Setter
    private Long reservationDateID;

}
