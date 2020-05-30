package com.spotify.unifor.spotifyUnifor.repositories;

import com.spotify.unifor.spotifyUnifor.domain.model.Music;
import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.repository.MusicRepository;
import com.spotify.unifor.spotifyUnifor.domain.repository.PlaylistRepository;
import com.spotify.unifor.spotifyUnifor.domain.usecase.MusicBusiness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
public class MockPlaylistRepository implements PlaylistRepository {

  private HashMap<Integer, Playlist> playlists = new HashMap<>();
  {
    playlists.put(1, Playlist.init().withId(1).withNome("Brasil 360")
      .withImage("assets/imgs/playlist/brasil360.jpg").withUserId(1));

    playlists.put(2, Playlist.init().withId(2).withNome("Reggaeton 2020")
      .withImage("assets/imgs/playlist/reggaeton2020.jpg").withUserId(1));

    playlists.put(3, Playlist.init().withId(3).withNome("Club Queens")
      .withImage("assets/imgs/playlist/clubQueens.jpg").withUserId(1));

    playlists.put(4, Playlist.init().withId(4).withNome("Sofrencia Sertaneja")
      .withImage("assets/imgs/playlist/sofrenciaSertaneja.jpg").withUserId(1));

    playlists.put(5, Playlist.init().withId(5).withNome("Eletro BR")
      .withImage("assets/imgs/playlist/eletroBR.jpg").withUserId(1));
  }

  @Override
  public List<Playlist> listAll() {
    return playlists.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
  }
}
