//package com.spotify.unifor.spotifyUnifor.repositories;
//
//import com.spotify.unifor.spotifyUnifor.domain.model.User;
//import com.spotify.unifor.spotifyUnifor.domain.repository.UserRepository;
//
//import javax.inject.Named;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Named
//public class MockUserRepository implements UserRepository {
//
//  private HashMap<Integer, User> users = new HashMap<>();
//  {
//    users.put(1, User.init().withId(1).withNome("Joao").withEmail("joao@teste.com").withSenha("teste123")
//      .withData(new Date()).withGenero(("m")).withCompartilharDados(false));
//
//    users.put(2, User.init().withId(2).withNome("Enilton").withEmail("enilton@teste.com").withSenha("teste321")
//      .withData(new Date()).withGenero(("m")).withCompartilharDados(true));
//
//    users.put(3, User.init().withId(3).withNome("Marina").withEmail("marina@teste.com").withSenha("123teste")
//      .withData(new Date()).withGenero(("f")).withCompartilharDados(false));
//  }
//
//  @Override
//  public Optional<User> login(User user) {
//    return this.users.entrySet().stream()
//      .filter(
//        entry ->  Objects.equals(entry.getValue().getEmail(), user.getEmail()) &&
//          Objects.equals(entry.getValue().getSenha(), user.getSenha())
//      )
//      .map(Map.Entry::getValue)
//      .findFirst();
//  }
//
//  @Override
//  public Optional<User> findById(Integer id) {
//    return Optional.ofNullable(this.users.get(id));
//  }
//
//  @Override
//  public Boolean existsByEmail(String email) {
//    return this.users.entrySet().stream()
//      .filter(
//        entry -> Objects.equals(entry.getValue().getEmail(), email)
//      )
//      .map(Map.Entry::getValue)
//      .findFirst()
//      .isPresent();
//  }
//
//  @Override
//  public Optional<User> save(User user) {
//    final Integer id = this.users.size() + 1;
//    final User userMock = user.withId(id);
//
//    this.users.put(id, userMock);
//    return Optional.of(userMock);
//  }
//
//  @Override
//  public Optional<User> update(User user) {
//    User userMock = this.findById(user.getId()).get();
//
//    userMock.setNome(user.getNome());
//    userMock.setEmail(user.getEmail());
//    userMock.setSenha(user.getSenha());
//    userMock.setData(user.getData());
//    userMock.setGenero(user.getGenero());
//    userMock.setCompartilharDados(user.getCompartilharDados());
//
//    this.users.put(userMock.getId(), userMock);
//
//    return Optional.of(userMock);
//  }
//
//  @Override
//  public List<User> listAll() {
//    return users.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//  }
//
//}
