package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Role;
import ru.kandakov.onlinestore.repository.RoleRepository;
import ru.kandakov.onlinestore.service.RoleService;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    @ResponseBody
    public List<Role> outputRoles() {
        return roleService.findAll();
    }

    @PutMapping("/role/create")
    @ResponseBody
    public Role save(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PatchMapping("/role/update")
    @ResponseBody
    public Role update(@RequestBody Role role) {
        return roleService.save(role);
    }

    @DeleteMapping("/role/delete")
    @ResponseBody
    public Role delete(@RequestBody Role role) {
        return roleService.delete(role);}
}
