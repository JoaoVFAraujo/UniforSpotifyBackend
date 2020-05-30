package com.spotify.unifor.spotifyUnifor.domain.repository;

import com.spotify.unifor.spotifyUnifor.domain.model.User;

import java.util.List;

public interface UserRepository {

  List<User> listAll();
  User findById(Integer id);
  User save(User user);
  User update(User user);

  User login(User user);
  Boolean existsByEmail(String email);

}
