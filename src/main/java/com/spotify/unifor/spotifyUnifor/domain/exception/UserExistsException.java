package com.spotify.unifor.spotifyUnifor.domain.exception;

public class UserExistsException extends RuntimeException {

  public UserExistsException(String email) {
    super(String.format("Usuário com email %s já existe", email));
  }
}
