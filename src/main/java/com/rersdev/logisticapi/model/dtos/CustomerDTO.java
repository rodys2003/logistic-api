package com.rersdev.logisticapi.model.dtos;

import com.rersdev.logisticapi.model.entities.Customer;

import java.io.Serializable;

public record CustomerDTO(

        Long id,
        String name,
        String email,
        String phone

) implements Serializable {
    public static CustomerDTO from(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
}
