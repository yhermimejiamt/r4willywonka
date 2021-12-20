package app.willywonkar4.repository;

import app.willywonkar4.Interface.InterfaceUser;
import app.willywonkar4.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Repository
public class RepositoryUser {

    @Autowired
    /**
     * Instancia hacia la Interface de usuario, utilizada para acceder y utilizar los metodos de dicha interface. 
     */
    private InterfaceUser userInterface;

    /**
     * Metodo utilizado para traer y mostrar una lista de usuarios de la base de datos.
     */
    public List<User> getAll() {
        return (List<User>) userInterface.findAll();
    }

    /**
     * Metodo utilizado para buscar usuarios de la base de datos por su atributo ID.
     */
    public Optional<User> getUser(int id) {
        return userInterface.findById(id);
    }

    /**
     *
     */
    public User createUser(User user) {
        return userInterface.save(user);
    }

    /**
     * Metodo utilizado para actualizar usuarios de la base de datos.
     */
    public void updateUser(User user) {
        userInterface.save(user);
    }

    /**
     * Metodo utilizado para borrar usuarios de la base de datos.
     */
    public void deleteUser(User user) {
        userInterface.delete(user);
    }

    /**
     * Metodo utilizado para comprobar si el email ingregado existe.
     */
    public boolean existEmail(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     * Metodo opcional utilizado para autenticar el email y la contraseña.
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userInterface.findByEmailAndPassword(email, password);
    }

    /**
     * Metodo que retorna el ultimo Id utilizado en la base de datos.
     */
    public Optional<User> lastUserId() {
        return userInterface.findTopByOrderByIdDesc();
    }

    /**
     * Metodo que retorna el mes de cumpleaños.
     */
    public List<User> getByMonthBirthtDay(String monthBirthDay) {
        return userInterface.findByMonthBirthtDay(monthBirthDay);
    }
}
