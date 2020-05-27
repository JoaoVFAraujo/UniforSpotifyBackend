package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.UserExistsException;
import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserBusiness {

  @Inject
  private UserRepository userRepository;

  public User login(User user) {
    return this.userRepository.login(user);
  }

  public User findById(Integer id) {
    return this.userRepository.findById(id);
  }

  public User save(User user) {
    if (userRepository.existsByEmail(user.getEmail())) throw new UserExistsException(user.getEmail());
    return this.userRepository.save(user);
  }

  public User update(User user) {
    return this.userRepository.update(user);
  }

}
