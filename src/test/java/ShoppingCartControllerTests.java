import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
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
}