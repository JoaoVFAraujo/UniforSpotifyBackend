package com.spotify.unifor.spotifyUnifor.repositories;


import com.spotify.unifor.spotifyUnifor.domain.exception.UserAuthenticateException;
import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Named
public class MockUserUserRepository implements UserRepository {

  private HashMap<Integer, User> users = new HashMap<>();
  {
    users.put(1, User.init().withId(1).withNome("Joao").withEmail("joao@teste.com").withSenha("teste123"));
    users.put(2, User.init().withId(2).withNome("Enilton").withEmail("enilton@teste.com").withSenha("teste321"));
    users.put(3, User.init().withId(3).withNome("Davi").withEmail("davi@teste.com").withSenha("123teste"));
  }

  @Override
  public User login(User user) {
    return this.users.entrySet().stream()
      .filter(
        entry ->  Objects.equals(entry.getValue().getEmail(), user.getEmail()) &&
                  Objects.equals(entry.getValue().getSenha(), user.getSenha())
      )
      .map(Map.Entry::getValue)
      .findFirst()
      .orElseThrow(UserAuthenticateException::new);
  }

  @Override
  public User findById(Integer id) {
    return this.users.get(id);
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
  public User save(User user) {
    final Integer id = this.users.size() + 1;
    final User userMock =  user.withId(id);

    this.users.put(id, userMock);
    return userMock;
  }

  @Override
  public User update(User user) {
    User userMock = findById(user.getId());

    userMock.setNome(user.getNome());
    userMock.setEmail(user.getEmail());
    userMock.setSenha(user.getSenha());
    userMock.setData(user.getData());
    userMock.setGenero(user.getGenero());
    userMock.setCompartilharDados(user.getCompartilharDados());

    this.users.put(userMock.getId(), userMock);

    return userMock;
  }
}
