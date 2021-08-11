import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.kandakov.onlinestore.OnlineStoreApplication;
import ru.kandakov.onlinestore.controllеr.TestController;

@Import(TestController.class)
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
@ContextConfiguration(classes = {OnlineStoreApplication.class})

public class TestControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @WithMockUser(username = "user1", password = "user1Pass")
    @Test
    public void testForSuccessfulTransfer() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .get("/test");

        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}