package com.spotify.unifor.spotifyUnifor.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Music {

  private Integer id;
  private String title;
  private String album;
  private Integer tempo;
  private String link;

  public static Music init() {
    return new Music();
  }

  public Music withId(Integer id) {
    this.id = id;
    return this;
  }

  public Music withTitle(String title) {
    this.title = title;
    return this;
  }

  public Music withAlbum(String album) {
    this.album = album;
    return this;
  }

  public Music withTempo(Integer tempo) {
    this.tempo = tempo;
    return this;
  }

  public Music withLink(String link) {
    this.link = link;
    return this;
  }

}
