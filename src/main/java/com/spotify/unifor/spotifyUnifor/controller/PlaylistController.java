package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import com.spotify.unifor.spotifyUnifor.domain.usecase.PlaylistBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin("http://*")
public class PlaylistController {

  @Autowired
  private PlaylistBusiness playlistBusiness;

  @GetMapping(path = "/playlist")
  private ResponseEntity<HashMap<String, Object>> listAll() {
    return this.playlistBusiness.listAll();
  }

  @PostMapping(path = "/playlist")
  private ResponseEntity<HashMap<String, Object>> save(@RequestBody Playlist playlist) {
    return this.playlistBusiness.save(playlist);
  }

  @GetMapping(path = "/playlist/{id}")
  private ResponseEntity<HashMap<String, Object>> findById(@PathVariable Integer id) {
    return this.playlistBusiness.findById(id);
  }

  @PutMapping(path = "/playlist")
  private ResponseEntity<HashMap<String, Object>> update(@RequestBody Playlist playlist) {
    return this.playlistBusiness.update(playlist);
  }


//  INSERT INTO playlist (nome, image, user_id)
//  VALUES
//  ("Brasil 360", "assets/imgs/playlist/brasil360.jpg", 1),
//  ("Reggaeton 2020", "assets/imgs/playlist/reggaeton2020.jpg", 1),
//  ("Club Queens", "assets/imgs/playlist/clubQueens.jpg", 1),
//  ("Sofrencia Sertaneja", "assets/imgs/playlist/sofrenciaSertaneja.jpg", 1),
//  ("Eletro BR", "assets/imgs/playlist/eletroBR.jpg", 1);

//  INSERT INTO playlist_music (id_playlist, id_musica)
//  VALUES (1, 1), (1, 4), (1, 6), (2, 2), (2, 4), (2, 5), (3, 1), (3, 5), (3, 6), (4, 3), (4, 2), (4, 6), (5, 2), (5, 3), (5, 4);


}
