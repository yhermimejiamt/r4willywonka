package app.willywonkar4.web_controller;

import app.willywonkar4.model.User;
import app.willywonkar4.service.ServiceUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Engineer Yhermi Mejía Sarmiento
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerUser {

    @Autowired
    /**
     * Instancia de clase ServiceUser
     *
     * @param WebUser in this space start code..
     */
    private ServiceUser userService;

    @GetMapping("/all")
    /**
     * Metodo para listar usuarios
     *
     * @param Trae los usuarios que encuentre en la base de datos para listarlos
     *
     * @return Lista de usuarios
     */
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    /**
     * Metodo para identificar un usuario.
     *
     * @param Se utiliza para identificar usuarios.
     *
     * @return el usuario.
     */
    public Optional<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    /**
     * Metodo para crear un usuario.
     *
     * @param Se utiliza para crear usuarios y agregarlos a la base de datos.
     *
     * @return el usuario.
     */
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    /**
     * Metodo para actualizar un usuario.
     *
     * @param Se utiliza para actualizar usuarios y agregarlos a la base de
     * datos.
     *
     * @return el usuario.
     */
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    /**
     * Metodo para buscarpor id un usuario.
     *
     * @param Se utiliza para buscar usuarios.
     *
     * @return el usuario.
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/{email}/{password}")
    /**
     * Metodo para validar si existe el correo ingresado en la DB.
     *
     * @param El email que se valida es el del login.
     *
     * @return Si existe en la DB, retorna true, de lo contrario false.
     */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    @GetMapping("/emailexist/{email}")
    /**
     * Metodo para autenticar el email y la contraseña.
     *
     * @param Se utiliza validar los parametros mencionados y dirigir a la Main,
     * en caso de ser true..
     *
     * @return true or false.
     */
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
    
    @GetMapping("/birthday/{monthBirthDay}")
        public List<User>getByMonthBirthtDay(@PathVariable("monthBirthDay")String monthBirthDay){
            return userService.getByMonthBirthDay(monthBirthDay);
        }
}
