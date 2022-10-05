package com.mmacedoaraujo.musicsapimarksanderson.mapper;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Playlist;
import com.mmacedoaraujo.musicsapimarksanderson.requests.MusicPostRequestBody;
import com.mmacedoaraujo.musicsapimarksanderson.requests.PlaylistPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    public static final PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    Playlist toEntity(PlaylistPostRequestBody playlistPostRequestBody);

    PlaylistPostRequestBody toPostRequest(Playlist playlist);

    List<PlaylistPostRequestBody> toListPostRequest(List<Playlist> playlistList);

}
