package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Music;
import java.util.List;

public interface MusicRepository {

  List<Music> listAll();
  Music findById(Integer id);

}
