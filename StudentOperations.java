import java.io.FileNotFoundException;

public interface StudentOperations {
    void insertStudent(Student s);
    void removeStudent(Student s);
    Student getStudent(int studentId) throws FileNotFoundException;
    void showAllStudents( );
}
