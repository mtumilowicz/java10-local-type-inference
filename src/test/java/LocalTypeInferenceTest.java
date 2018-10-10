import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mtumilowicz on 2018-10-10.
 */
public class LocalTypeInferenceTest {
    
    @Test
    public void try_with_resources() throws IOException {
        try (var linesStream = Files.lines(Paths.get("src/test/java/LocalTypeInferenceTest.java"))) {
            linesStream.takeWhile(e -> !e.contains("public")).forEachOrdered(System.out::println);
        }
    }
}
