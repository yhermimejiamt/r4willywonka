package app.willywonkar4.Interface;

import app.willywonkar4.model.Chocolate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceChocolate extends MongoRepository<Chocolate, String> {

    Optional<Chocolate> findByReference(String reference);

    List<Chocolate> findByPrice(double price);

    List<Chocolate> findByDescriptionContainingIgnoreCase(String description);
    
    
}
