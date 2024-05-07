package com.rersdev.logisticapi.model.keys;

import com.rersdev.logisticapi.model.entities.Order;
import com.rersdev.logisticapi.model.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class OrderDetailsPK implements Serializable {

    private Order order;

    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsPK that = (OrderDetailsPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
