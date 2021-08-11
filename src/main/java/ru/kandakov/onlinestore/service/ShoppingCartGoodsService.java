package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartGoodsService {

    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public ShoppingCartGoodsService(ShoppingCartGoodsRepository shoppingCartGoodsRepository){
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }

    public void deleteById(Long id){
        shoppingCartGoodsRepository.deleteById(id);
    }
}
