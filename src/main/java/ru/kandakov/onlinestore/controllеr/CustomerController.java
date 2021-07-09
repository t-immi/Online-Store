package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.repository.CustomerRepository;

@Controller
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/users")
    public String outputUsers(Model model){
        model.addAttribute("customers", customerRepository.findAll());
        return "customer/list";
    }

    @GetMapping("customer/read/{id}")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerRepository.findById(id));
        return "customer/show";
    }

    @PutMapping("/customer/create")
    @ResponseBody
    public Customer save(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @PatchMapping("customer/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping("/customer/delete")
    @ResponseBody
    public Customer delete(@RequestBody Customer customer) {
        customerRepository.delete(customer);
        return customer;
    }

}
