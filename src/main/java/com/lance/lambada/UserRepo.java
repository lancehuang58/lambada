package com.lance.lambada;

import static java.util.Optional.ofNullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepo {
  // lambada
  // user could be null
  public String getUserName(String uid) {
    return ofNullable(findUserById(uid))
            .map(User::getName)
            .orElse("");
  }

  private User findUserById(String uid) {
    if (uid.startsWith("L")) {
      User user = new User();
      user.setName("lance");
      return user;
    }
    return null;
  }

  public List<User> getUsers() {
    List<User> users = new ArrayList<>();
    User user = User.of("Lance Huang", "UnOT", true);
    users.add(user);
    User user2 = User.of("Lance Huang", "UnOT", true, new MemberCard(UUID.randomUUID().toString()));
    users.add(user2);
    return users;
  }
}
