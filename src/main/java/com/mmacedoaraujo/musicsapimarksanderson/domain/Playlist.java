package com.mmacedoaraujo.musicsapimarksanderson.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "playlists")
public class Playlist implements Serializable {

    @Serial
    private static final long serialVersionUID = -6191934812151398962L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String coverUrl;
    @OneToMany(mappedBy = "playlist")
    private List<Music> musicList;
}
