package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String nacionality;
    private LocalDate birthday;
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL) //hay que añadir el cascade para poder hacer el delete
    @JsonIgnore
    private Set<Medal> medals = new HashSet<>();

    public Athlete() {
    }

    public Athlete(String name, String surname, String nacionality, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.nacionality = nacionality;
        this.birthday = birthday;
    }

    public Set<Medal> getMedals() {return medals;}
    public void setMedals(Set<Medal> medals) {
        this.medals = medals;
    }
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String getNacionality() {return nacionality;}
    public void setNacionality(String nacionality) {this.nacionality = nacionality;}
    public LocalDate getBirthday() {return birthday;}
    public void setBirthday(LocalDate birthday) {this.birthday = birthday;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Athlete that = (Athlete) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (nacionality != null ? !nacionality.equals(that.nacionality) : that.nacionality != null) return false;
        return birthday != null ? birthday.equals(that.birthday) : that.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (nacionality != null ? nacionality.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nacionality='" + nacionality + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
