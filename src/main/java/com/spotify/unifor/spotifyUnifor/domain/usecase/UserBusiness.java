package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.UserExistsException;
import com.spotify.unifor.spotifyUnifor.domain.exception.UserNotExistsException;
import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;

@Service
public class UserBusiness {

  @Inject
  private UserRepository userRepository;

  public ResponseEntity<HashMap<String, Object>> login(User user) {
    return this.userRepository.login(user);
  }

  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    if (this.userRepository.findById(id).getBody().get("body") == null) throw new UserNotExistsException();
    return this.userRepository.findById(id);
  }

  public ResponseEntity<HashMap<String, Object>> save(User user) {
    if (userRepository.existsByEmail(user.getEmail())) throw new UserExistsException(user.getEmail());
    return this.userRepository.save(user);
  }

  public ResponseEntity<HashMap<String, Object>> update(User user) {
    return this.userRepository.update(user);
  }

  public ResponseEntity<HashMap<String, Object>> listAll() {
    return this.userRepository.listAll();
  }

}
