package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.OrderGoods;

public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Long> {

}
