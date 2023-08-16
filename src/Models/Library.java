package Models;

import Models.abstracts.BookProcess;

import java.util.ArrayList;

public class Library extends BookProcess {
    private int library_id;

    public Library(int library_id, ArrayList<Book> books, ArrayList<Reader> readers) {
        this.library_id = library_id;
        setBooks(books);
        setReaders(readers);
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }


    @Override
    public boolean isBookIdValid(Book newBook) {
        for (Book book:getBooks()
        ) {
            if(book.getBook_id()==newBook.getBook_id()){
            System.out.println("Kitap id'si sistemde mevcut,kitap eklenemedi");
            return false;
        }
        }
        return true;
    }

    @Override
    public void addBook(Book newBook) {
        if(isBookIdValid(newBook)){
            System.out.println(newBook + " eklendi!");
            getBooks().add(newBook);
        }
    }
    @Override
    public void removeBook(int existBookId) {
        ArrayList<Book>books=getBooks();
        for (Book book:books
        ) {if(book.getBook_id()==existBookId){
            books.remove(book);
            setBooks(books);
            System.out.println(" silindi!");}
        else{
            System.out.println("İlgili kitap kayıtlı değil");}
        }}

    @Override
    public String toString() {
        return "Library{" +
                "library_id=" + library_id +
                ", books=" + getBooks() +
                ", readers=" + getReaders() +
                '}';
    }

}
