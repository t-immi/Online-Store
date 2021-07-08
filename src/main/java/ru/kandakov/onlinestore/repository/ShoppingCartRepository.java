package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
