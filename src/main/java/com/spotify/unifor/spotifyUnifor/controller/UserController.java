package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.usecase.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin("*")
public class UserController {

  @Autowired
  private UserBusiness userbusiness;

  @GetMapping(path = "/user/{id}")
  private ResponseEntity<HashMap<String, Object>> findById(@PathVariable Integer id) {
    return userbusiness.findById(id);
  }

  @PostMapping(path = "/login")
  private ResponseEntity<HashMap<String, Object>> login(@RequestBody User user) {
    return userbusiness.login(user);
  }

  @PostMapping(path = "/user")
  private ResponseEntity<HashMap<String, Object>> save(@RequestBody User user) {
    return userbusiness.save(user);
  }

  @PutMapping(path = "/user")
  private ResponseEntity<HashMap<String, Object>> update(@RequestBody User user) { return userbusiness.update(user);  }

  @GetMapping(path = "/user")
  private ResponseEntity<HashMap<String, Object>> listAll() { return userbusiness.listAll(); }

//  INSERT INTO user (nome, email, senha, data, genero, compartilhar_dados)
//  VALUES
//  ("Admin", "admin@teste.com", "admin1234", "1999-03-15 00:00:00", "any", false);
// MODIFICAR SENHA

}
