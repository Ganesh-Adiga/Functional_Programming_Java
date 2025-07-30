import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functional_Programming_Basics_03 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4,4, 3, 7, 12, 15);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "microservices",
                "aws", "docker", "azure", "Kubernettes");

        Predicate<Integer> isEven = x->x%2==0;

        Predicate<Integer> isEven1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        Consumer<Integer> printConsumer = x-> System.out.println(x);
        Consumer<Integer> printConsumer1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        Function<Integer,Integer> squareFunction = x -> x*x;
        Function<Integer,Integer> squareFunction1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        //using anonymous inner classes
        numbers.stream()
                .filter(isEven1)
                .map(squareFunction1)
                .forEach(printConsumer1);

        //using functional programming way or lamdas
        numbers.stream()
                .filter(isEven)
                .map(squareFunction)
                .forEach(printConsumer);


        BinaryOperator<Integer> sumOperator = (x,y)->x+y;
        BinaryOperator<Integer> sumOperator1 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x+y;
            }
        };


        System.out.println("sum by ananymous inner class : "+numbers.stream().reduce(0,sumOperator1));
        System.out.println("sum by Functional Programming : "+numbers.stream().reduce(0,sumOperator));


        doMath(numbers, x->x*x*x);




    }

    private static void doMath(List<Integer> numbers , Function<Integer, Integer> mathFunction){

        numbers.stream()
                .map(mathFunction)
                .forEach(System.out::println);
    }

}
