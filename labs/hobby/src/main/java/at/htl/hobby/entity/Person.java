package at.htl.hobby.entity;

import javax.persistence.*;

//@Entity
public class Person {
    //@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //@ManyToOne
    private Hobby hobby;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Hobby hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby newHobby) {
        // ist hobby leer? - wenn nicht, lösche person aus hobby
        if (this.hobby != null) {
            this.hobby.removePerson(this);
        }

        // ersetze altes hobby mit neuem hobby
        this.hobby = newHobby;

        // falls neues hobby != null, trage die aktuelle person in hobby ein
        if (newHobby != null) {
            newHobby.addPerson(this);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
