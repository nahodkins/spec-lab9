import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    private static void printSetUsingIterator(Set<String> strings) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void printSetUsingForEach(Set<String> strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    private static void printSetUsingToString(Set<String> strings) {
        System.out.println(strings);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))){
            Set<String> strings = new HashSet<>();
            reader.lines()
                    .map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .forEach(strings::add);

            printSetUsingIterator(strings);
            System.out.println();
            printSetUsingForEach(strings);
            System.out.println();
            printSetUsingToString(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
