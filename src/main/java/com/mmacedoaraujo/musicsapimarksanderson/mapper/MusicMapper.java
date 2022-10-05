package com.mmacedoaraujo.musicsapimarksanderson.mapper;

import com.mmacedoaraujo.musicsapimarksanderson.domain.Music;
import com.mmacedoaraujo.musicsapimarksanderson.requests.MusicPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MusicMapper {

    public static final MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);

    Music toMusic(MusicPostRequestBody musicPostRequestBody);

    MusicPostRequestBody toPostRequest(Music music);

    List<MusicPostRequestBody> toPostRequestList(List<Music> musicList);
}
