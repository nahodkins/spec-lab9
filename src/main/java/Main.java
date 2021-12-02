import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws StudentsReaderException {
        StudentService studentService = StudentService.getInstance();
        List<Student> students = studentService.getStudents();
        Set<String> sortedGroups = studentService.getSortedGroups();
        Set<String> sortedSubjects = studentService.getSortedSubjects();

        System.out.println("Students: ");
        students.forEach(System.out::println);
        System.out.println();
        System.out.println("Groups: " + sortedGroups);
        System.out.println("Subjects: " + sortedSubjects);

        System.out.println("КБ-41 students:");
        studentService.getStudentsOfGroup("КБ-41").forEach(System.out::println);
        System.out.println();
        System.out.println("КБ-41 students, Java subject:");
        studentService.getStudentsOfGroupWithSubjectPerformance("КБ-41", "Java")
                .forEach(System.out::println);
        System.out.println();
        System.out.println("Students sorted by groups:");
        studentService.getStudentsSortedByGroups().forEach(System.out::println);
    }
}
