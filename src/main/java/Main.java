import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static List<String> readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> first = readFile("first.txt");
        List<String> second = readFile("second.txt");
        System.out.println("First: " + first);
        System.out.println("Second: " + second);

        Set<String> union = new HashSet<>(first);
        union.addAll(second);
        System.out.println("Union: " + union);

        Set<String> intersection = first.stream()
                .distinct()
                .filter(second::contains)
                .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);

        Set<String> difference = new HashSet<>(first);
        second.forEach(difference::remove);
        System.out.println(difference);
    }
}
