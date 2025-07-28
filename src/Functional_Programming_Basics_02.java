import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Functional_Programming_Basics_02 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4,4, 3, 7, 12, 15);

        Integer sum = numbers.stream()
                .reduce(0, Functional_Programming_Basics_02::sum);
        System.out.println("sum by custom method : "+sum);
        //if you do not use identity value,  it returns optional
        Optional<Integer> sum1 = numbers.stream()
                .reduce(Integer::sum);
        //same as above with identity value
        Integer sum2 = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("sum by inbuild method : "+sum1.get());


        sumOfSquares(numbers);

        sumOfOddNumbers (numbers);
        numbers.stream().distinct().forEach(System.out::println);
        numbers.stream().distinct().sorted().forEach(System.out::println);


        List<String> courses = List.of("Spring", "Spring Boot", "API", "microservices",
                "aws", "docker", "azure", "Kubernettes");

        courses.stream().sorted().forEach(System.out::println);

        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(x -> System.out.println(x));

        System.out.println(getDoubledNumbers(numbers));

        List<Integer> evenNumbersOnly = numbers.stream()
                .filter(x-> x%2==0)
                .collect(Collectors.toList());
        System.out.println(evenNumbersOnly);

        List<Integer> lenghtOfCourses = courses.stream()
                .map(String::length)
                .toList();
        System.out.println(courses);
        System.out.println(lenghtOfCourses);


    }

    private static void sumOfSquares(List<Integer> numbers){

        Integer sumOfSqares = numbers.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("sum of squares :" + sumOfSqares);

    }

    private static List<Integer> getDoubledNumbers(List<Integer> numbers){
        return numbers.stream().
                map(x -> x*x)
                .collect(Collectors.toList());
    }

    private static void sumOfOddNumbers(List<Integer> numbers){

        Integer sumOfOddNumbers = numbers.stream()
                .filter(x -> x%2!=0)
                .reduce(0, Integer::sum);
        System.out.println("sum of odd numbers :" + sumOfOddNumbers);

    }

    private static int sum(int a , int b){
        return a+b;
    }

}
