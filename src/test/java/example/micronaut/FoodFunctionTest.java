package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
        final List<Food> foodList = client.apply(request).blockingGet().getFoodList();
        assertTrue(foodList.stream().allMatch(Food::isYummy));
    }

    @Test
    void testFunctionGetNotYummyFood() {
        final FoodRequest request = new FoodRequest();
        request.setYummy(false);
        final List<Food> foodList = client.apply(request).blockingGet().getFoodList();
        assertTrue(foodList.stream().noneMatch(Food::isYummy));
    }

    @AfterAll
    static void afterAll() {
        server.stop();
    }

}
