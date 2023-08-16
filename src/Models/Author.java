package Models;

public class Author extends Person{
private int author_id;

    public Author(int person_id, String name, int author_id) {
        super(person_id, name);
        this.author_id = author_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                '}';
    }
}
