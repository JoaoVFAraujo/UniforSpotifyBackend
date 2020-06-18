//package com.spotify.unifor.spotifyUnifor.repositories;
//
//import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
//import com.spotify.unifor.spotifyUnifor.domain.repository.PlaylistRepository;
//
//import javax.inject.Named;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Named
//public class MockPlaylistRepository implements PlaylistRepository {
//
//  private HashMap<Integer, Playlist> playlists = new HashMap<>();
//  {
//    playlists.put(1, Playlist.init().withId(1).withNome("Brasil 360")
//      .withImage("assets/imgs/playlist/brasil360.jpg").withUserId(1));
//
//    playlists.put(2, Playlist.init().withId(2).withNome("Reggaeton 2020")
//      .withImage("assets/imgs/playlist/reggaeton2020.jpg").withUserId(1));
//
//    playlists.put(3, Playlist.init().withId(3).withNome("Club Queens")
//      .withImage("assets/imgs/playlist/clubQueens.jpg").withUserId(1));
//
//    playlists.put(4, Playlist.init().withId(4).withNome("Sofrencia Sertaneja")
//      .withImage("assets/imgs/playlist/sofrenciaSertaneja.jpg").withUserId(1));
//
//    playlists.put(5, Playlist.init().withId(5).withNome("Eletro BR")
//      .withImage("assets/imgs/playlist/eletroBR.jpg").withUserId(1));
//  }
//
//  @Override
//  public List<Playlist> listAll() {
//    return playlists.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//  }
//
//  @Override
//  public Optional<Playlist> save(Playlist playlist) {
//    final Integer id = this.playlists.size() + 1;
//    Playlist playlistMock = playlist.withId(id);
//
//    this.playlists.put(id, playlistMock);
//    return Optional.of(playlistMock);
//  }
//
//  @Override
//  public Optional<Playlist> findById(Integer id) {
//    return Optional.ofNullable(this.playlists.get(id));
//  }
//
//    @Override
//  public Optional<Playlist> update(Playlist playlist) {
//    Playlist playlistMock = this.findById(playlist.getId()).get();
//
//    playlistMock.setNome(playlist.getNome());
//    playlistMock.setImage(playlist.getImage());
//    playlistMock.setUserId(playlist.getUserId());
//    playlistMock.setMusicas(playlist.getMusicas());
//
//    this.playlists.put(playlistMock.getId(), playlistMock);
//
//    return Optional.of(playlistMock);
//  }
//}
