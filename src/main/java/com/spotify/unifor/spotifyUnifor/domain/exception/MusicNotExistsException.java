package com.spotify.unifor.spotifyUnifor.domain.exception;

public class MusicNotExistsException extends RuntimeException {

  public MusicNotExistsException() { super("Musica não encontrada!"); }

}
