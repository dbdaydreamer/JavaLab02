import java.util.*;
import java.util.stream.Collectors;

class User{
    private final String name;
    private final int age;
    private final String city;
    private final List<String> tags;

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

public class Stream {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("David", 21, "Chisinau", List.of("sport", "music")),
                new User("Matvei", 17, "Balti", List.of("gaming")),
                new User("Ion", 30, "Cahul", List.of("travel", "sport")),
                new User("Mihai", 25, "Comrat", List.of("music")),
                new User("Bogdan", 19, "Chisinau", List.of("gaming", "sport")),
                new User("Maxim", 15, "Orhei", List.of("music", "travel")),
                new User("Damir", 23, "Berlin", List.of("sport")),
                new User("Daniil", 28, "Chisinau", List.of("travel")),
                new User("Sofia", 18, "Balti", List.of("music")),
                new User("Amelia", 22, "Cricova", List.of("travel", "sport")),
                new User("Eva", 16, "Cahul", List.of("music", "gaming")),
                new User("Maria", 27, "Chisinau", List.of("travel")),
                new User("Victoria", 20, "Balti", List.of("sport")),
                new User("Anastasia", 14, "Orhei", List.of("music"))
        );

        System.out.println("Старше 18:");
        users.stream()
                .filter(u -> u.getAge() > 18)
                .forEach(System.out::println);


        System.out.println("\nИз города Berlin:");
        users.stream()
                .filter(u -> u.getCity().equals("Berlin"))
                .forEach(System.out::println);


        System.out.println("\nС тегом sport:");
        users.stream()
                .filter(u -> u.getTags().contains("sport"))
                .forEach(System.out::println);


        System.out.println("\nСортировка по возрасту:");
        users.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);


        System.out.println("\nСортировка по имени:");
        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);


        System.out.println("\nСортировка по городу, затем по имени:");
        users.stream()
                .sorted(Comparator.comparing(User::getCity).thenComparing(User::getName))
                .forEach(System.out::println);


        System.out.println("\nСписок имён:");
        List<String> names = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(names);


        System.out.println("\nСписок длин имён:");
        List<Integer> nameLengths = users.stream()
                .map(u -> u.getName().length())
                .collect(Collectors.toList());
        System.out.println(nameLengths);


        System.out.println("\nВсе уникальные теги:");
        Set<String> uniqueTags = users.stream()
                .flatMap(u -> u.getTags().stream())
                .collect(Collectors.toSet());
        System.out.println(uniqueTags);


        System.out.println("\nГруппировка по городу:");
        Map<String, List<User>> byCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        byCity.forEach((city, usersInCity) -> System.out.println(city + ": " + usersInCity));


        System.out.println("\nГруппировка по возрастной категории:");
        Map<String, List<User>> byAgeCategory = users.stream()
                .collect(Collectors.groupingBy(u -> {
                    if (u.getAge() <= 12) return "child";
                    else if (u.getAge() <= 17) return "teen";
                    else return "adult";
                }));
        byAgeCategory.forEach((cat, usersInCategory) -> System.out.println(cat + ": " + usersInCategory));


        System.out.println("\nСуммарный возраст:");
        int sumAge = users.stream()
                .map(User::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumAge);

        System.out.println("\nСредний возраст:");
        double avgAge = users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
        System.out.println(avgAge);

        System.out.println("\nСамый старший пользователь:");
        users.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)))
                .ifPresent(System.out::println);

        System.out.println("\nСамый младший пользователь:");
        users.stream()
                .collect(Collectors.minBy(Comparator.comparingInt(User::getAge)))
                .ifPresent(System.out::println);
    }
}