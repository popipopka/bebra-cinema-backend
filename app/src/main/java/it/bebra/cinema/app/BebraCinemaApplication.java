package it.bebra.cinema.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "it.bebra.cinema")
public class BebraCinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BebraCinemaApplication.class, args);
    }
}
