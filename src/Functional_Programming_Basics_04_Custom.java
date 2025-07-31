import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Functional_Programming_Basics_04_Custom {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 99, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 21000),
                new Course("Microservices", "Microservices", 96, 22000),
                new Course("FullStack", "Fullstack", 98, 20000));
        Predicate<Course> reviewPredidcateGreaterThan95 = course -> course.getReviewScore()>95;
        Predicate<Course> reviewPredidcateGreaterThan90 = course -> course.getReviewScore()>90;
        Predicate<Course> reviewPredidcateLessThan90 = course -> course.getReviewScore()<90;

        //All, None and any mathes
        System.out.println(courses.stream().allMatch(reviewPredidcateGreaterThan95));
        System.out.println(courses.stream().allMatch(reviewPredidcateGreaterThan90));


        System.out.println(courses.stream().noneMatch(reviewPredidcateGreaterThan95));
        System.out.println(courses.stream().noneMatch(reviewPredidcateLessThan90));

        System.out.println(courses.stream().anyMatch(reviewPredidcateLessThan90));
        System.out.println(courses.stream().anyMatch(reviewPredidcateGreaterThan95));

        //Comparators
        System.out.println("************ Comparator *************");
        Comparator<Course> noOfStudensComparator = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> noOfStudensComparatorRev = Comparator.comparing(Course::getNoOfStudents).reversed();

        List<Course> list = courses.stream().sorted(noOfStudensComparator).toList();
        System.out.println(list);

        List<Course> listRev = courses.stream().sorted(noOfStudensComparator).toList();
        System.out.println(listRev);

        Comparator<Course> noOfStudensAndReviewComparator = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
        System.out.println(courses.stream().sorted(noOfStudensAndReviewComparator).toList());

        //limit, skip
        System.out.println("************ skip limit takewhile dropwhile  *************");

        System.out.println(courses.stream().limit(2).toList());

        System.out.println(courses.stream().skip(1).toList());

        System.out.println(courses);

        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=99).toList());

        System.out.println(courses.stream().dropWhile(course -> course.getReviewScore()>95).toList());

        //max min optional firnd firstfirst and find any
        System.out.println("************ skip limit takewhile dropwhile  *************");

        System.out.println(courses.stream().max(noOfStudensAndReviewComparator));
        System.out.println(courses.stream().
                min(noOfStudensAndReviewComparator)
                .orElse(new Course("FullStack", "Fullstack", 98, 20000)));


        System.out.println(courses.stream().filter(reviewPredidcateLessThan90).min(noOfStudensAndReviewComparator));
        System.out.println(courses.stream().filter(reviewPredidcateLessThan90)
                .min(noOfStudensAndReviewComparator).orElse(new Course("FullStack", "Fullstack", 98, 20000)));

        System.out.println(courses.stream()
                .filter(reviewPredidcateGreaterThan90)
                .findFirst());

        System.out.println(courses.stream()
                .filter(reviewPredidcateGreaterThan90)
                .findAny());



        //total no, average, sum

        System.out.println(courses.stream()
                .mapToInt(Course::getNoOfStudents)
                .sum());

        OptionalDouble average = courses.stream()
                .mapToInt(Course::getNoOfStudents)
                .average();
        System.out.println(average.getAsDouble());

        System.out.println(courses.stream()
                .mapToInt(Course::getNoOfStudents)
                .count());


        //group by
        System.out.println("************ group by  *************");

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));


        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.
                        maxBy(Comparator.comparing(Course::getReviewScore)))));

        System.out.println(courses.stream().collect(Collectors
                .groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));






    }


}

class Course{
    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }

    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

}
