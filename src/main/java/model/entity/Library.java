package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Library {
    private int id;
    private Integer amountOfSongs;
    private Integer amountOfDownloadedSongs;

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
    @Column(name = "amount_of_songs")
    public Integer getAmountOfSongs() {
        return amountOfSongs;
    }

    public void setAmountOfSongs(Integer amountOfSongs) {
        this.amountOfSongs = amountOfSongs;
    }

    @Basic
    @Column(name = "amount_of_downloaded_songs")
    public Integer getAmountOfDownloadedSongs() {
        return amountOfDownloadedSongs;
    }

    public void setAmountOfDownloadedSongs(Integer amountOfDownloadedSongs) {
        this.amountOfDownloadedSongs = amountOfDownloadedSongs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (id != library.id) return false;
        if (!Objects.equals(amountOfSongs, library.amountOfSongs))
            return false;
        if (!Objects.equals(amountOfDownloadedSongs, library.amountOfDownloadedSongs))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amountOfSongs != null ? amountOfSongs.hashCode() : 0);
        result = 31 * result + (amountOfDownloadedSongs != null ? amountOfDownloadedSongs.hashCode() : 0);
        return result;
    }

    public Library(int id, Integer amountOfSongs, Integer amountOfDownloadedSongs) {
        this.id = id;
        this.amountOfSongs = amountOfSongs;
        this.amountOfDownloadedSongs = amountOfDownloadedSongs;
    }

    public Library(Integer amountOfSongs, Integer amountOfDownloadedSongs) {
        this.amountOfSongs = amountOfSongs;
        this.amountOfDownloadedSongs = amountOfDownloadedSongs;
    }

    public Library(){}

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", amountOfSongs=" + amountOfSongs +
                ", amountOfDownloadedSongs=" + amountOfDownloadedSongs +
                '}';
    }
}
