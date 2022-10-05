package com.mmacedoaraujo.musicsapimarksanderson.service;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Playlist;
import com.mmacedoaraujo.musicsapimarksanderson.exceptions.BadRequestException;
import com.mmacedoaraujo.musicsapimarksanderson.mapper.PlaylistMapper;
import com.mmacedoaraujo.musicsapimarksanderson.repository.PlaylistRepository;
import com.mmacedoaraujo.musicsapimarksanderson.requests.MusicPostRequestBody;
import com.mmacedoaraujo.musicsapimarksanderson.requests.PlaylistPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository repository;

    public List<PlaylistPostRequestBody> listAllPlaylists() {
        return PlaylistMapper.INSTANCE.toListPostRequest(repository.findAll());
    }

    public PlaylistPostRequestBody findPlaylistByIdOrThrowException(Long id) {
        Playlist playlist = repository
                .findById(id)
                .orElseThrow(
                        () -> new BadRequestException("Playlist not found!"));
        return PlaylistMapper.INSTANCE.toPostRequest(playlist);
    }

    public void deletePlaylist(Long id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new BadRequestException("Playlist not found!")));
    }

    public PlaylistPostRequestBody createNewPlaylist(PlaylistPostRequestBody playlist) {
        Playlist savedPlaylist = repository.save(PlaylistMapper.INSTANCE.toEntity(playlist));
        return PlaylistMapper.INSTANCE.toPostRequest(savedPlaylist);
    }

    public void changePlaylistData(PlaylistPostRequestBody playlist) {
        findPlaylistByIdOrThrowException(playlist.getId());
        repository.save(PlaylistMapper.INSTANCE.toEntity(playlist));
    }
}
