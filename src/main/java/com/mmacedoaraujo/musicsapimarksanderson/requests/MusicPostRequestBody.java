package com.mmacedoaraujo.musicsapimarksanderson.requests;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmacedoaraujo.musicsapimarksanderson.domain.Playlist;
import lombok.Data;
import org.mapstruct.Mapping;

import javax.validation.constraints.NotEmpty;

@Data
public class MusicPostRequestBody {

    private Long id;
    @NotEmpty(message = "The name cannot be empty")
    private String name;
    private String albumCoverUrl;
    @NotEmpty(message = "The music url cannot be empty")
    private String musicUrl;
    private Long playlistId;
}
