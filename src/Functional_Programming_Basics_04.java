import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Functional_Programming_Basics_04 {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("file.txt"))
                .map(s->s.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

}
