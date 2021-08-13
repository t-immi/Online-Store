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
import ru.kandakov.onlinestore.controllеr.ProductController;
import ru.kandakov.onlinestore.repository.ProductRepository;
import ru.kandakov.onlinestore.repository.ShoppingCartGoodsRepository;
import ru.kandakov.onlinestore.service.ProductService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@Import(ProductController.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = {OnlineStoreApplication.class})
public class ProductControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    ProductService productService;

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulProductTransfer () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/product/read/1");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulProductDelete () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .delete("/product/delete")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"productId\": 1, \"label\": \"TestLabel\", \"price\": 130}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulReturnMinProductPrice () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/product/read/min/TestLabel");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}