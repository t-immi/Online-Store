package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository){
        this.shoppingCartRepository = shoppingCartRepository;
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
}
