package com.spotify.unifor.spotifyUnifor.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Entity @Table
public class Playlist {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String image;
  private Integer userId;
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
  @JoinTable(name = "playlist_music", joinColumns = @JoinColumn(name = "id_playlist", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_musica", referencedColumnName = "id"))
  private List<Music> musicas;

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

  public Playlist withMusicas(List<Music> musicas) {
    this.musicas = musicas;
    return this;
  }

}
