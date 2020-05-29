package com.spotify.unifor.spotifyUnifor.domain.model;

import java.util.HashMap;

public class Response <T>{

  private String message;
  private T body;
  private HashMap<String, Object> response = new HashMap<String, Object>();

  public static Response init() {
    return new Response();
  }

  public Response withMessage(String message) {
    this.message = message;
    return this;
  }

  public Response withBody(T body) {
    this.body = body;
    return this;
  }

  public HashMap<String, Object> getResponse() {
    response.put("message", this.message);
    response.put("body", this.body);
    return response;
  }

}
