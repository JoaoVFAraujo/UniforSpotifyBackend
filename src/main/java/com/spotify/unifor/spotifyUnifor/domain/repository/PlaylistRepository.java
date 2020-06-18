package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> { }
