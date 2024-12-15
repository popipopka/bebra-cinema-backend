package it.bebra.cinema.app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Конфигурационный файл для настройки JPA в Spring приложении.
 * <p>
 * Данный класс настраивает область поиска JPA репозиториев, используя аннотацию {@code @EnableJpaRepositories},
 * а также область поиска сущностей JPA через аннотацию {@code @EntityScan}
 */

@Configuration
@EnableJpaRepositories(basePackages = "it.bebra.cinema.database.spring.jpa.repository")
@EntityScan(basePackages = "it.bebra.cinema.database.spring.jpa.entity")
public class JpaConfig {
}
