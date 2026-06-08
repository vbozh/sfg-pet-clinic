package guru.springframework.sfgpetclinic.i18n;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MessageBundleTest.MessageSourceTestConfig.class)
@TestPropertySource(properties = "spring.messages.basename=messages/messages")
class MessageBundleTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void resolvesSpanishMessages() {
        String message = messageSource.getMessage("welcome", null, new Locale("es"));

        assertThat(message).isEqualTo("Bienvenido");
    }

    @Test
    void spanishBundleDefinesEveryDefaultMessageKey() throws IOException {
        Properties defaultMessages = loadProperties("messages/messages.properties");
        Properties spanishMessages = loadProperties("messages/messages_es.properties");

        assertThat(stringPropertyNames(spanishMessages))
                .containsExactlyInAnyOrderElementsOf(stringPropertyNames(defaultMessages));
    }

    private Properties loadProperties(String path) throws IOException {
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            assertThat(inputStream).as(path).isNotNull();
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }

        return properties;
    }

    private Set<String> stringPropertyNames(Properties properties) {
        return properties.stringPropertyNames();
    }

    @Configuration
    @EnableConfigurationProperties(MessageSourceProperties.class)
    @Import(MessageSourceAutoConfiguration.class)
    static class MessageSourceTestConfig {
    }
}
