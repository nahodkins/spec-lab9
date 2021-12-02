import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class StudentsReader {

    private static final String FAILED_TO_READ_STUDENTS_MSG = "Failed to read students";

    private static Student convertStringToStudent(String studentString) {
        String[] studentInfo = studentString.split(" ");
        return new Student()
                .setLastName(studentInfo[0])
                .setGroup(studentInfo[1])
                .setSubjectName(studentInfo[2])
                .setPerformance(Integer.parseInt(studentInfo[3]));
    }

    public static LinkedList<Student> readStudents(String fileName) throws StudentsReaderException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .filter(str -> !str.equals("\n"))
                    .map(StudentsReader::convertStringToStudent)
                    .sorted(Student::compareTo)
                    .collect(Collectors.toCollection(LinkedList::new));
        } catch (IOException e) {
            throw new StudentsReaderException(FAILED_TO_READ_STUDENTS_MSG, e);
        }
    }
}
