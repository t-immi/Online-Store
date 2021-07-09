package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

@Controller
public class ShoppingCartGoodsController {

    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public ShoppingCartGoodsController(ShoppingCartGoodsRepository shoppingCartGoodsRepository) {
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }
    @PutMapping("/shopping_cart_goods/create")
    @ResponseBody
    public ShoppingCartGoods save(@RequestBody  ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @PatchMapping("/shopping_cart_goods/update")
    @ResponseBody
    public ShoppingCartGoods update(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @DeleteMapping("/shopping_cart_goods/delete")
    @ResponseBody
    public ShoppingCartGoods delete(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.delete(shoppingCartGoods);
        return shoppingCartGoods;
    }
}
