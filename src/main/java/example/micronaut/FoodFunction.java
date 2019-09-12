package example.micronaut;

import io.micronaut.function.FunctionBean;
import io.micronaut.function.executor.FunctionInitializer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionBean("micronaut-lambda-example")
public class FoodFunction extends FunctionInitializer implements Function<FoodRequest, FoodResponse> {

    private static final List<Food> FOOD_LIST = Arrays.asList(
            new Food("Sushi", false),
            new Food("Soba", true),
            new Food("Yakitori", true),
            new Food("Sashimi", false),
            new Food("Ramen", true));

    @Override
    public FoodResponse apply(FoodRequest request) {
        return new FoodResponse(FOOD_LIST
                .stream()
                .filter(food -> food.isYummy() == request.isYummy())
                .collect(Collectors.toList()));
    }

}

