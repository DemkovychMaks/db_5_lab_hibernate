package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Playlist {
    private Integer id;
    private String appointment;
    private String about;
    private Integer libraryId;
    private Library library;

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
    @Column(name = "appointment")
    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    @Basic
    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

//    @Basic
//    @Column(name = "library_id")
//    public Integer getLibraryId() {
//        return libraryId;
//    }
//
//    public void setLibraryId(Integer libraryId) {
//        this.libraryId = libraryId;
//    }


    @ManyToOne
    @JoinColumn(name = "library_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (id != playlist.id) return false;
        if (!Objects.equals(appointment, playlist.appointment))
            return false;
        if (!Objects.equals(about, playlist.about)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (appointment != null ? appointment.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        return result;
    }

    public Playlist(int id, String appointment, String about, Integer libraryId) {
        this.id = id;
        this.appointment = appointment;
        this.about = about;
        this.libraryId = libraryId;
    }

    public Playlist(String appointment, String about, Integer libraryId) {
        this.appointment = appointment;
        this.about = about;
        this.libraryId = libraryId;
    }

    public Playlist() {}

    @Override
    public String toString() {
        return "Playlist{" +
                "id=" + id +
                ", appointment='" + appointment + '\'' +
                ", about='" + about + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }
}
