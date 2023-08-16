package Models.abstracts;

import Models.Book;
import Models.Library;
import Models.Reader;

import java.util.ArrayList;

public abstract class BookProcess {
    private ArrayList<Book> books=new ArrayList<Book>();
    private ArrayList<Reader> readers=new ArrayList<Reader>();;
    private Library mainLibrary=null;

    public Library getMainLibrary() {
        return mainLibrary;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    public void setMainLibrary(Library mainLibrary) {
        this.mainLibrary = mainLibrary;
    }

    public abstract boolean isBookIdValid(Book newBook);
    public abstract void addBook(Book newBook);
    public abstract void removeBook(int existBookId);

}
