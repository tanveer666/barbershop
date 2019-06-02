package ee.taltech.oldreece.barbershop.controllerTests;

import ee.taltech.oldreece.barbershop.model.HairCut;
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
public class CustomerControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private final ParameterizedTypeReference<List<ReservationDate>> LIST_OF_DATES = new ParameterizedTypeReference<List<ReservationDate>>() {

    };

    private final ParameterizedTypeReference<List<HairCut>> LIST_OF_HAIRCUT = new ParameterizedTypeReference<List<HairCut>>() {
    };

    @Test
    public void customer_returns_list_date() {
        ResponseEntity<List<ReservationDate>> response = testRestTemplate.exchange("/customer/dates", HttpMethod.GET,null,LIST_OF_DATES);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<ReservationDate> dates = response.getBody();
        assertNotNull(dates);
        assertFalse(dates.isEmpty());
    }

    @Test
    public void customer_returns_list_service() {
        ResponseEntity<List<HairCut>> response = testRestTemplate.exchange("/customer/service", HttpMethod.GET,null,LIST_OF_HAIRCUT);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<HairCut> dates = response.getBody();
        assertNotNull(dates);
        assertFalse(dates.isEmpty());
    }
}
