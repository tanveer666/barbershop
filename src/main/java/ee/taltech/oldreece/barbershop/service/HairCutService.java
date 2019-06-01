package ee.taltech.oldreece.barbershop.service;

import ee.taltech.oldreece.barbershop.model.HairCut;
import ee.taltech.oldreece.barbershop.repository.HairCutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairCutService {
    @Autowired
    private HairCutRepo hairCutRepo;

    public List<HairCut> showAllHairCut() {
        return hairCutRepo.findAll();
    }

    public HairCut getHairCutbyID(Long id)  {
        Optional<HairCut> hairCut = hairCutRepo.findById(id);
        return hairCut.get();
    }

    public void updateAHairCut(HairCut hairCut) {
        hairCutRepo.save(hairCut);
    }

    public void saveAHairCut(HairCut hairCut) {
        hairCut.setId(null);
        updateAHairCut(hairCut);
    }

    public void deleteHairCutByID(Long id) {
        hairCutRepo.deleteById(id);
    }

}
