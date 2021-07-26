package ru.kandakov.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kandakov.onlinestore.dto.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
