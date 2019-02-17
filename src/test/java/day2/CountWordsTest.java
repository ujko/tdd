package day2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountWordsTest {
    CountWords countWords;
    @BeforeEach
    void setUp() {
        countWords = new CountWords();
    }

    @Test
    void readFile() throws IOException {
        List<String> list = countWords.readFile("testFiles/TestingFile.txt");

        assertThat(list).contains("Ala ma kota")
                .contains("kot ma Alę")
                .hasSize(2);
    }
    @Test
    void readFile1() throws IOException {
        assertThrows(FileNotFoundException.class,
                () -> countWords.readFile("Tesetia0"));
    }

    @Test
    void rhymes(){
        List<String> line = addLines();
        Assertions.assertThat(countWords.rhymes(line))
                .containsKey("lata_świata")
                .containsValue(2)
                .hasSize(1);
    }
    private List<String> addLines() {
        List<String> line = new ArrayList<>();
        line.add("Takie były zabawy, spory w one lata");
        line.add("Śród cichej wsi litewskiej, kiedy reszta świata");
        line.add("DUPPPPA");
        line.add("Jak czeladnika, który terminuje lata,");
        line.add("Ażeby nabył trochę znajomości świata.");
        return line;
    }
    private Map<String, Integer> mapRhymes(){
        Map<String, Integer> mapRhymes = new HashMap<>();
        mapRhymes.put("Dom", 1);
        mapRhymes.put("Apartament", 2);
        mapRhymes.put("Penthouse", 3);
        return mapRhymes;
    }

    @Test
    void endMapTest() {
        Assertions.assertThat(countWords.method(mapRhymes(),1))
                .hasSize(2)
                .containsKeys("Apartament","Penthouse")
                .doesNotContainKey("Dom")
                .containsValues(2,3)
                .doesNotContainValue(1);
    }

}
