package com.rersdev.logisticapi.dao.repositories;

import com.rersdev.logisticapi.model.dtos.OrderDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepoTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer =
            new PostgreSQLContainer<>("postgres:16.1");

    @Test
    void connectionTest(){
        assertTrue(postgreSQLContainer.isCreated());
        assertTrue(postgreSQLContainer.isRunning());
    }

    @Autowired
    private OrderRepo orderRepo;

    @Test
    void shouldFindOrderByOrderNumber(){
        // given
        String orderNumber = "ORD-0011";
        // when
        var order = orderRepo.findByOrderNumber(orderNumber);
        // then
        assertTrue(order.isPresent());
    }

    @Test
    void shouldNotFindOrderByOrderNumber(){

        String orderNumber = "ORD-00589";

        var order = orderRepo.findByOrderNumber(orderNumber);

        assertTrue(order.isEmpty());
    }

    @Test
    void shouldFindTwoOrderByStatus(){

        String status = "PENDING";

        // filter, orderNumber, since, until, status, customerId, page, size
        List<OrderDTO> orders = orderRepo.findByFilter(
                4, null, null, null,
                status, null, 0, 10);

        assertEquals(2, orders.size());
    }
}