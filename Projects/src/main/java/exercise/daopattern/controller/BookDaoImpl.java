package exercise.daopattern.controller;

import exercise.daopattern.DAOinterface.BookDao;
import exercise.daopattern.model.Books;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    //list is working as a database
    private final ArrayList<Books> booksObj;

    public BookDaoImpl() {
        booksObj = new ArrayList<Books>();
        booksObj.add(new Books(1, "Java Book"));
        booksObj.add(new Books(2, "Python Book"));
        booksObj.add(new Books(3, "Android Book"));
    }

    @Override
    public List<Books> getAllBooks() {
        return this.booksObj;
    }

    @Override
    public Books getBookByIsbn(int isbn) {
        return this.booksObj.get(isbn);
    }

    @Override
    public void saveBook(Books book) {
        this.booksObj.add(book);
    }

    @Override
    public void deleteBook(Books book) {
        this.booksObj.remove(book);
    }
}