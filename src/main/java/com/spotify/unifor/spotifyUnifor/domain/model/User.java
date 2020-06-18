package com.spotify.unifor.spotifyUnifor.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @Entity @Table
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String email;
  private String senha;
  private Date data;
  private String genero;
  private Boolean compartilharDados;

  public static User init() {
    return new User();
  }

  public User withId(Integer id) {
    this.id = id;
    return this;
  }

  public User withEmail(String email) {
    this.email = email;
    return this;
  }

  public User withSenha(String senha) {
    this.senha = senha;
    return this;
  }

  public User withNome(String nome) {
    this.nome = nome;
    return this;
  }

  public User withData(Date date) {
    this.data = date;
    return this;
  }

  public User withGenero(String genero) {
    this.genero = genero;
    return this;
  }

  public User withCompartilharDados(Boolean compartilharDados) {
    this.compartilharDados = compartilharDados;
    return this;
  }
}
