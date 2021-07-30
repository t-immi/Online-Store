import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kandakov.onlinestore.controllеr.CustomerController;
import ru.kandakov.onlinestore.controllеr.ShoppingCartController;
import ru.kandakov.onlinestore.repository.CustomerRepository;
import ru.kandakov.onlinestore.repository.OrderGoodsRepository;
import ru.kandakov.onlinestore.repository.OrderRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;
import ru.kandakov.onlinestore.service.CreateOrderByShoppingCartService;
import ru.kandakov.onlinestore.service.CustomerService;
import ru.kandakov.onlinestore.service.ShoppingCartService;

@Import({CustomerController.class, ShoppingCartController.class})
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {ApplicationRunner.class})

public class UseOnlineStoreTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ShoppingCartRepository shoppingCartRepository;

    @MockBean
    private OrderGoodsRepository orderGoodsRepository;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private CreateOrderByShoppingCartService createOrderByShoppingCartService;

    @Test
    public void testForSuccessfulRegistration () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":1,\"roleId\":1,\"name\":\"TestName\"}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testForSuccessfulCreateShoppingCart() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/shopping_cart/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"shoppingCartId\": 2, \"dateOfCreation\": \"2012-12-11T20:00:00.000+00:00\"}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testForSuccessfulCreateOrder() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/shopping_cart/create/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n \"shoppingCartId\": 1,\n \"dateOfCreation\": \"2012-12-11T20:00:00.000+00:00\",\n \"shoppingCartGoods\": {\n \"shoppingCartGoodsId\": 1,\n \"shoppingCartId\": 1,\n \"productId\": 1\n }\n }");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}