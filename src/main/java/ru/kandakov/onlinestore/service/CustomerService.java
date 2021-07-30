package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.repository.CustomerRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer){
        customerRepository.save(customer);
        return customer;
    }
}

