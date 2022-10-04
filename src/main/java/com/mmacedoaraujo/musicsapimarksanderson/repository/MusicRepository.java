package com.mmacedoaraujo.musicsapimarksanderson.repository;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
}
