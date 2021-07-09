package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kandakov.onlinestore.dto.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
