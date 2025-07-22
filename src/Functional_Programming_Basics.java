import java.util.List;

public class Functional_Programming_Basics {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 3, 7, 12, 15);

        System.out.println("\nOdd numbers in the list numbers are");
        printOddNumbers(list);

        System.out.println("\nCubes of the numbers are");
        printCubesOddNumbers(list);


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

    /**
     * print the cubes of odd numbers
     * @param numbers number to be cubed
     */
    public static void printCubesOddNumbers(List<Integer> numbers){
        numbers.stream()
                .filter(n -> n%2==0)
                .map(number -> number * number * number)
                .forEach(System.out::println);
    }
}
