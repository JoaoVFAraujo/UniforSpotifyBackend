package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface PlaylistRepository {

  List<Playlist> listAll();

}
