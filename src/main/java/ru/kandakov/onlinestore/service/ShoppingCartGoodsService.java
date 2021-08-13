package ru.kandakov.onlinestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kandakov.onlinestore.dto.ShoppingCart;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingCartGoodsService {

    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public ShoppingCartGoodsService(ShoppingCartGoodsRepository shoppingCartGoodsRepository) {
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }

    public void deleteById(Long id) {
        shoppingCartGoodsRepository.deleteById(id);
    }

    public void deleteAllByShoppingCart(ShoppingCart shoppingCart){
        shoppingCartGoodsRepository.deleteAllByShoppingCart(shoppingCart);
    }

    public void delete(ShoppingCartGoods shoppingCartGoods){
        shoppingCartGoodsRepository.delete(shoppingCartGoods);
    }

    public List<ShoppingCartGoods> findAll() {
        return shoppingCartGoodsRepository.findAll();
    }

    public ShoppingCartGoods save(ShoppingCartGoods shoppingCartGoods) {
        return shoppingCartGoodsRepository.save(shoppingCartGoods);
    }
}
