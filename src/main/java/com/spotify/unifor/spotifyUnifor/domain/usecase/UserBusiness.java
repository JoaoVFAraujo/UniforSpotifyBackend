package com.spotify.unifor.spotifyUnifor.domain.usecase;

import com.spotify.unifor.spotifyUnifor.domain.exception.UserExistsException;
import com.spotify.unifor.spotifyUnifor.domain.exception.UserNotExistsException;
import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.security.SecureRandom;
import java.util.HashMap;

@Service
public class UserBusiness {

  @Inject
  private UserRepository userRepository;

  protected static SecureRandom random = new SecureRandom();

  public ResponseEntity<HashMap<String, Object>> login(User user) {

    final User userMock = this.userRepository.login(user);

    HashMap<String, Object> body = new HashMap<String, Object>();
    body.put("userId", userMock.getId());
    body.put("user", userMock);
    body.put("token", this.token());

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Logado com sucesso")
        .withBody(body)
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    if (this.userRepository.findById(id) == null) throw new UserNotExistsException();
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Usuário encontrado com sucesso!")
        .withBody(this.userRepository.findById(id))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> save(User user) {
    if (userRepository.existsByEmail(user.getEmail())) throw new UserExistsException(user.getEmail());
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Usuário cadastrado com sucesso!")
        .withBody(this.userRepository.save(user))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> update(User user) {
    User userMock = this.userRepository.findById(user.getId());
    System.out.println(userMock.getEmail() != user.getEmail());
    System.out.println(userMock.getEmail().toString() != user.getEmail().toString());
    
    if (!(userMock.getEmail().equals(user.getEmail())) && this.userRepository.existsByEmail(user.getEmail())) throw new UserExistsException(user.getEmail());

    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Usuário editado com sucesso")
        .withBody(this.userRepository.update(user))
        .getResponse(), HttpStatus.OK);
  }

  public ResponseEntity<HashMap<String, Object>> listAll() {
    return new ResponseEntity<HashMap<String, Object>>
      (Response.init()
        .withMessage("Todos usuários")
        .withBody(this.userRepository.listAll())
        .getResponse(), HttpStatus.OK);
  }

  String token () {
    long longToken = Math.abs( random.nextLong() );
    String random = Long.toString( longToken, 30 );
    return  random;
  }

}
