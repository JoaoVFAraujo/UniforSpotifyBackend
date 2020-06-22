package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.PlaylistNotExistsExeception;
import com.spotify.unifor.spotifyUnifor.domain.model.Music;
import com.spotify.unifor.spotifyUnifor.domain.model.Playlist;
import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.repository.MusicRepository;
import com.spotify.unifor.spotifyUnifor.domain.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PlaylistBusiness {

  @Autowired
  private PlaylistRepository playlistRepository;
  @Autowired
  private MusicRepository musicRepository;

  public ResponseEntity<HashMap<String, Object>> listAll() {
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Todas playlists")
        .withBody(playlistRepository.findAll())
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> save(Playlist playlist) {

    List<Music> listMusic = new ArrayList<Music>();

    // TRATAR NULL;

    for (Music music: playlist.getMusicas()) {
      Music musicMock = this.musicRepository.findById(music.getId()).get();
      listMusic.add(musicMock);
    }
    playlist.setMusicas(new ArrayList<Music>());
    playlist.setMusicas(listMusic);

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist cadastrada com sucesso!")
        .withBody(this.playlistRepository.save(playlist))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    this.playlistRepository.findById(id).orElseThrow(PlaylistNotExistsExeception::new);

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist encontrada com sucesso!")
        .withBody(this.playlistRepository.findById(id))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> update(Playlist playlist) {
    this.playlistRepository.findById(playlist.getId()).orElseThrow(PlaylistNotExistsExeception::new);

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist atualizada com sucesso!")
        .withBody(this.playlistRepository.save(playlist))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> findByUserId(Integer userId) {

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Playlist encontrada com sucesso!")
        .withBody(this.playlistRepository.findByUserId(userId))
        .getResponse(), HttpStatus.OK);
  }

}
