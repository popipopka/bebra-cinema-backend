package it.bebra.cinema.application.dto.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HallData {
    private int id;

    private String name;

    private int capacity;
}
