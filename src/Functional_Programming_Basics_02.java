import java.util.List;
import java.util.Optional;

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



    }

    private static void sumOfSquares(List<Integer> numbers){

        Integer sumOfSqares = numbers.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("sum of squares :" + sumOfSqares);

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
