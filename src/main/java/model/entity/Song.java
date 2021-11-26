package model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Song {
    private int id;
    private String name;
    private Integer amountOfLikes;
    private Integer downloadedAmount;
    private Integer streaming;
    private Integer playlistId;
    private Integer artistId;
    private Playlist playlist;
    private Artist artist;

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
    @Column(name = "amount_of_likes")
    public Integer getAmountOfLikes() {
        return amountOfLikes;
    }

    public void setAmountOfLikes(Integer amountOfLikes) {
        this.amountOfLikes = amountOfLikes;
    }

    @Basic
    @Column(name = "downloaded_amount")
    public Integer getDownloadedAmount() {
        return downloadedAmount;
    }

    public void setDownloadedAmount(Integer downloadedAmount) {
        this.downloadedAmount = downloadedAmount;
    }

    @Basic
    @Column(name = "streaming")
    public Integer getStreaming() {
        return streaming;
    }

    public void setStreaming(Integer streaming) {
        this.streaming = streaming;
    }

//    @Basic
//    @Column(name = "playlist_id")
//    public Integer getPlaylistId(){return playlistId;}
//
//    public void setPlaylistId(Integer playlistId){ this.playlistId = playlistId; }
//
//    @Basic
//    @Column(name = "artist_id")
//    public Integer getArtistId(){return artistId;}
//
//    public void setArtistId(Integer artistId){ this.artistId = artistId; }

    @ManyToOne
    @JoinColumn(name = "playlist_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist){ this.playlist = playlist; }

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist){ this.artist = artist; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != song.id) return false;
        if (!Objects.equals(name, song.name)) return false;
        if (!Objects.equals(amountOfLikes, song.amountOfLikes))
            return false;
        if (!Objects.equals(downloadedAmount, song.downloadedAmount))
            return false;
        if (!Objects.equals(streaming, song.streaming)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amountOfLikes != null ? amountOfLikes.hashCode() : 0);
        result = 31 * result + (downloadedAmount != null ? downloadedAmount.hashCode() : 0);
        result = 31 * result + (streaming != null ? streaming.hashCode() : 0);
        result = 31 * result + (playlistId != null ? playlistId.hashCode() : 0);
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        return result;
    }

    public Song(int id, String name, Integer amountOfLikes, Integer downloadedAmount, Integer streaming, Integer playlistId, Integer artistId) {
        this.id = id;
        this.name = name;
        this.amountOfLikes = amountOfLikes;
        this.downloadedAmount = downloadedAmount;
        this.streaming = streaming;
        this.playlistId = playlistId;
        this.artistId = artistId;
    }

    public Song(String name, Integer amountOfLikes, Integer downloadedAmount, Integer streaming, Integer playlistId, Integer artistId) {
        this.name = name;
        this.amountOfLikes = amountOfLikes;
        this.downloadedAmount = downloadedAmount;
        this.streaming = streaming;
        this.playlistId = playlistId;
        this.artistId = artistId;
    }

    public Song() {}

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountOfLikes=" + amountOfLikes +
                ", downloadedAmount=" + downloadedAmount +
                ", streaming=" + streaming +
                ", playlistId=" + playlistId +
                ", artistId=" + artistId +
                '}';
    }
}
