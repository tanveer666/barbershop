package ee.taltech.oldreece.barbershop;

import ee.taltech.oldreece.barbershop.model.HairCut;
import ee.taltech.oldreece.barbershop.model.ReservationDate;
import ee.taltech.oldreece.barbershop.model.Stylist;
import ee.taltech.oldreece.barbershop.repository.DateRepo;
import ee.taltech.oldreece.barbershop.repository.HairCutRepo;
import ee.taltech.oldreece.barbershop.repository.ReservationDateRepo;
import ee.taltech.oldreece.barbershop.repository.StylistRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@SpringBootApplication
public class BarbershopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbershopApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(StylistRepo stylistRepo, DateRepo dateRepo, HairCutRepo hairCutRepo) {
        return args -> {
            LocalDate date1 = LocalDate.of(2019,6,14);
            LocalTime time1 = LocalTime.of(11,0);
            LocalTime time2 = LocalTime.of(13,0);
            LocalTime time3 = LocalTime.of(14,0);
            LocalTime time4 = LocalTime.of(16,0);

            dateRepo.save(new ReservationDate(date1,time1,false, (long) 1));
            dateRepo.save(new ReservationDate(date1,time2,true, (long) 2));
            dateRepo.save(new ReservationDate(date1,time3,false, (long) 1));
            dateRepo.save(new ReservationDate(date1,time4,false, (long) 3));


            hairCutRepo.save( new HairCut("Hair Cut",19.99));
            hairCutRepo.save(new HairCut("Shave", 9.99));
            hairCutRepo.save(new HairCut(("Hair Cut + Shave"), 29.99));

            stylistRepo.save( new Stylist("Jack Ryan"));
            stylistRepo.save(new Stylist("Viktor Reznov"));
            stylistRepo.save(new Stylist("Soap Mactavish"));

        };


    }

}
