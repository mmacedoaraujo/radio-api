package com.mmacedoaraujo.musicsapimarksanderson.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "playlist")
    private List<Music> musicList;
}
