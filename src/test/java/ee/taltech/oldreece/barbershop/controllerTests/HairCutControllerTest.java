package ee.taltech.oldreece.barbershop.controllerTests;

import ee.taltech.oldreece.barbershop.model.HairCut;
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
public class HairCutControllerTest {

    private final ParameterizedTypeReference<HairCut> HAIRCUT = new ParameterizedTypeReference<HairCut>() {

    };
    private final ParameterizedTypeReference<List<HairCut>> LIST_OF_HAIRCUT = new ParameterizedTypeReference<List<HairCut>>() {
    };
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void customer_returns_one_haircut() {
        ResponseEntity<HairCut> exchange = testRestTemplate.exchange("/haircut/6", HttpMethod.GET, null, HAIRCUT);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        HairCut hairCut = exchange.getBody();
        assertNotNull(hairCut);
        assertEquals(hairCut.getHairCutName(),"Shave");
    }

    @Test
    public void customer_returns_list_of_haircut() {
        ResponseEntity<List<HairCut>> exchange = testRestTemplate.exchange("/haircut", HttpMethod.GET, null, LIST_OF_HAIRCUT);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        List<HairCut> hairCutListairCutList = exchange.getBody();
        assertNotNull(hairCutListairCutList);
        assertFalse(hairCutListairCutList.isEmpty());
    }
}

