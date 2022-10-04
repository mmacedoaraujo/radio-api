package com.mmacedoaraujo.musicsapimarksanderson.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String albumCover;
    private String musicUrl;
    @ManyToOne
    @JoinColumn(name = "playlist_fk")
    private Playlist playlist;


}
