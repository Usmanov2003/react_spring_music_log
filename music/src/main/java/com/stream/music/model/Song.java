package com.stream.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "Song")
@Table(name = "song")
public class Song {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "title", nullable = false)
    private String title;

    @JsonBackReference
    @ManyToMany
    @JoinColumn(
            name = "album_id"
    )
    private Album album;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "song_genres",
            joinColumns = @JoinColumn(name = "son_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genres;

    public Song() {
    }

    public Song(String title) { this.title = title;}

    public Song(String title, Album album) {
        this.title = title;
        this.album = album;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
