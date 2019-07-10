package rest.myResource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlTransient
@XmlSeeAlso({ Student.class, Teacher.class, HumanResource.class})
public class Person implements Serializable {
    private String name;
    private String surname;
    private int yearOfBorn;

    public Person() {
    }

    public Person(String name, String surname, int yearOfBorn) {
        this.name = name;
        this.surname = surname;
        this.yearOfBorn = yearOfBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", yearOfBorn=" + yearOfBorn + "]";
    }

}