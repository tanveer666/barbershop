package ee.taltech.oldreece.barbershop.controllerTests;

import ee.taltech.oldreece.barbershop.model.ReservationDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DateControllerTest {

    private final ParameterizedTypeReference<List<ReservationDate>> LIST_OF_DATES = new ParameterizedTypeReference<List<ReservationDate>>() {

    };
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void returns_all_dates() {
        ResponseEntity<List<ReservationDate>> exchange= testRestTemplate.exchange("/date", HttpMethod.GET,null,LIST_OF_DATES);
        assertEquals(HttpStatus.OK,exchange.getStatusCode());
        List<ReservationDate> dates = exchange.getBody();
        assertNotNull(dates);
        assertEquals(dates.size(),4);
    }
}
