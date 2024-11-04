package it.bebra.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class Ticket {
    private Integer id;

    private Session session;

    private User user;

    private int row;

    private int place;

    private double totalPrice;
}
