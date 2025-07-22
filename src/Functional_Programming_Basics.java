import java.util.List;

public class Functional_Programming_Basics {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 3, 7, 12, 15);
        printOddNumbers(list);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "microservices",
                "aws", "docker", "azure", "Kubernettes");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .filter(course -> course.length() >= 7)
                .forEach(System.out::println);


    }
    public static void printOddNumbers(List<Integer> numbers){
        numbers.stream()
                .filter(n -> n%2==0)
                .forEach(System.out::println);
    }
}
