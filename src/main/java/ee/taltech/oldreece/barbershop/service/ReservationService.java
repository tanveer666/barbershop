package ee.taltech.oldreece.barbershop.service;

import ee.taltech.oldreece.barbershop.model.Customer;
import ee.taltech.oldreece.barbershop.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private CustomerRepo customerRepo;

    public boolean reserveADate(Customer customer) {
        customer.setId(null);
        customerRepo.save(customer);
        return true;
    }

    public List<Customer> getAllCustomer() {
        return customerRepo.findAll();
    }

    public Customer getCustomerByID(Long id) throws NullPointerException {
        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isPresent())
            return customer.get();
        else
            throw new NullPointerException();
    }

    public boolean updateCustomer(Customer customer) {
        customerRepo.save(customer);
        return true;
    }

    public boolean deleteCustomerByID(Long id) {
        customerRepo.deleteById(id);
        return true;
    }
}

//TODO: Joyon: Add service methods for creating, retreving , updating and deleting customer to the database