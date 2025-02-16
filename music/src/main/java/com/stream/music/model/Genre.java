package com.stream.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Genre")
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(
            startegy = GenerationType.AUTO
    )
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToMany(mappedBy = "genres")
    private List<Song> songs;

    public Genre() {

    }

    public Genre(String title) { this.title = title; }

    public Genre(String title, List<Song> sogs) {
        this.title = title;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
