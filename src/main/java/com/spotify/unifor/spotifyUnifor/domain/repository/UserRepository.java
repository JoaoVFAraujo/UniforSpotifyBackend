package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  List<User> listAll();
  Optional<User> findById(Integer id);
  Optional<User> save(User user);
  Optional<User> update(User user);

  Optional<User> login(User user);
  Boolean existsByEmail(String email);

}
