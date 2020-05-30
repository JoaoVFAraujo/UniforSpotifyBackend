package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;

import java.util.List;

public interface PlaylistRepository {

  List<Playlist> listAll();
  Playlist findById(Integer id);
  Playlist save(Playlist playlist);
  Playlist update(Playlist playlist);

}
