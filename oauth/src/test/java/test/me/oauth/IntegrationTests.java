package test.me.oauth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IntegrationTests {

    @Autowired
    private MockMvc mvc;

    @LocalServerPort
    private int port;


    @Test
    void mustRedirectToGithubLoginPage() throws Exception {
        mvc.perform(get("/oauth2/authorization/github"))
                .andExpect(status().is3xxRedirection())
                .andExpect(result -> {
                    String redirectedUrl = result.getResponse().getRedirectedUrl();
                    assert redirectedUrl != null;

                    // Regex pour valider l'URL de redirection GitHub avec paramètres
                    String regex = "https://github\\.com/login/oauth/authorize\\?.*client_id=.*&redirect_uri=.*";
                    assert redirectedUrl.matches(regex);
                });

    }

}
