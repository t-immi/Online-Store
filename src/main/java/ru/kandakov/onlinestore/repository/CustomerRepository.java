package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
