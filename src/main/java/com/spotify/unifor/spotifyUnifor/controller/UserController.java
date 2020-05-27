package com.spotify.unifor.spotifyUnifor.controller;

import com.spotify.unifor.spotifyUnifor.domain.model.User;
import com.spotify.unifor.spotifyUnifor.domain.usecase.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://*")
public class UserController {

  @Autowired
  private UserBusiness userbusiness;

  @GetMapping(path = "/user/{id}")
  private User findById(@PathVariable Integer id) {
    return userbusiness.findById(id);
  }

  @PostMapping(path = "/login")
  private User login(@RequestBody User user) {
    return userbusiness.login(user);
  }

  @PostMapping(path = "/user")
  private User save(@RequestBody User user) {
    return userbusiness.save(user);
  }

  @PutMapping(path = "/user")
  private User update(@RequestBody User user) {
    return userbusiness.update(user);
  }

}
