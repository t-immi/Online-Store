package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<Customer> outputUsers(){
        return customerRepository.findAll();
    }

    @GetMapping("customer/read/{id}")
    @ResponseBody
    public Optional<Customer> show(@PathVariable long id){
        return customerRepository.findById(id);
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
