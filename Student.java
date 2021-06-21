
import java.io.*;

public class Student extends Patron implements StudentOperations {//class student extends Patron class and
    String studentId;                                            //implements StudentOperations interface
    String guardianName;
    String guardianContactNo;


    String Filename = "student.txt"; //String to hold Filename for txt file
    File stFile = new File(Filename); //file object for file operations
    PrintWriter pw = null; //initialization of printWriter object.


    void setStudentId(String studentId) {// set method
        this.studentId = studentId;
    }

    void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    void setGuardianContactNo(String guardianContactNo) {
        this.guardianContactNo = guardianContactNo;
    }

    String getStudentId() {// get method
        return studentId;
    }

    String getGuardianName() {
        return guardianName;
    }

    String getGuardianContactNo() {
        return guardianContactNo;
    }


    void showInfo() { // abstract method from patron class overridden
        System.out.println("1. Insert New Student \n" +
                "2. Search by studentId \n" +
                "3. Show All Students \n" +
                "4. Go Back");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter your option : ");
    }

    public void insertStudent(Student s) { // method overridden from interface writes in file
        try {
            FileWriter FWriter = new FileWriter(Filename, true);
            pw = new PrintWriter(FWriter);
            pw.printf("%s %s %s %s %s %s %s %s",
                    s.getStudentId(),
                    s.getName(),
                    s.getDepartmentName(),
                    s.getContactNo(),
                    s.getAddress(),
                    s.getEmail(),
                    s.getGuardianName(),
                    s.getGuardianContactNo());
            pw.println();
            pw.close();
        } catch (Exception e) {
            System.out.println("error Write");
        }
    }

    public void removeStudent(Student s) { // method overridden from interface

    }

    public Student getStudent(int studentId) {// method overridden from interface to search from file
        Student ret = new Student();// object created for return type//

        String line;
        try {
            FileReader fileReader = new FileReader(stFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] words;

            while ((line = bufferedReader.readLine()) != null) {

                words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(String.valueOf(studentId))) {
                        System.out.println("Student's ID : " + words[i] + "\n" +
                                "Student's Name : " + words[i + 1] + "\n" +
                                "Student's Department Name : " + words[i + 2] + "\n" +
                                "Student's Contact : " + words[i + 3] + "\n" +
                                "Student's Address : " + words[i + 4] + "\n" +
                                "Student's Email : " + words[i + 5] + "\n" +
                                "Student's Guardian's Name : " + words[i + 6] + "\n" +
                                "Student's Guardian's Contact : " + words[i + 7]);
                    }
                }

            }
        }
        catch(Exception e){
            System.out.println("Error read");
        }
        return ret;
    }

    public void showAllStudents() { // method overridden from interface to Print All Students from file
        String line;

        try { // file loader starts
            FileReader fileReader = new FileReader(stFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Student's Info : "+line);
                System.out.println("-------------------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("error read");
        }// file loader ends
    }
}
