package KittyJson;

import java.util.List;

public class Kitty {
    private String name;
    private String breed;
    private String color;
    private Integer age;
    private List<String> ownersNames;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getOwnersNames() {
        return ownersNames;
    }

    public void setOwnersNames(List<String> ownersNames) {
        this.ownersNames = ownersNames;
    }
}
