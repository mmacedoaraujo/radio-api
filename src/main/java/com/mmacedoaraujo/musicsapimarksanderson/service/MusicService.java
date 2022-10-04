package com.mmacedoaraujo.musicsapimarksanderson.service;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import com.mmacedoaraujo.musicsapimarksanderson.mapper.MusicMapper;
import com.mmacedoaraujo.musicsapimarksanderson.repository.MusicRepository;
import com.mmacedoaraujo.musicsapimarksanderson.requests.MusicPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository repository;

    public List<MusicPostRequestBody> listAll() {
        return MusicMapper.INSTANCE.toPostRequestList(repository.findAll());
    }

    public MusicPostRequestBody insert(MusicPostRequestBody music) {
        Music savedMusic = repository.save(MusicMapper.INSTANCE.toMusic(music));

        return MusicMapper.INSTANCE.toPostRequest(savedMusic);
    }

    public void delete(Long id) {
        Music music = repository.findById(id).orElseThrow();
        repository.delete(music);
    }
}
