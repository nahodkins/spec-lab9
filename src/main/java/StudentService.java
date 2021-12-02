import java.util.*;
import java.util.stream.Collectors;

public class StudentService {

    private StudentDAO dao;
    private static StudentService instance;

    private StudentService() throws StudentsReaderException {
        dao = StudentDAO.getInstance();
    }

    public static StudentService getInstance() throws StudentsReaderException {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public LinkedList<Student> getStudents() {
        return dao.getStudents();
    }

    public Set<String> getSortedGroups() {
        Set<Student> sorted = new TreeSet<>(Comparator.comparing(Student::getGroup));
        sorted.addAll(dao.getStudents());
        return sorted.stream()
                .map(Student::getGroup)
                .collect(Collectors.toSet());
    }

    public Set<String> getSortedSubjects() {
        Set<Student> sorted = new TreeSet<>(Comparator.comparing(Student::getSubjectName));
        sorted.addAll(dao.getStudents());
        return sorted.stream()
                .map(Student::getSubjectName)
                .collect(Collectors.toSet());
    }

    public List<Student> getStudentsOfGroup(String groupName) {
        LinkedList<Student> students = dao.getStudents();
        return students.stream()
                .filter(student -> student.getGroup().equals(groupName))
                .sorted(Student::compareTo)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOfGroupWithSubjectPerformance(String groupName, String subject) {
        return getStudentsOfGroup(groupName).stream()
                .filter(student -> student.getSubjectName().equals(subject))
                .sorted((o1, o2) -> o2.getPerformance().compareTo(o1.getPerformance()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByGroups() {
        return getStudents().stream()
                .sorted(Comparator.comparing(Student::getGroup))
                .collect(Collectors.toList());
    }
}
