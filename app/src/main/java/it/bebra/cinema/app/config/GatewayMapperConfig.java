package it.bebra.cinema.app.config;

import it.bebra.cinema.gateway.mapper.TicketMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayMapperConfig {

    @Bean
    public TicketMapper gatewayTicketMapper() {
        return TicketMapper.INSTANCE;
    }
}
