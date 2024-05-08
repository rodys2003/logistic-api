package com.rersdev.logisticapi.model.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public record OrderDTO(

        Long id,
        String orderNumber,
        LocalDateTime orderDate,
        LocalDateTime deliveryDate,
        String status,
        CustomerDTO customer

        ) implements Serializable {

}
