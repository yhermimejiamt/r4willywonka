package app.willywonkar4.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")

public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;

    private Map<String, Chocolate> products;
    private Map<String, Integer> quantities;
}
