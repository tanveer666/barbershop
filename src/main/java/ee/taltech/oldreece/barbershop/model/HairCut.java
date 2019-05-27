package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class HairCut {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(length = 20)
    private String hairCutName;

    @Getter @Setter
    private Double hairCutPrice;

}
