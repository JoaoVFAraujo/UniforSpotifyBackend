package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.usecase.MusicBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin("http://*")
public class MusicController {

  @Autowired
  private MusicBusiness musicBusiness;

  @GetMapping(path = "/music")
  ResponseEntity<HashMap<String, Object>> listAll() {
    return musicBusiness.listAll();
  }

  @GetMapping(path = "music/{id}")
  ResponseEntity<HashMap<String, Object>> findById(@PathVariable Integer id) {
    return musicBusiness.findById(id);
  }

}
