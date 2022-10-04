package com.mmacedoaraujo.musicsapimarksanderson.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MusicPostRequestBody {

    private Long id;
    @NotEmpty(message = "The name cannot be empty")
    private String name;
    private String albumCoverUrl;
    @NotEmpty(message = "The music url cannot be empty")
    private String musicUrl;
}
