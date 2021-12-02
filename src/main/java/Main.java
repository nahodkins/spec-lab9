import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final String STRING_COUNT_TEMPLATE = "String: %s\nCount: %d\n";

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
        Set<String> stringSet = new HashSet<>(strings);
        stringSet
                .forEach(str -> {
                    System.out.println(String.format(STRING_COUNT_TEMPLATE, str, Collections.frequency(strings, str)));
                });
    }
}
