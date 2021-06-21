import java.io.*;

public class Teacher extends Patron implements TeacherOperations{ //class Teacher extends Patron class and
    String teacherId;
    String Filename = "teacher.txt"; //String to hold Filename for txt file
    File tFile = new File(Filename); //file object for file operations
    PrintWriter pw = null; //initialization of printWriter object.

    void setTeacherId(String teacherId){  // set method
        this.teacherId = teacherId;
    }

    String getTeacherId(){ //get Method
        return teacherId;
    }

    void showInfo() {   // abstract method from patron class overridden
        System.out.println("1. Insert New Teacher \n" +
                "2. Search by TeacherId \n" +
                "3. Show All Teachers \n" +
                "4. Go Back");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter your option : ");
    }
    public void insertTeacher(Teacher t){ // method overridden from interface to write file
        try {
            FileWriter FWriter = new FileWriter(Filename, true);
            pw = new PrintWriter(FWriter);
            pw.printf("%s %s %s %s %s %s",
                    t.getTeacherId(),
                    t.getName(),
                    t.getDepartmentName(),
                    t.getContactNo(),
                    t.getAddress(),
                    t.getEmail());
            pw.println();
            pw.close();
        } catch (Exception e) {
            System.out.println("error Write");
        }
    }

    public Teacher getTeacher(int teacherId)  { // method overridden from interface to search from file
        Teacher ret = new Teacher();// object created for return type//

        String line;

        try {
            FileReader fileReader = new FileReader(tFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] words;

            while ((line = bufferedReader.readLine()) != null) {
                words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(String.valueOf(teacherId))) {
                        System.out.println("Teacher's ID : " + words[i] + "\n" +
                                "Teacher's Name : " + words[i + 1] + "\n" +
                                "Teacher's Department Name : " + words[i + 2] + "\n" +
                                "Teacher's Contact Number : " + words[i + 3] + "\n" +
                                "Teacher's Address : " + words[i + 4] + "\n" +
                                "Teacher's Email : " + words[i + 5] + "\n");
                    }
                }

            }
        }
        catch(Exception e){
            System.out.println("Error read");
        }
        return ret;
    }
    public void showAllTeachers(){ // method overridden from interface to print all from file
        String line;
        try { // file loader starts
            FileReader fileReader = new FileReader(tFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Teacher's Info : "+line);
                System.out.println("-------------------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("error read");
        }// file loader ends

    }
}
