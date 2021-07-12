package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Role;
import ru.kandakov.onlinestore.repository.RoleRepository;

@RestController
public class RoleController {

     private final RoleRepository roleRepository;

     @Autowired
     public RoleController(RoleRepository roleRepository) {
         this.roleRepository = roleRepository;
     }

    @PutMapping("/role/create")
    @ResponseBody
    public Role save(@RequestBody Role role) {
        roleRepository.save(role);
        return role;
    }

    @PatchMapping("/role/update")
    @ResponseBody
    public Role update(@RequestBody Role role) {
        roleRepository.save(role);
        return role;
    }

    @DeleteMapping("/role/delete")
    @ResponseBody
    public Role delete(@RequestBody Role role) {
        roleRepository.delete(role);
        return role;
    }
}
