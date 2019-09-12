package example.micronaut;

public class FoodRequest {

    public FoodRequest() {
    }

    private boolean isYummy;

    public boolean isYummy() {
        return isYummy;
    }

    public void setYummy(boolean yummy) {
        isYummy = yummy;
    }
}
