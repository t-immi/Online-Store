package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;

@Repository
public interface ShoppingCartGoodsRepository extends JpaRepository<ShoppingCartGoods, Long> {

}
