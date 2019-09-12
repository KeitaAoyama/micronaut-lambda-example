package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@MicronautTest
class FoodFunctionTest {

    private static EmbeddedServer server;
    private static FoodClient client;

    @BeforeAll
    static void beforeAll() {
        server = ApplicationContext.run(EmbeddedServer.class);
        client = server.getApplicationContext().getBean(FoodClient.class);
    }

    @Test
    void testFunctionGetYummyFood() {
        final FoodRequest request = new FoodRequest();
        request.setYummy(true);
        final List<Food> actual = client.apply(request).blockingGet().getFoodList();
        final List<Food> expected = Arrays.asList(
                new Food("Soba", true),
                new Food("Yakitori", true),
                new Food("Ramen", true));

        assertThat(actual, is(expected));
    }

    @Test
    void testFunctionGetNotYummyFood() {
        final FoodRequest request = new FoodRequest();
        request.setYummy(false);
        final List<Food> actual = client.apply(request).blockingGet().getFoodList();
        final List<Food> expected = Arrays.asList(
                new Food("Sushi", false),
                new Food("Sashimi", false));

        assertThat(actual, is(expected));
    }

    @AfterAll
    static void afterAll() {
        server.close();
    }

}
