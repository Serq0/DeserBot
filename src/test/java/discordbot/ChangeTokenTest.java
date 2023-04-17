package discordbot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@TestPropertySource(locations = "classpath:passwords.properties")
public class ChangeTokenTest {
    @Autowired
    private Environment env;

    @Test
    public void testDiscordBotToken() {
        String expectedValue = "TOKEN";
        String actualValue = env.getProperty("discord.token");
        assertNotEquals(expectedValue, actualValue);
    }
}
