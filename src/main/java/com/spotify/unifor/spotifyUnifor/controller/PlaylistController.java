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
  ResponseEntity<HashMap<String, Object>> listAll() {
    return this.playlistBusiness.listAll();
  }

  @PostMapping(path = "/playlist")
  ResponseEntity<HashMap<String, Object>> save(@RequestBody Playlist playlist) {
    return this.playlistBusiness.save(playlist);
  }

  @GetMapping(path = "/playlist/{id}")
  ResponseEntity<HashMap<String, Object>> findById(@PathVariable Integer id) {
    return this.playlistBusiness.findById(id);
  }

  @PutMapping(path = "/playlist")
  ResponseEntity<HashMap<String, Object>> update(@RequestBody Playlist playlist) {
    return this.playlistBusiness.update(playlist);
  }

  }
