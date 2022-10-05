package com.mmacedoaraujo.musicsapimarksanderson.controller;

import com.mmacedoaraujo.musicsapimarksanderson.requests.PlaylistPostRequestBody;
import com.mmacedoaraujo.musicsapimarksanderson.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService service;

    @GetMapping
    public ResponseEntity<List<PlaylistPostRequestBody>> listAllPlaylists() {
        return new ResponseEntity<>(service.listAllPlaylists(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlaylistPostRequestBody> findPlaylistById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findPlaylistByIdOrThrowException(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlaylistPostRequestBody> createNewPlaylist(@RequestBody @Valid PlaylistPostRequestBody playlist) {
        return new ResponseEntity<>(service.createNewPlaylist(playlist), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        service.deletePlaylist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> changePlaylistData(@RequestBody PlaylistPostRequestBody playlist) {
        service.changePlaylistData(playlist);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
