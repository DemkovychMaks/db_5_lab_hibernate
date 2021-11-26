package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private Integer age;
    private Integer countryId;
    private Country country;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Basic
//    @Column(name = "country_id")
//    public Integer getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(Integer countryId) {
//        this.countryId = countryId;
//    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(lastName, user.lastName)) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(age, user.age)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public User(int id, String name, String lastName, String email, Integer age, Integer countryId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.countryId = countryId;
    }

    public User(String name, String lastName, String email, Integer age, Integer countryId) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.countryId = countryId;

    }

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", countryId=" + countryId +
                '}';
    }
}
