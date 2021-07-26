package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;

import java.util.List;
@RequestMapping("/shopping_cart_goods")
@RestController
public class ShoppingCartGoodsController {

    private final ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @Autowired
    public ShoppingCartGoodsController(ShoppingCartGoodsRepository shoppingCartGoodsRepository) {
        this.shoppingCartGoodsRepository = shoppingCartGoodsRepository;
    }

    @GetMapping("/catalog")
    @ResponseBody
    public List<ShoppingCartGoods> outputShoppingCartGoods(){
        return shoppingCartGoodsRepository.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public ShoppingCartGoods save(@RequestBody  ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @PatchMapping("/update")
    @ResponseBody
    public ShoppingCartGoods update(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ShoppingCartGoods delete(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsRepository.delete(shoppingCartGoods);
        return shoppingCartGoods;
    }
}
