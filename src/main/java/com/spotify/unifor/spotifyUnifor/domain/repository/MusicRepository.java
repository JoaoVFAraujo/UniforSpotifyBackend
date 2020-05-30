package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Music;
import java.util.List;
import java.util.Optional;

public interface MusicRepository {

  List<Music> listAll();
  Optional<Music> findById(Integer id);

}
