package TenderApplication.apiTest.mockTest;

import TenderApplication.TenderApplication;
import TenderApplication.api.HomePage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by student on 2015/09/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TenderApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration

public class homeAPI {

    final String BASE_URL = "http://localhost:8080/";
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new HomePage())
                .build();

    }


    @Test
    public void read() throws Exception {

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(BASE_URL + "api/home")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        is("**WELCOME TO THE TENDER DEPARTMENT SYSTEM**")));
    }

}
