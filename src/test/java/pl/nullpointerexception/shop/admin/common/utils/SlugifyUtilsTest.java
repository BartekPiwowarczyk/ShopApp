package pl.nullpointerexception.shop.admin.common.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SlugifyUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "test test.png, test-test.png",
            "hello world.jpg, hello-world.jpg",
            "ąęśćżźńół.png, aesczznol.png",
            "Produkt 1.png, produkt-1.png",
            "PRODUKT_2.jpg, produkt-2.jpg",
            "Pr@d@!#$ !..jpg, pr-d.jpg",
            "Produkt    1.png, produkt-1.png",
            "Produkt - 1.png, produkt-1.png",
    })
    void shouldSlugifyFileName(String in, String out) {
        String fileName = SlugifyUtils.slugifyFileName(in);

        assertEquals(fileName, out);
    }

}