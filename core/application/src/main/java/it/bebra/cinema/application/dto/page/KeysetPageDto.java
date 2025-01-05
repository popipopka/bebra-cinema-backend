package it.bebra.cinema.application.dto.page;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class KeysetPageDto<T> {
    private List<T> items;

    private Map<String, Object> cursors;

    private boolean hasMore;
}
