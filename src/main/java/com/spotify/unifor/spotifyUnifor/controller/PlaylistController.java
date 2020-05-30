package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.usecase.PlaylistBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
