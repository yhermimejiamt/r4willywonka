package app.willywonkar4.repository;

import app.willywonkar4.Interface.InterfaceChocolate;
import app.willywonkar4.model.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class RepositoryChocolate {

    @Autowired
    private InterfaceChocolate chocolateInterface;

    public List<Chocolate> getAll() {
        return chocolateInterface.findAll();
    }

    public Optional<Chocolate> getchocolate(String reference) {
        return chocolateInterface.findByReference(reference);
    }

    public Chocolate createChocolate(Chocolate chocolate) {
        return chocolateInterface.save(chocolate);
    }

    public void updateChocolate(Chocolate chocolate) {
        chocolateInterface.save(chocolate);
    }

    public void deleteChocolate(Chocolate chocolate) {
        chocolateInterface.delete(chocolate);
    }

  public List<Chocolate>getByPrice(double price){
       return chocolateInterface.findByPrice(price);
    }

    public List<Chocolate> getByDescriptionContainingIgnoreCase(String description) {
        return chocolateInterface.findByDescriptionContainingIgnoreCase(description);
    }


}
