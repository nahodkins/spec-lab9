import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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
        List<String> strings = readFile("file.txt");
        Collections.sort(strings);
        System.out.println("Sorted: " + strings);
        Collections.shuffle(strings);
        System.out.println("Shuffled: " + strings);
    }
}
