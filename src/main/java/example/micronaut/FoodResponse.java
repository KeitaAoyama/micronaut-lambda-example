package example.micronaut;

import java.util.List;

public class FoodResponse {

    public FoodResponse() {
    }

    FoodResponse(List<Food> foodList) {
        this.foodList = foodList;
    }

    private List<Food> foodList;

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

}
