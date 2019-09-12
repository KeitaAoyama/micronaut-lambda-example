package example.micronaut;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface FoodClient {

    @Named("micronaut-lambda-example")
    Single<FoodResponse> apply(@Body FoodRequest body);

}
