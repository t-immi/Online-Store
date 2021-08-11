package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.CustomerRepository;
import ru.kandakov.onlinestore.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Customer> outputUsers() {
        return customerRepository.findAll();
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Optional<Customer> show(@PathVariable long id) {
        return customerRepository.findById(id);
    }

    @PutMapping("/create")
    @ResponseBody
    public Customer save(@RequestBody Customer customer) {
        customerService.create(customer);
        return customer;
    }

    @PatchMapping("/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Customer delete(@RequestBody Customer customer) {
        customerRepository.delete(customer);
        return customer;
    }

    @GetMapping("/show/shopping_cart")
    public ShoppingCart showShoppingCart(@RequestBody Customer customer) {
        return customer.getShoppingCart();
    }
}
