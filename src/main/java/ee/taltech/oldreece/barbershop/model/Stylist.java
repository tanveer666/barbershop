package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Stylist {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(length = 60)
    private String stylistName;

}
