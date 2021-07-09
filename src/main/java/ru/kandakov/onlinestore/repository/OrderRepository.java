package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
