import org.junit.Test;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by mtumilowicz on 2018-10-10.
 */
public class LocalTypeInferenceTest {
    
    @Test
    public void test() {
        var intSet = Set.of(1, 2, 3);
        
        assertThat(intSet, hasSize(3));
    }
}
