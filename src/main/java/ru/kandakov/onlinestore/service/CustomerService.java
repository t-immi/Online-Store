package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.repository.CustomerRepository;
import ru.kandakov.onlinestore.repository.RoleRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements UserDetailsService {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @PersistenceContext
    private EntityManager em;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByName(name);

        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found");
        }

        return customer;
    }

    public Customer findUserById(Long userId) {
        Optional<Customer> userFromDb = customerRepository.findById(userId);
        return userFromDb.orElse(new Customer());
    }

    public List<Customer> allUsers() {
        return customerRepository.findAll();
    }

    public void clear() {
        customerRepository.deleteAll();
    }

}
