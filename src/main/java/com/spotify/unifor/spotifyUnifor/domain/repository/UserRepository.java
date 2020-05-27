package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.User;

public interface UserRepository {

  User login(User user);
  User findById(Integer id);
  Boolean existsByEmail(String email);
  User save(User user);
  User update(User user);

}
