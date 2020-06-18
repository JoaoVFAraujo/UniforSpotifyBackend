package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.MusicNotExistsException;
import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MusicBusiness {

  @Autowired
  private MusicRepository musicRepository;

  public ResponseEntity<HashMap<String, Object>> listAll() {

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Todas musicas")
        .withBody(this.musicRepository.findAll())
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    this.musicRepository.findById(id).orElseThrow(MusicNotExistsException::new);

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Musica encontrada com sucesso!")
        .withBody(this.musicRepository.findById(id))
        .getResponse(), HttpStatus.OK);
  }

}
