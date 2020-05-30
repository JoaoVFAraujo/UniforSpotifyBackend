package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository {

  List<Playlist> listAll();
  Optional<Playlist> findById(Integer id);
  Optional<Playlist> save(Playlist playlist);
  Optional<Playlist> update(Playlist playlist);

}
