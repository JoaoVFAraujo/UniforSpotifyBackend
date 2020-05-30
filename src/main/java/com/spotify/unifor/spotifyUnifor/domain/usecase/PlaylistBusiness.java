package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.repository.PlaylistRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;

@Service
public class PlaylistBusiness {

  @Inject
  private PlaylistRepository playlistRepository;

  public ResponseEntity<HashMap<String, Object>> listAll() {
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Todas playlists")
        .withBody(playlistRepository.listAll())
        .getResponse(), HttpStatus.OK);
  }

}
