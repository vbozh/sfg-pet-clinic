package guru.springframework.sfgpetclinic;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SfgPetClinicApplicationTests {

    @Autowired
    MessageSource messageSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void resolvesSpanishMessages() {
        Locale spanish = new Locale("es");

        assertEquals("Bienvenido", messageSource.getMessage("welcome", null, spanish));
        assertEquals("Solo se permite enviar el formulario una vez",
                messageSource.getMessage("duplicateFormSubmission", null, spanish));
    }

}
