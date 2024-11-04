package it.bebra.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Authority {
    private Integer id;

    private String name;
}
