package Runner;

import Controller.BookDaoImpl;
import DAOinterface.BookDao;
import model.Books;

import java.sql.SQLException;

public class AccessBook {
    public static void main(String[] args) {

        // Creating DAO
        BookDao bookDao = new BookDaoImpl();
/*
        // Inserting book records
        System.out.println("--------- inserting book records ----------");
        ArrayList<Books> BookList = new ArrayList<Books>();

        Books b1 = new Books();
        b1.setIsbn(120);
        b1.setBookName("Java Book");
        BookList.add(b1);

        Books b2 = new Books();
        b2.setIsbn(300);
        b2.setBookName("Python Book");
        BookList.add(b2);

        Books b3 = new Books();
        b3.setIsbn(365);
        b3.setBookName("JavaScript Book");
        BookList.add(b3);

        Books b4 = new Books();
        b4.setIsbn(256);
        b4.setBookName("SQL Book");
        BookList.add(b4);

        bookDao.saveBook(BookList);
*/

        // Displaying list of all books
        System.out.println(" ====== Display list of all books ====");
        try {
            for (Books cc : bookDao.getAllBooks()) {
                int ISBN = cc.getIsbn();
                String BookName = cc.getBookName();
                System.out.println("======================");
                System.out.println("ISBN Number :" + ISBN + " and Book name: " + BookName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

/*
        // Updating a book record by id
        System.out.println("----Book information is updating -----");
        Books Bookupdating = new Books();
        Bookupdating.setIsbn(3);
        Bookupdating.setBookName("Algorithms Book");
        boolean result = bookDao.updateBook(Bookupdating, 3);
        System.out.println(result);
*/

        /*

        // Deleting a book record by id
        boolean a = bookDao.deleteBook(4); // 4 is a id of book
        if (a) {
            System.out.println("Record is deleted");
        } else {
            System.out.println("Record is not deleted");
        }
*/
    }
}