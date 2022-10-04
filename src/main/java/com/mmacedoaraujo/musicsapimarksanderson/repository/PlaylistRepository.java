package com.mmacedoaraujo.musicsapimarksanderson.repository;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
