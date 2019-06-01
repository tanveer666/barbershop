package ee.taltech.oldreece.barbershop.controllers;

import ee.taltech.oldreece.barbershop.model.HairCut;
import ee.taltech.oldreece.barbershop.service.HairCutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/haircut")
public class HairCutController {
    @Autowired
    HairCutService hairCutService;

    @GetMapping
    public List<HairCut> getAllHairCut() {
        return hairCutService.showAllHairCut();
    }

    @GetMapping("{id}")
    public HairCut getHairCutByID(@PathVariable Long id) {
        return hairCutService.getHairCutbyID(id);
    }

    @PostMapping
    public boolean saveHairCut(@RequestBody HairCut hairCut) {
        hairCutService.saveAHairCut(hairCut);
        return true;
    }

    @PutMapping
    public boolean updateHairCut(@RequestBody HairCut hairCut) {
        hairCutService.updateAHairCut(hairCut);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deleteHairCut(@PathVariable Long id) {
        hairCutService.deleteHairCutByID(id);
        return true;
    }

}