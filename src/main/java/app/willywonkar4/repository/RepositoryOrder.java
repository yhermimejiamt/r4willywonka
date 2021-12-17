package app.willywonkar4.repository;

import app.willywonkar4.Interface.InterfaceOrder;
import app.willywonkar4.model.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository

public class RepositoryOrder {

    @Autowired
    private InterfaceOrder orderInterface;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderInterface.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderInterface.findById(id);
    }

    public Order createOrder(Order order) {
        return orderInterface.save(order);
    }

    public void updateOrder(Order order) {
        orderInterface.save(order);
    }

    public void deleteOrder(Order order) {
        orderInterface.delete(order);
    }

    public Optional<Order> lastUserId() {
        return orderInterface.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return orderInterface.findByZone(zona);
    }

    // Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query() {
        };

        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;

    }

    //Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(criterio);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }

    //Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);

        return orders;
    }
}
