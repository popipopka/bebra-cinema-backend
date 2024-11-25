package it.bebra.cinema.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "it.bebra.cinema.database")
@EntityScan(basePackages = "it.bebra.cinema.database")
public class JpaConfig {
}
