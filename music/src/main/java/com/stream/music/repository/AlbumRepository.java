package com.stream.music.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.OrderBy;

import com.stream.music.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {

    Optional<Album> findAlbumByTitle(String title);

    @OrderBy("title")
    List<Album> findAlbumsByOrderByTitleAsc();

    List<Album> findAlbumsByTitleContainingIgnoreCaseOrArtistContainingIgnoreCase(String query1, String query2);
}
