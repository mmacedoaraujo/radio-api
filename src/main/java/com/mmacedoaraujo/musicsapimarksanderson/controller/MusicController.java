package com.mmacedoaraujo.musicsapimarksanderson.controller;

import com.mmacedoaraujo.musicsapimarksanderson.requests.MusicPostRequestBody;
import com.mmacedoaraujo.musicsapimarksanderson.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/musics")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService service;

    @GetMapping
    public ResponseEntity<List<MusicPostRequestBody>> listAll() {
        List<MusicPostRequestBody> musicList = service.listAll();

        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<MusicPostRequestBody>> findMusic(@RequestParam String name) {
        return new ResponseEntity<>(service.findMusic(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MusicPostRequestBody> insert(@RequestBody @Valid MusicPostRequestBody musicPostRequestBody) {
        return new ResponseEntity<>(service.createNewMusic(musicPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replaceMusic(@RequestBody MusicPostRequestBody musicPostRequestBody) {
        service.replace(musicPostRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
