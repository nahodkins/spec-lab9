import java.util.Objects;

public class Student implements Comparable<Student> {

    private String lastName;
    private String group;
    private String subjectName;
    private Integer performance;

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Student setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Student setSubjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public Integer getPerformance() {
        return performance;
    }

    public Student setPerformance(Integer performance) {
        this.performance = performance;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return lastName.equals(student.lastName) && group.equals(student.group)
                && subjectName.equals(student.subjectName) && performance.equals(student.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", group='" + group + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", performance=" + performance +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return lastName.compareTo(o.getLastName());
    }
}
