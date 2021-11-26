package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Artist {
    private int id;
    private String name;
    private String lastName;
    private Integer age;
    private Integer amountOfAlbums;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "amount_of_albums")
    public Integer getAmountOfAlbums() {
        return amountOfAlbums;
    }

    public void setAmountOfAlbums(Integer amountOfAlbums) {
        this.amountOfAlbums = amountOfAlbums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (id != artist.id) return false;
        if (!Objects.equals(name, artist.name)) return false;
        if (!Objects.equals(lastName, artist.lastName)) return false;
        if (!Objects.equals(age, artist.age)) return false;
        if (!Objects.equals(amountOfAlbums, artist.amountOfAlbums))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (amountOfAlbums != null ? amountOfAlbums.hashCode() : 0);
        return result;
    }

    public Artist(int id, String name, String lastName, Integer age, Integer amountOfAlbums) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.amountOfAlbums = amountOfAlbums;
    }

    public Artist(String name, String lastName, Integer age, Integer amountOfAlbums) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.amountOfAlbums = amountOfAlbums;
    }

    public Artist () {}

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", amountOfAlbums=" + amountOfAlbums +
                '}';
    }
}
