package com.spotify.unifor.spotifyUnifor.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Playlist {

  private Integer id;
  private String nome;
  private String image;
  private Integer userId;
  private Music[] musicas;

  public static Playlist init() { return new Playlist(); }

  public Playlist withId(Integer id) {
    this.id = id;
    return this;
  }

  public Playlist withNome(String nome) {
    this.nome = nome;
    return this;
  }

  public Playlist withImage(String image) {
    this.image = image;
    return this;
  }

  public Playlist withUserId(Integer userId) {
    this.userId = userId;
    return this;
  }

  public Playlist withMusicas(Music[] musicas) {
    this.musicas = musicas;
    return this;
  }

}
