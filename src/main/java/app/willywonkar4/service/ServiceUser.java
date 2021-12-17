package app.willywonkar4.service;

import app.willywonkar4.model.User;
import app.willywonkar4.repository.RepositoryUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {

        return userRepository.getUser(id);
    }

    public User createUser(User user) {

        //obtiene el maximo id existente en la coleccion
        Optional<User> userIdMaximo = userRepository.lastUserId();

        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty()) {
                user.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }

        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail()) == false) {
                return userRepository.createUser(user);
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    public User updateUser(User user) {

        if (user.getId() != null) {
            Optional<User> optionUser = userRepository.getUser(user.getId());
            if (!optionUser.isEmpty()) {
                if (user.getIdentification() != null) {
                    optionUser.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    optionUser.get().setName(user.getName());
                }
                if (user.getBirthtDay() != null) {
                    optionUser.get().setBirthtDay(user.getBirthtDay());
                }
                if (user.getMonthBirthtDay()!= null) {
                    optionUser.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if (user.getAddress() != null) {
                    optionUser.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    optionUser.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    optionUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    optionUser.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    optionUser.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    optionUser.get().setType(user.getType());
                }
                userRepository.updateUser(optionUser.get());
                return optionUser.get();
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    public boolean deleteUser(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.deleteUser(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.existEmail(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}
