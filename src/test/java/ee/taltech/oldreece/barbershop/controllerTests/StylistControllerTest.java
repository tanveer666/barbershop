package ee.taltech.oldreece.barbershop.controllerTests;


import ee.taltech.oldreece.barbershop.model.Stylist;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StylistControllerTest {

    private final ParameterizedTypeReference<List<Stylist>> STYLIST = new ParameterizedTypeReference<List<Stylist>>() {
    };
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void customer_returns_one_haircut() {
        ResponseEntity<List<Stylist>> response = testRestTemplate.exchange("/stylist", HttpMethod.GET, null, STYLIST);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<Stylist> stylists = response.getBody();
        assertNotNull(stylists);
        assertEquals(stylists.size(), 3);
    }
}
