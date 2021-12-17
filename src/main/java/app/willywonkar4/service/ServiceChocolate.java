package app.willywonkar4.service;

import app.willywonkar4.model.Chocolate;
import app.willywonkar4.repository.RepositoryChocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Service
public class ServiceChocolate {

    @Autowired
    private RepositoryChocolate chocolateRepository;

    public List<Chocolate> getAll() {
        return chocolateRepository.getAll();
    }

    public Optional<Chocolate> getchocolate(String reference) {
        return chocolateRepository.getchocolate(reference);
    }

    public Chocolate createChocolate(Chocolate chocolate) {
        if (chocolate.getReference() == null) {
            return chocolate;
        } else {
            return chocolateRepository.createChocolate(chocolate);
        }
    }

    public Chocolate updateChocolate(Chocolate chocolate) {

        if (chocolate.getReference() != null) {
            Optional<Chocolate> chocolateDb = chocolateRepository.getchocolate(chocolate.getReference());
            if (!chocolateDb.isEmpty()) {

                if (chocolate.getCategory() != null) {
                    chocolateDb.get().setCategory(chocolate.getCategory());
                }

                if (chocolate.getDescription() != null) {
                    chocolateDb.get().setDescription(chocolate.getDescription());
                }
                if (chocolate.getPrice() != 0.0) {
                    chocolateDb.get().setPrice(chocolate.getPrice());
                }
                if (chocolate.getQuantity() != 0) {
                    chocolateDb.get().setQuantity(chocolate.getQuantity());
                }
                if (chocolate.getPhotography() != null) {
                    chocolateDb.get().setPhotography(chocolate.getPhotography());
                }
                chocolateDb.get().setAvailability(chocolate.isAvailability());
                chocolateRepository.updateChocolate(chocolateDb.get());
                return chocolateDb.get();
            } else {
                return chocolate;
            }
        } else {
            return chocolate;
        }
    }

    public boolean deleteChocolate(String reference) {
        Boolean aBoolean = getchocolate(reference).map(chocolate -> {
            chocolateRepository.deleteChocolate(chocolate);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
