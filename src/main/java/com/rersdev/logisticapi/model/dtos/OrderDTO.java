package com.rersdev.logisticapi.model.dtos;

import com.rersdev.logisticapi.model.entities.Customer;

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
    public static Object fromFields(Object[] tuple, String[] aliases) {
        return new OrderDTO(
                (Long) tuple[0],
                (String) tuple[1],
                (LocalDateTime) tuple[2],
                (LocalDateTime) tuple[3],
                (String) tuple[4],
                CustomerDTO.from((Customer) tuple[5])
        );
    }
}
