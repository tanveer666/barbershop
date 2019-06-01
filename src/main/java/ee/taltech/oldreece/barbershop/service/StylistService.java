package ee.taltech.oldreece.barbershop.service;

import ee.taltech.oldreece.barbershop.model.Stylist;
import ee.taltech.oldreece.barbershop.repository.StylistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylistService {
    @Autowired
    private StylistRepo stylistRepo;

    public List<Stylist> getAllStylist() {
        return stylistRepo.findAll();
    }

    public boolean updateAStylist(Stylist stylist) {
        stylistRepo.save(stylist);
        return true;
    }

    public boolean addAStylist(Stylist stylist) {
        stylist.setId(null);
        stylistRepo.save(stylist);
        return true;
    }

    public boolean deleteAStylistByID(Long id) {
        stylistRepo.deleteById(id);
        return true;
    }

}

//TODO: Add service methods for creating, retreving , updating and deleting Stylists to the database