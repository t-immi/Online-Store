import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kandakov.onlinestore.OnlineStoreApplication;
import ru.kandakov.onlinestore.controllеr.CustomerController;
import ru.kandakov.onlinestore.repository.CustomerRepository;

@ActiveProfiles("test")
@Import(CustomerController.class)
//@ComponentScan(basePackages = "ru.kandakov.onlinestore.controllеr")
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {OnlineStoreApplication.class})
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testForSuccessfulUsersTransfer () throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/customer/users");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testForSuccessfulUserTransfer () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/customer/read/1");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testForSuccessfulUserCreate () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":1,\"roleId\":1,\"name\":\"TestName\"}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testForUnSuccessfulUserCreate () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/customer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content("набор символов87428");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    public void testForSuccessfulUserDelete () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .delete("/customer/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\":1,\"roleId\":1,\"name\":\"TestName\"}");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testForUnSuccessfulUserDelete () throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .delete("/customer/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content("набор символов498903");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}