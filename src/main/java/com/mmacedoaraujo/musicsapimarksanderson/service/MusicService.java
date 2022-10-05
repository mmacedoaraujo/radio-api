package com.mmacedoaraujo.musicsapimarksanderson.service;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import com.mmacedoaraujo.musicsapimarksanderson.exceptions.BadRequestException;
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

    public MusicPostRequestBody findByIdOrThrowException(Long id) {
        return MusicMapper.INSTANCE.toPostRequest(repository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Anime not found")));
    }
    public List<MusicPostRequestBody> findMusic(String name) {
        return MusicMapper.INSTANCE.toPostRequestList(repository.findByNameIgnoreCase(name));
    }

    public MusicPostRequestBody createNewMusic(MusicPostRequestBody music) {
        Music savedMusic = repository.save(MusicMapper.INSTANCE.toMusic(music));

        return MusicMapper.INSTANCE.toPostRequest(savedMusic);
    }

    public void delete(Long id) {
        Music music = repository.findById(id).orElseThrow();
        repository.delete(music);
    }

    public void replace(MusicPostRequestBody musicPostRequestBody) {
        findByIdOrThrowException(musicPostRequestBody.getId());
        repository.save(MusicMapper.INSTANCE.toMusic(musicPostRequestBody));
    }
}
