package com.rersdev.logisticapi.model.dtos;

import java.io.Serializable;

public record CustomerDTO(

        Long id,
        String name,
        String email,
        String phone

) implements Serializable {
}
