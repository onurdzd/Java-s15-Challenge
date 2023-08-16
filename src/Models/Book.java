package Models;

import Models.abstracts.BookProcess;

import java.util.ArrayList;

public class Book extends BookProcess {
    private int book_id;
    private String bookName;
    private int price;
    private String status;
    private String edition;
    private String date_of_purchase;
    private Author author;

    public Book(int book_id, String bookName, int price, String status, String edition, String date_of_purchase, Author author) {
        this.book_id = book_id;
        this.bookName = bookName;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.date_of_purchase = date_of_purchase;
        this.author = author;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(String date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
        ArrayList<Book> books = getBooks();
        boolean bookFound = false;

        for (Book book : new ArrayList<>(books)) {
            if (book.getBook_id() == existBookId) {
                books.remove(book);
                bookFound = true;
                System.out.println(book.getBookName() + " kitap listesinden silindi!");
                break; // İlgili kitabı bulup sildik, döngüyü kıralım.
            }
        }

        if (!bookFound) {
            System.out.println("İlgili kitap kayıtlı değil");
        }

        setBooks(books); // Son güncellemeleri kaydedelim
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition='" + edition + '\'' +
                ", date_of_purchase='" + date_of_purchase + '\'' +
                ", author=" + author +
                '}';
    }
}
