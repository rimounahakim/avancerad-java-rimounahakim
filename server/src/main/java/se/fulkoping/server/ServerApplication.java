package se.fulkoping.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Detta är huvudklassen för servern
// SpringBoot startar applikationen härifrån
@SpringBootApplication
public class ServerApplication {

    // Main metoden är startpunkten för Java programmet
    // Här startas hela SpringBoot servern
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
