import java.util.InputMismatchException;
import java.util.Scanner;
public class Start {
    public static void main(String[] args) {
        Scanner usrInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------");
        System.out.println("1. Student Management\n" +
                "2. Teacher Management\n" +
                "3. Book Management\n" +
                "4. Basic Operations\n" +
                "5. Exit");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter the following number: ");
        String number = usrInput.nextLine();

        System.out.println("-------------------------------------------------");
        int opt;

        Teacher tchrMng;
        Student stdtMng;
        Book bkMng;
        BasicOperations bcOper;
        Patron p1 ;
        Book b1 = new Book();
        Author a= new Author();
        Publisher p=new Publisher();

        //--------------------------------------------------------------------//
        while (!number.equals("5")) {
            //---------------------------------STUDENT-----------------------------------//
            if (number.equals("1")) {

                stdtMng=new Student();
                stdtMng.showInfo();
                try {
                    opt = usrInput.nextInt();
                    System.out.println("-------------------------------------------------");
                }
                catch (InputMismatchException n){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Invalid Input Enter An Integer Value");
                    break;
                }
                if (opt == 1) {
                    stdtMng = new Student();
                    System.out.println("ENTER STUDENT ID  :");
                    stdtMng.setStudentId(usrInput.next());

                    System.out.println("ENTER STUDENT NAME :");
                    stdtMng.setName(usrInput.next());

                    System.out.println("ENTER STUDENT DEPT :");
                    stdtMng.setDepartmentName(usrInput.next());

                    System.out.println("ENTER STUDENT Contact Number :");
                    stdtMng.setContactNo(usrInput.next());

                    System.out.println("ENTER STUDENT ADDRESS :");
                    stdtMng.setAddress(usrInput.next());

                    System.out.println("ENTER STUDENT EMAIL :");
                    stdtMng.setEmail(usrInput.next());

                    System.out.println("ENTER GUARDIAN NAME  :");
                    stdtMng.setGuardianName(usrInput.next());

                    System.out.println("ENTER GUARDIAN CONTACT NO  :");
                    stdtMng.setGuardianContactNo(usrInput.next());

                    stdtMng.insertStudent(stdtMng);
                    System.out.println("-------------------------------------------------");
                }
                else if (opt == 2) {
                    System.out.println("ENTER STUDENT ID  :");

                    try {
                        stdtMng.getStudent(usrInput.nextInt());
                        System.out.println("-------------------------------------------------");
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }

                    System.out.println("-------------------------------------------------");

                }
                else if (opt == 3) {
                    stdtMng.showAllStudents();
                }
                else if (opt == 4) {
                    break;
                }
                else {
                    System.out.println("Invalid Input");
                    System.out.println("-------------------------------------------------");
                }

            }
            //---------------------------------TEACHER-----------------------------------//
            else if(number.equals("2")){
                tchrMng =new Teacher();
                tchrMng.showInfo();

                try {
                    opt = usrInput.nextInt();
                    System.out.println("-------------------------------------------------");
                }
                catch (InputMismatchException n){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Invalid Input Enter An Integer Value");
                    break;
                }
                if(opt==1){
                    tchrMng = new Teacher();
                    System.out.println("Enter Teacher's Id  :");
                    tchrMng.setTeacherId(usrInput.next());

                    System.out.println("Enter Teacher's Name :");
                    tchrMng.setName(usrInput.next());

                    System.out.println("Enter Teacher's Department :");
                    tchrMng.setDepartmentName(usrInput.next());

                    System.out.println("Enter Teacher's Contact Number :");
                    tchrMng.setContactNo(usrInput.next());

                    System.out.println("Enter Teacher's Address :");
                    tchrMng.setAddress(usrInput.next());

                    System.out.println("Enter Teacher's Email :");
                    tchrMng.setEmail(usrInput.next());

                    tchrMng.insertTeacher(tchrMng);
                    System.out.println("-------------------------------------------------");
                }
                else if(opt==2){
                    System.out.println("Enter Teacher's Id  :");
                    try {
                        tchrMng.getTeacher(usrInput.nextInt());
                        System.out.println("-------------------------------------------------");
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }
                }
                else if(opt==3){
                    tchrMng.showAllTeachers();
                }
                else if(opt==4) {
                    break;
                }
                else {
                    System.out.println("invalid input");
                    System.out.println("-------------------------------------------------");
                }
            }
            //---------------------------------BOOK-----------------------------------//
            else if(number.equals("3")){
                System.out.println("1. Insert New Book \n" +
                        "2. Search by BookId \n" +
                        "3. Show All Books \n" +
                        "4. Go Back");
                System.out.println("-------------------------------------------------");
                System.out.println("Enter your option : ");

                try {
                    opt = usrInput.nextInt();
                    System.out.println("-------------------------------------------------");
                }
                catch (InputMismatchException n){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Invalid Input Enter An Integer Value");
                    break;
                }
                if(opt==1){
                    bkMng= new Book();
                    System.out.println("Enter Book's ID  :");
                    bkMng.setId(usrInput.nextInt());

                    System.out.println("Enter Book's Title :");
                    bkMng.setTitle(usrInput.next());

                    System.out.println("Enter Book's Subtitle :");
                    bkMng.setSubTitle(usrInput.next());

                    System.out.println("Enter Author's Id :");
                    try {
                        a.setId(usrInput.nextInt());
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }

                    System.out.println("Enter Author's Name :");
                    a.setName(usrInput.next());

                    System.out.println("Enter Author's Email :");
                    a.setEmail(usrInput.next());

                    bkMng.setAuthor(a);


                    System.out.println("Enter Publisher's Id :");
                    try {
                        p.setId(usrInput.nextInt());
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }

                    System.out.println("Enter Publisher's Name :");
                    p.setName(usrInput.next());

                    System.out.println("Enter Publisher's Contact :");
                    p.setContactNo(usrInput.next());

                    bkMng.setPublisher(p);

                    System.out.println("Enter Book's Price :");
                    try {
                        bkMng.setPrice(usrInput.nextDouble());
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter A Double Value");
                        break;
                    }

                    bkMng.insertBook(bkMng);
                    System.out.println("-------------------------------------------------");

                }
                else if(opt==2){
                    bkMng= new Book();
                    System.out.println("Enter Book's Id  :");
                    try {
                        System.out.println("-------------------------------------------------");
                        bkMng.getBook(usrInput.nextInt());
                        System.out.println("-------------------------------------------------");
                    }
                    catch(InputMismatchException n){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }

                }
                else if(opt==3){
                    bkMng= new Book();
                    bkMng.showAllBooks();
                }
                else if(opt==4){
                    break;
                }
                else{
                    System.out.println("invalid input");
                }
            }
            //---------------------------------BASIC OPERATIONS-----------------------------------//
            else if(number.equals("4")){
                bcOper=new BasicOperations();
                bcOper.showInfo();

                try {
                    opt = usrInput.nextInt();
                    System.out.println("-------------------------------------------------");
                }
                catch (InputMismatchException n){
                    System.out.println("-------------------------------------------------");
                    System.out.println("Invalid Input Enter An Integer Value");
                    break;
                }

                if(opt==1){
                    p1=new Patron() {
                        @Override
                        void showInfo() {
                            System.out.println("Enter Patron's Id :");
                        }
                    };
                    bcOper=new BasicOperations();
                    p1.showInfo();
                    try {
                        p1.id = usrInput.nextInt();
                    }
                    catch(InputMismatchException i){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }
                    System.out.println("Enter Patron's Name :");
                    p1.name=usrInput.next();
                    System.out.println("Enter Patron's Contact Number :");
                    p1.contactNo=usrInput.next();

                    System.out.println("Enter Book's Id :");
                    try {
                        b1.id = usrInput.nextInt();
                    }
                    catch(InputMismatchException i){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                        break;
                    }

                    System.out.println("Enter Fine :");
                    try {
                        p1.amount = usrInput.nextDouble();
                    }
                    catch(InputMismatchException i){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Double Value");
                        break;
                    }
                    bcOper.borrow(p1,b1);
                    System.out.println("-------------------------------------------------");

                }
                else if(opt==2){
                    p1=new Patron() {
                        @Override
                        void showInfo() {
                            System.out.println("Enter the Book ID you want to Return");
                        }
                    };
                    bcOper=new BasicOperations();
                    p1.showInfo();
                    try {
                        b1.id = usrInput.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("-------------------------------------------------");
                        System.out.println("Invalid Input Enter An Integer Value");
                    }
                    System.out.println("-------------------------------------------------");
                    bcOper.returnBook(p1,b1);
                    System.out.println("-------------------------------------------------");
                }
                else if(opt==3){
                    p1=new Patron() {
                        void showInfo() {
                            System.out.println("Enter Patron's Id To Add Fine : ");
                        }
                    };
                    bcOper=new BasicOperations();
                    p1.showInfo();
                    p1.id=usrInput.nextInt();
                    System.out.println("Enter Amount :");
                    try {
                        bcOper.fine(p1, usrInput.nextDouble());
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid Input Enter An Integer Value");
                    }
                    System.out.println("-------------------------------------------------");
                }
                else if(opt==4){
                    break;
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
            else {
                System.out.println("Program Terminated");
                break;
            }
        }
        if(!number.equals("5")){
            main(null);
        }
    }
}
