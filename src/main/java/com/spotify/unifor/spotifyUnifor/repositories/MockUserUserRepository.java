package com.spotify.unifor.spotifyUnifor.repositories;

import com.spotify.unifor.spotifyUnifor.domain.exception.UserAuthenticateException;
import com.spotify.unifor.spotifyUnifor.domain.model.Response;
import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.inject.Named;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Named
public class MockUserUserRepository implements UserRepository {

  protected static SecureRandom random = new SecureRandom();

  private HashMap<Integer, User> users = new HashMap<>();
  {
    users.put(1, User.init().withId(1).withNome("Joao").withEmail("joao@teste.com").withSenha("teste123"));
    users.put(2, User.init().withId(2).withNome("Enilton").withEmail("enilton@teste.com").withSenha("teste321"));
    users.put(3, User.init().withId(3).withNome("Davi").withEmail("davi@teste.com").withSenha("123teste"));
  }

  @Override
  public ResponseEntity<HashMap<String, Object>> login(User user) {
    final User login = this.users.entrySet().stream()
      .filter(
        entry ->  Objects.equals(entry.getValue().getEmail(), user.getEmail()) &&
          Objects.equals(entry.getValue().getSenha(), user.getSenha())
      )
      .map(Map.Entry::getValue)
      .findFirst()
      .orElseThrow(UserAuthenticateException::new);


    HashMap<String, Object> body = new HashMap<String, Object>();
    body.put("userId", login.getId());
    body.put("user", login);
    body.put("token", this.token());

    return new ResponseEntity<HashMap<String, Object>>(Response.init().withMessage("Logado com sucesso").withBody(body).getResponse(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<HashMap<String, Object>> findById(Integer id) {
    return new ResponseEntity<HashMap<String, Object>>(Response.init().withMessage("Usuário encontrado com sucesso!").withBody(this.users.get(id)).getResponse(), HttpStatus.OK);
  }

  @Override
  public Boolean existsByEmail(String email) {
    return this.users.entrySet().stream()
      .filter(
        entry -> Objects.equals(entry.getValue().getEmail(), email)
      )
      .map(Map.Entry::getValue)
      .findFirst()
      .isPresent();
  }

  @Override
  public ResponseEntity<HashMap<String, Object>> save(User user) {
    final Integer id = this.users.size() + 1;
    final User userMock =  user.withId(id);

    this.users.put(id, userMock);
    return new ResponseEntity<HashMap<String, Object>>(Response.init().withMessage("Usuário cadastrado com sucesso!").withBody(userMock).getResponse(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<HashMap<String, Object>> update(User user) {
    User userMock = (User) findById(user.getId()).getBody().get("body");

    userMock.setNome(user.getNome());
    userMock.setEmail(user.getEmail());
    userMock.setSenha(user.getSenha());
    userMock.setData(user.getData());
    userMock.setGenero(user.getGenero());
    userMock.setCompartilharDados(user.getCompartilharDados());

    this.users.put(userMock.getId(), userMock);

    return new ResponseEntity<HashMap<String, Object>>(Response.init().withMessage("Usuário editado com sucesso").withBody(userMock).getResponse(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<HashMap<String, Object>> listAll() {
    return new ResponseEntity<HashMap<String, Object>>(Response.init().withMessage("Todos usuários").withBody(this.users.values()).getResponse(), HttpStatus.OK);
  }

  String token () {
    long longToken = Math.abs( random.nextLong() );
    String random = Long.toString( longToken, 30 );
    return  random;
  }

}
