package at.htl.hobby.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//@Entity
public class Hobby {
    //@Id
    private String abbr; // abbreviation (Abkürzung)
    private String description;
    
    private List<Person> persons;

    public Hobby() {
        persons = new LinkedList<>();
    }

    public Hobby(String abbr, String description) {
        this();
        this.abbr = abbr;
        this.description = description;
    }

    public void addPerson(Person newPerson) {
        persons.add(newPerson);
    }

    public void removePerson(Person person) {
        if (person != null && !persons.isEmpty()) {
            persons.remove(person);
        }
    }

    //region getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    //endregion


    @Override
    public String toString() {
        return "Hobby{" +
                "description='" + description +
                '}';
    }
}
