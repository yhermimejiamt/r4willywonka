
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
    private InterfaceUser userInterface;
    
    public List<User> getAll() {
        return (List<User>) userInterface.findAll();
    }

    public Optional<User> getUser(int id) {
        return userInterface.findById(id);
    }

    public User createUser(User user) {
        return userInterface.save(user);
    }
    
    public void updateUser(User user) {
        userInterface.save(user);
    }
    
    public void deleteUser(User user) {
        userInterface.delete(user);
    }

    public boolean existEmail(String email) {
        Optional<User> usuario = userInterface.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return userInterface.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
        return userInterface.findTopByOrderByIdDesc();
    }
}
