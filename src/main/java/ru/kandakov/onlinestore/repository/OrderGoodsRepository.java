package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kandakov.onlinestore.dto.OrderGoods;

@Repository
public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Long> {

}
