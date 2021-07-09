package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;

public interface ShoppingCartGoodsRepository extends JpaRepository<ShoppingCartGoods, Long> {

}
