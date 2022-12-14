package com.mmacedoaraujo.musicsapimarksanderson.repository;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    public List<Music> findByNameIgnoreCase(String name);
}
