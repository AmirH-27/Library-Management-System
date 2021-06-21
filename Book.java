import java.io.*;

public class Book implements BookOperations{
    int id;
    String title;
    String subtitle;
    Author author=new Author();
    Publisher publisher= new Publisher();
    double price;


    String Filename = "book.txt"; //String to hold Filename for txt file
    File b = new File(Filename); //file object for file operations
    PrintWriter pw = null; //initialization of printWriter object.

    void setId(int id) {
        this.id = id;
    }

    void setTitle(String title) {
        this.title= title;
    }

    void setSubTitle(String subTitle) {
        this.subtitle = subTitle;
    }
    void setAuthor(Author author) {
        author.setId(author.id);
        author.setName(author.name);
        author.setEmail(author.email);
        this.author=author;
    }

    void setPublisher(Publisher publisher) {
        publisher.setId(publisher.id);
        publisher.setName(publisher.name);
        publisher.setContactNo(publisher.contactNo);
        this.publisher=publisher;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public void insertBook(Book b) {
        try {
            FileWriter FWriter = new FileWriter(Filename,true);
            pw = new PrintWriter(FWriter);
            pw.printf("%s %s %s %s %s %s %s %s %s %s ",
                    b.id,
                    b.title,
                    b.subtitle,
                    b.author.getId(),
                    b.author.getName(),
                    b.author.getEmail(),
                    b.publisher.getId(),
                    b.publisher.getName(),
                    b.publisher.getContactNo(),
                    b.price);
            pw.println();
            pw.close();
        }
        catch (Exception e) {
            System.out.println("error Write");
        }
    }

    public Book getBook(int bookId)  {
        Book ret = new Book();// object created for return type//

        String line;
        try {
            FileReader fileReader = new FileReader(b);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] words;

            while ((line = bufferedReader.readLine()) != null) {

                words = line.split(" ");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(String.valueOf(bookId))) {
                        System.out.println("Search Results :-");
                        System.out.println("Book's ID : " + words[i] + "\n" +
                                "Book's Title : " + words[i+1] + "\n" +
                                "Book's Subtitle : " + words[i+2] + "\n" +
                                "Author's ID : " + words[i+3] + "\n" +
                                "Author's Name : " + words[i+4] + "\n" +
                                "Author's Email : " + words[i+5] + "\n" +
                                "Publisher's ID : " + words[i+6] + "\n" +
                                "Publisher's Name : " + words[i+7]+ "\n"+
                                "Publisher's Contact Number : " + words[i+8]+ "\n"+
                                "Book's Price : " + words[i+9]);
                    }
                }

            }
        }
        catch(Exception e){
            System.out.println("Error read");
        }
        return ret;

    }

    public void showAllBooks() {
        String line;

        try { // file loader starts
            FileReader fileReader = new FileReader(b);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Books's Info : "+line);
                System.out.println("-------------------------------------------------");
            }

        } catch (Exception e) {
            System.out.println("error read");
        }
    }


}
