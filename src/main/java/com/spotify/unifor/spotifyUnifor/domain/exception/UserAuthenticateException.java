package com.spotify.unifor.spotifyUnifor.domain.exception;

public class UserAuthenticateException extends RuntimeException {

  public UserAuthenticateException() {
    super("Usuário não autenticado!");
  }
}
