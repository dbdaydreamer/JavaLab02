import java.util.stream.*;
import java.util.*;

class User{
    private String name;
    private int age;
    private String city;
    private List<String> tags;

    public User(String name, int age, String city, List<String> tags){
    this.name = name;
    this.age = age;
    this.city = city;
    this.tags = tags;
    }

    public String getName(){return name;}
    public int getAge(){return age;}
    public String getCity(){return city;}
    public List<String> getTags(){return tags;}
    public String toString() {
        return name + ", " + age + ", " + city + ", " + tags;
    }
}