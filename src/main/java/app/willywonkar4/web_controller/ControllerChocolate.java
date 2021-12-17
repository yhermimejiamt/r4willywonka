package app.willywonkar4.web_controller;

import app.willywonkar4.model.Chocolate;
import app.willywonkar4.service.ServiceChocolate;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Developer Yhermi Mejía Sarmiento
 */
@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin("*")
public class ControllerChocolate {

    @Autowired
    private ServiceChocolate chocolateService;

    @GetMapping("/all")
    public List<Chocolate> getAll() {
        return chocolateService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Chocolate> getchocolate(@PathVariable("reference") String reference) {
        return chocolateService.getchocolate(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate createChocolate(@RequestBody Chocolate chocolate) {
        return chocolateService.createChocolate(chocolate);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Chocolate updateChocolate(@RequestBody Chocolate chocolate) {
        return chocolateService.updateChocolate(chocolate);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteChocolate(@PathVariable("reference") String reference) {
        return chocolateService.deleteChocolate(reference);
    }
}
