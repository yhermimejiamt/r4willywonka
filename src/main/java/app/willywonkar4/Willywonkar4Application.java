package app.willywonkar4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.willywonkar4.Interface.InterfaceChocolate;
import app.willywonkar4.Interface.InterfaceOrder;
import app.willywonkar4.Interface.InterfaceUser;

@SpringBootApplication
public class Willywonkar4Application implements CommandLineRunner {

    @Autowired
    private InterfaceUser userInterface;
    @Autowired
    private InterfaceChocolate chocolateInterface;
    @Autowired
    private InterfaceOrder orderInterface;

    public static void main(String[] args) {
        SpringApplication.run(Willywonkar4Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        //userInterface.deleteAll();
        //chocolateInterface.deleteAll();
        //orderInterface.deleteAll();
        
    }
}
