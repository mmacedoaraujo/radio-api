package com.mmacedoaraujo.musicsapimarksanderson.requests;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistPostRequestBody {

    private Long id;
    private String name;
    private String description;
    private String coverUrl;
    private List<Music> musicList;
}
