package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.model.Music;
import com.spotify.unifor.spotifyUnifor.domain.usecase.MusicBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
public class MusicController {

  @Autowired
  private MusicBusiness musicBusiness;

  @GetMapping(path = "/music")
  private ResponseEntity<HashMap<String, Object>> listAll() {
    return musicBusiness.listAll();
  }

  @GetMapping(path = "music/{id}")
  private ResponseEntity<HashMap<String, Object>> findById(@PathVariable Integer id) {
    return musicBusiness.findById(id);
  }

  @PostMapping(path = "/music")
  private ResponseEntity<HashMap<String, Object>> saveAll(@RequestBody Music music) {
    return this.musicBusiness.save(music);
  }

//  INSERT INTO music (title, album, tempo, link)
//  VALUES
//  ("The Neighbourhood - Sweater Weather", "AA", 249, "assets/mp3/sweater-weather.mp3"),
//  ("EDEN - drugs", "BB", 360, "assets/mp3/drugs.mp3"),
//  ("Axel Thesleff - Bad Karma", "CC", 426, "assets/mp3/bad-karma.mp3"),
//  ("Breakbot - Baby I'm Yours", "DD", 138, "assets/mp3/baby-im-yours.mp3"),
//  ("Petit Biscuit - Sunset Lover", "EE", 201, "assets/mp3/sunset-lover.mp3"),
//  ("Kygo - Firestone", "FF", 207, "assets/mp3/firestone.mp3");

}
