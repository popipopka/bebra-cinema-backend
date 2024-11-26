package it.bebra.cinema.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "it.bebra.cinema.controller")
public class ControllerConfig {
}
