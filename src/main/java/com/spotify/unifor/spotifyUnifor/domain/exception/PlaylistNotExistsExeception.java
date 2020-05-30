package com.spotify.unifor.spotifyUnifor.domain.exception;

public class PlaylistNotExistsExeception extends RuntimeException {

  public PlaylistNotExistsExeception() {
    super("Playlist não existe!");
  }
}
