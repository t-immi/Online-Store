import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kandakov.onlinestore.controllеr.ShoppingCartController;
import ru.kandakov.onlinestore.repository.ShoppingCartRepository;
import ru.kandakov.onlinestore.service.ShoppingCartService;

@Import(ShoppingCartController.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartController.class)
@ContextConfiguration(classes = {ApplicationRunner.class})

public class ShoppingCartControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShoppingCartRepository shoppingCartRepository;

    @MockBean
    ShoppingCartService shoppingCartService;

    @Test
    public void testForSuccessfulTransfer () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/shopping_cart/catalog");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}