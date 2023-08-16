package Models;

public class Person {
    private int person_id;
    private String name;

    public Person(int person_id, String name) {
        this.person_id = person_id;
        this.name = name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", name='" + name + '\'' +
                '}';
    }
}
