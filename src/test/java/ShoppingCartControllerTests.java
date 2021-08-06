import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kandakov.onlinestore.OnlineStoreApplication;
import ru.kandakov.onlinestore.controllеr.ShoppingCartController;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;
import ru.kandakov.onlinestore.service.CreateOrderByShoppingCartService;
import ru.kandakov.onlinestore.service.ShoppingCartService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@Import(ShoppingCartController.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
@ContextConfiguration(classes = {OnlineStoreApplication.class})

public class ShoppingCartControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShoppingCartRepository shoppingCartRepository;

    @MockBean
    ShoppingCartService shoppingCartService;

    @MockBean
    CreateOrderByShoppingCartService createOrderByShoppingCartService;

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulTransfer () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/shopping_cart/catalog");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulGetCustomerByShoppingCart () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/shopping_cart/show/customer")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n \"shoppingCartId\": 1,\n \"shoppingCartGoods\": {\n \"shoppingCartGoodsId\": 1,\n \"shoppingCartId\": 1,\n \"productId\": 1\n  }\n}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}