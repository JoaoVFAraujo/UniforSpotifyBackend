package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.PlaylistNotExistsExeception;
import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
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

  public ResponseEntity<HashMap<String, Object>> save(Playlist playlist) {
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist cadastrada com sucesso!")
        .withBody(this.playlistRepository.save(playlist))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    if (this.playlistRepository.findById(id) == null) throw new PlaylistNotExistsExeception();

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist encontrada com sucesso!")
        .withBody(this.playlistRepository.findById(id))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> update(Playlist playlist) {
    if (this.playlistRepository.findById(playlist.getId()) == null) throw new PlaylistNotExistsExeception();

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist atualizada com sucesso!")
        .withBody(this.playlistRepository.update(playlist))
        .getResponse(), HttpStatus.OK);
  }

}
