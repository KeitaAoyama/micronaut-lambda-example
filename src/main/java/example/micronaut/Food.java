package example.micronaut;

import java.util.Objects;

public class Food {

    public Food() {
    }

    public Food(String name, boolean isYummy) {
        this.name = name;
        this.isYummy = isYummy;
    }

    private String name;
    private boolean isYummy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isYummy() {
        return isYummy;
    }

    public void setYummy(boolean yummy) {
        isYummy = yummy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return isYummy == food.isYummy &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isYummy);
    }

}
