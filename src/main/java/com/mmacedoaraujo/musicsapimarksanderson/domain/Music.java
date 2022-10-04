package com.mmacedoaraujo.musicsapimarksanderson.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "musics")
public class Music implements Serializable {

    @Serial
    private static final long serialVersionUID = 8082975611866057305L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String albumCoverUrl;
    private String musicUrl;
    @ManyToOne
    @JoinColumn(name = "playlist_fk")
    private Playlist playlist;


}
