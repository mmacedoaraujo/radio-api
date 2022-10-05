package com.mmacedoaraujo.musicsapimarksanderson.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "This field cannot be empty, please specify a name.")
    private String name;
    private String albumCoverUrl;
    @NotEmpty(message = "This field cannot be empty, please specify a valid url.")
    private String musicUrl;

    @ManyToOne
    @JoinColumn(name = "playlist_fk")
    @JsonIgnore
    private Playlist playlistId;


}
