package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.Customer;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.CustomerRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CustomerRepository customerRepository){
        this.shoppingCartRepository = shoppingCartRepository;
        this.customerRepository = customerRepository;
    }

    public ShoppingCart create(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }

    public ShoppingCart update(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
    }
    public List<ShoppingCart> findAll(){
        return shoppingCartRepository.findAll();
    }

    public Optional<Customer> findCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
