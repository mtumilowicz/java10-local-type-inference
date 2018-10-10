import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-10-10.
 */
public class LocalTypeInferenceTest {
    
    @Test
    public void basic() {
        var intSet = Set.of(1, 2, 3);
        
        assertThat(intSet, hasSize(3));
    }
    
    @Test
    public void try_with_resources() throws IOException {
        try (var linesStream = Files.lines(Paths.get("src/test/java/LocalTypeInferenceTest.java"))) {
            linesStream.takeWhile(e -> !e.contains("public")).forEachOrdered(System.out::println);
        }
    }
}
