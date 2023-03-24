import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import KittyJson.*;

public class ParsingKittyJsonTest {
    private ClassLoader cl = ParsingKittyJsonTest.class.getClassLoader();

    @Test
    void parseKittyJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("Kitty.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            Kitty kitty = objectMapper.readValue(isr, Kitty.class);

            Assertions.assertEquals("Mew", kitty.getName());
            Assertions.assertEquals("Cornish Rex", kitty.getBreed());
            Assertions.assertEquals("Grey", kitty.getColor());
            Assertions.assertEquals(4, kitty.getAge());
            Assertions.assertEquals(List.of("Natasha", "Alexey"), kitty.getOwnersNames());
        }
    }
}
