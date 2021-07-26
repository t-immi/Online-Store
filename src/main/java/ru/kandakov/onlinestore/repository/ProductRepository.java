package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kandakov.onlinestore.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
