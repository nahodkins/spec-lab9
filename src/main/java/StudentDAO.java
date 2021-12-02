import java.util.*;
import java.util.stream.Collectors;

public class StudentDAO {

    private final LinkedList<Student> students;
    private static StudentDAO instance;

    private StudentDAO() throws StudentsReaderException {
        students = StudentsReader.readStudents("students.txt");
    }

    public static StudentDAO getInstance() throws StudentsReaderException {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
}
