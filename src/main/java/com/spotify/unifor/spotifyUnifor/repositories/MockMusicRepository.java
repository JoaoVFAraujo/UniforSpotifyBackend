//package com.spotify.unifor.spotifyUnifor.repositories;
//
//import com.spotify.unifor.spotifyUnifor.domain.model.Music;
//import com.spotify.unifor.spotifyUnifor.domain.repository.MusicRepository;
//
//import javax.inject.Named;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Named
//public class MockMusicRepository implements MusicRepository {
//
//  private HashMap<Integer, Music> musics = new HashMap<>();
//  {
//    musics.put(1, Music.init().withId(1).withTitle("The Neighbourhood - Sweater Weather").withAlbum("AA")
//      .withTempo(249).withLink("assets/mp3/sweater-weather.mp3"));
//
//    musics.put(2, Music.init().withId(2).withTitle("EDEN - drugs").withAlbum("BB")
//      .withTempo(360).withLink("assets/mp3/sweater-weather.mp3"));
//
//    musics.put(3, Music.init().withId(3).withTitle("Axel Thesleff - Bad Karma").withAlbum("CC")
//      .withTempo(426).withLink("assets/mp3/sweater-weather.mp3"));
//
//    musics.put(4, Music.init().withId(4).withTitle("Breakbot - Baby I'm Yours").withAlbum("DD")
//      .withTempo(138).withLink("assets/mp3/sweater-weather.mp3"));
//
//    musics.put(5, Music.init().withId(5).withTitle("Petit Biscuit - Sunset Lover").withAlbum("EE")
//      .withTempo(201).withLink("assets/mp3/sweater-weather.mp3"));
//
//    musics.put(6, Music.init().withId(6).withTitle("Kygo - Firestone").withAlbum("FF")
//      .withTempo(207).withLink("assets/mp3/sweater-weather.mp3"));
//  }
//
//  @Override
//  public List<Music> listAll() {
//    return this.musics.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//  }
//
//  @Override
//  public Optional<Music> findById(Integer id) {
//
//    return Optional.ofNullable(this.musics.get(id));
//  }
//}
