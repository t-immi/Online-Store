package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
