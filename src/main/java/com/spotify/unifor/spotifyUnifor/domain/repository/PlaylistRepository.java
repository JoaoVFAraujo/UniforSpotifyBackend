package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
  List<Playlist> findByUserId(Integer userId);
}
