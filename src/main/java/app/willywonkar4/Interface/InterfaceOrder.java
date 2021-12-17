package app.willywonkar4.Interface;

import app.willywonkar4.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {

    //Lista todas las ordenes de la zona a la que esta asociada el cordinador
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    //Lista las ordenes y su estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //Regresa la ultima orden por id
    Optional<Order> findTopByOrderByIdDesc();
}
