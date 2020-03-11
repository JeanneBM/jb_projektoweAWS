package pl.pandait.panda;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTests{

    MockMvc mockMvc;

    @Before
    public void beforeSetUp(){
        this.mockMvc = standaloneSetup(new HelloController()).build();
    }

    @Test
    public void whenGivenAttributeNameThenItIsInModel() throws Exception{
        this.mockMvc.perform(get("/greeting?name=Kuba")
            .accept(MediaType.ALL))
            .andExpect(status().isOk())
            .andExpect(model().attribute("name", "Kuba"));
    }
    
}