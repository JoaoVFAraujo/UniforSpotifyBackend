package com.spotify.unifor.spotifyUnifor.domain.exception;

public class UserNotExistsException extends RuntimeException {

  public UserNotExistsException() { super("Usuário não encontrado!"); }
}
