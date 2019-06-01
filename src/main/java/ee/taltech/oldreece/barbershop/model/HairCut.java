package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class HairCut {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(length = 20)
    private String hairCutName;

    @Getter @Setter
    private Double hairCutPrice;


    public HairCut(String name, Double price) {
        hairCutName = name;
        hairCutPrice = price;
    }
}
