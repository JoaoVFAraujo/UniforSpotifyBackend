package com.spotify.unifor.spotifyUnifor.domain.model;

import java.util.Date;

public class User {

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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Boolean getCompartilharDados() {
    return compartilharDados;
  }

  public void setCompartilharDados(Boolean compartilharDados) {
    this.compartilharDados = compartilharDados;
  }
}
