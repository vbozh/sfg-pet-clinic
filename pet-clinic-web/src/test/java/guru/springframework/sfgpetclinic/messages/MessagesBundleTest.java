package guru.springframework.sfgpetclinic.messages;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MessagesBundleTest {

    private static final String MESSAGES_BUNDLE_NAME = "messages/messages";
    private static final String DEFAULT_MESSAGES_RESOURCE = "messages/messages.properties";
    private static final String SPANISH_MESSAGES_RESOURCE = "messages/messages_es.properties";

    @Test
    void spanishMessagesProvideAllDefaultMessageCodes() throws Exception {
        Set<String> defaultMessageCodes = loadMessageCodes(DEFAULT_MESSAGES_RESOURCE);
        Set<String> spanishMessageCodes = loadMessageCodes(SPANISH_MESSAGES_RESOURCE);

        assertThat(spanishMessageCodes).containsExactlyInAnyOrderElementsOf(defaultMessageCodes);
    }

    @Test
    void spanishLocaleResolvesSpanishMessages() {
        ResourceBundle spanishMessages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("es"));

        assertThat(spanishMessages.getString("welcome")).isEqualTo("Bienvenido");
        assertThat(spanishMessages.getString("duplicateFormSubmission"))
                .isEqualTo("Solo se permite enviar el formulario una vez");
        assertThat(spanishMessages.getString("typeMismatch.birthDate")).isEqualTo("fecha no valida");
    }

    private Set<String> loadMessageCodes(String resourceName) throws Exception {
        Properties messages = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName)) {
            assertThat(inputStream).as("resource %s", resourceName).isNotNull();
            messages.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }

        return messages.stringPropertyNames();
    }
}
