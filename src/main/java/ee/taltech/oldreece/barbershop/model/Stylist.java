package ee.taltech.oldreece.barbershop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Stylist {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(length = 60)
    private String stylistName;

    public Stylist (String name) {
        stylistName = name;
    }

}
