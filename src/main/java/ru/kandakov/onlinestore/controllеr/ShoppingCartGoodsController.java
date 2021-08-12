package ru.kandakov.onlinestore.controllеr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kandakov.onlinestore.dto.ShoppingCartGoods;
import ru.kandakov.onlinestore.service.ShoppingCartGoodsService;

import java.util.List;

@RequestMapping("/shopping_cart_goods")
@RestController
public class ShoppingCartGoodsController {

    private final ShoppingCartGoodsService shoppingCartGoodsService;

    @Autowired
    public ShoppingCartGoodsController(ShoppingCartGoodsService shoppingCartService) {
        this.shoppingCartGoodsService = shoppingCartService;
    }

    @GetMapping("/catalog")
    @ResponseBody
    public List<ShoppingCartGoods> outputShoppingCartGoods() {
        return shoppingCartGoodsService.findAll();
    }

    @PutMapping("/create")
    @ResponseBody
    public ShoppingCartGoods save(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsService.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @PatchMapping("/update")
    @ResponseBody
    public ShoppingCartGoods update(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsService.save(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ShoppingCartGoods delete(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        shoppingCartGoodsService.delete(shoppingCartGoods);
        return shoppingCartGoods;
    }

    @GetMapping("/product")
    @ResponseBody
    public Long showProduct(@RequestBody ShoppingCartGoods shoppingCartGoods) {
        return shoppingCartGoods.getProductId();
    }
}
