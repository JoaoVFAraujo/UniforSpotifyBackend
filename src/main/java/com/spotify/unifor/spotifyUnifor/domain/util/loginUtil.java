package com.spotify.unifor.spotifyUnifor.domain.util;

import org.springframework.security.providers.encoding.Md5PasswordEncoder;

public class loginUtil {

  static Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

  public static String enconde(String password) {
    md5PasswordEncoder = new Md5PasswordEncoder();

    return md5PasswordEncoder.encodePassword(password, null);
  }

}
