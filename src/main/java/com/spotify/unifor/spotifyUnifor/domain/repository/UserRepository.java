package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

public interface UserRepository {

  ResponseEntity<HashMap<String, Object>> login(User user);
  ResponseEntity<HashMap<String, Object>> listAll();
  ResponseEntity<HashMap<String, Object>> findById(Integer id);
  Boolean existsByEmail(String email);
  ResponseEntity<HashMap<String, Object>> save(User user);
  ResponseEntity<HashMap<String, Object>> update(User user);

}
