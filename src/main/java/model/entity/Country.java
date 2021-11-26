package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Country {
    private Integer id;
    private String name;
    private Integer population;

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
    @Column(name = "population")
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (!Objects.equals(name, country.name)) return false;
        if (!Objects.equals(population, country.population)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (population != null ? population.hashCode() : 0);
        return result;
    }

    public Country(Integer id, String name, Integer population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Country(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public Country() {}

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
