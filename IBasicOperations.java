import java.io.*;

public interface IBasicOperations {
    void borrow(Patron p, Book b);
    void returnBook(Patron p, Book b);
    void fine(Patron p, double amount);
}
class BasicOperations extends Patron implements IBasicOperations{

    Book book = new Book();
    Patron patron;
    String Filename = "basicoperations.txt"; //String to hold Filename for txt file
    File oFile = new File(Filename); //file object for file operations
    FileWriter fWrite=null;
    PrintWriter pw = null; //initialization of printWriter object.
    FileReader fRead = null;
    BufferedReader bRead =null;

    public void borrow(Patron p, Book b) {
        try {
            fWrite = new FileWriter(Filename,true);
            pw = new PrintWriter(fWrite);
            pw.printf("%s %s %s %s %s",
                    p.id,
                    p.name,
                    p.contactNo,
                    b.id,
                    p.amount);
            pw.println();
            pw.close();
        }
        catch (Exception e) {
            System.out.println("error Write");
        }
    }

    public void returnBook(Patron p, Book b) {
        String oldContent="";
        try{
            fRead =new  FileReader(oFile);
            bRead = new BufferedReader(fRead);

            String line = bRead.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = bRead.readLine();
            }
            String newContent = oldContent.replace(String.valueOf(b.id), String.valueOf(0));
            fWrite = new FileWriter(oFile);
            fWrite.write(newContent);
            System.out.println("Book Returned");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bRead.close();
                fWrite.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void fine(Patron p, double amount) {
        String line;
        try {
            fRead = new FileReader(oFile);
            bRead = new BufferedReader(fRead);

            String[] words;

            while ((line = bRead.readLine()) != null) {

                words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    if (words[0].equals(String.valueOf(p.id))) {
                        String oldContent = "";
                        try {
                            fRead = new FileReader(oFile);
                            bRead = new BufferedReader(fRead);

                            line = bRead.readLine();

                            while (line != null) {
                                oldContent = oldContent + line + System.lineSeparator();
                                line = bRead.readLine();
                            }
                            String newContent = oldContent.replace(words[i+4], String.valueOf(amount));
                            fWrite = new FileWriter(oFile);
                            fWrite.write(newContent);
                            System.out.println("Patron's Id : "+words[i]+"\n"+
                                               "Patron's Name : "+words[i+1]+"\n"+
                                               "Patron's Contact Number : "+words[i+2]+"\n"+
                                               "Book Borrowed : "+words[i+3]+"\n"+
                                               "Fine Added : "+amount);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                bRead.close();
                                fWrite.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                    else {
                        //System.out.println("No such Id");
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }

    }
    void showInfo() {
        System.out.println("1. Borrow Book \n" +
                "2. Return Book \n" +
                "3. Add Fine \n" +
                "4. Go Back");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter your option : ");
    }
}