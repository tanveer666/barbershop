package ee.taltech.oldreece.barbershop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/haircut")
public class HairCutController {
}

/* TODO
* Add get mapping to show all available haircuts and other services.
* Add post mapping to add new services
* Add put mapping to update existing services
* Add delete mapping to delete services (by haircutID)
 */