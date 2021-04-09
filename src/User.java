import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class User {
    private String id;
    private String username;
    private String surname;
    private String houseNum;
    private String postCode;
    private String city;
    private String role;

    public User(String[] user) {
        this.id = user[0];
        this.username = user[1];
        this.surname = user[2];
        this.houseNum = user[3];
        this.postCode = user[4];
        this.city = user[5];
        this.role = user[6];
    }

    public String getRole() {
        return this.role;
    }

    public String getName() {
        return this.username;
    }

    public String getID() {
        return this.id;
    }

    public String getPostcode() {
        return this.postCode;
    }

    public void viewBooks() throws FileNotFoundException {
        try {
            ArrayList<Book> stockList = new ArrayList<>();
            File inputFile = new File("Data/Stock.txt");
            Scanner fileScanner = new Scanner(inputFile);
            Book book;
            while (fileScanner.hasNextLine()) {
                String[] details = fileScanner.nextLine().split(",");
                book = new Book(Integer.parseInt(details[0].trim()), details[1].trim(),
                        details[2].trim(), details[3].trim(), details[4].trim(), details[5].trim(),
                        Double.parseDouble(details[6].trim()), Integer.parseInt(details[7].trim()),
                        details[8].trim(), details[9].trim());
                stockList.add(book);
            }

            PriceComparator priceComp = new PriceComparator();
            stockList.sort(priceComp);
            for (Book b1: stockList) {
                System.out.println(b1);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    // create ViewBooks method

}
