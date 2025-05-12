package com.simsys.warehouse.responsedto;

import java.util.UUID;

public class VariantResponseDto {
    private final Long id;
    private final UUID guid;
    private final String color;
    private final String size;

    public VariantResponseDto(Long id, UUID guid, String color, String size) {
        this.id = id;
        this.guid = guid;
        this.color = color;
        this.size = size;
    }

    // Getters only

    public Long getId() {
        return id;
    }

    public UUID getGuid() {
        return guid;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }
}
