package Models;

import java.util.ArrayList;

public class Reader extends Person{
    private int reader_id;
    private ArrayList<Book> books=new ArrayList<>();
    private ArrayList<Reader>readerArrayList=new ArrayList<Reader>();

    public Reader(int person_id, String name, int reader_id) {
        super(person_id, name);
        this.reader_id = reader_id;
    }

    public Reader(int person_id, String name, int reader_id, ArrayList<Book> books) {
        super(person_id, name);
        this.reader_id = reader_id;
        this.books = books;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Reader> getReaderArrayList() {
        return readerArrayList;
    }

    public void setReaderArrayList(ArrayList<Reader> readerArrayList) {
        this.readerArrayList = readerArrayList;
    }

    public void addReaderToList(Reader reader){
        readerArrayList.add(reader);
    }
    public void removeReaderFromList(int readerId) {
        ArrayList<Reader> readers = getReaderArrayList();
        boolean readerFound = false;
        for (Reader reader : readers
        ) {
            if (readerId == reader.getReader_id()) {
                readerFound = true;
                getReaderArrayList().remove(reader);
                System.out.println(reader.getReader_id() + " id nolu okuyucu listeden silindi!");
                break;
            }
        }
        if (!readerFound) {
            System.out.println(reader_id + " id nolu okuyucu okuyucu listesinde bulunmuyor!");
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", books=" + books +
                '}';
    }
}
