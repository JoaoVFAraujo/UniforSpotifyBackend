package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;

public interface UserRepository {

  User login(User user);
  List<User> listAll();
  User findById(Integer id);
  Boolean existsByEmail(String email);
  User save(User user);
  User update(User user);

}
