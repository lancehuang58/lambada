package com.lance.lambada;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo {

  public static void main(String[] args) {
    UserRepo repo = new UserRepo();
    List<User> users = repo.getUsers();
    Set<String> cardIds = users.stream()
        .map(user -> user.getOptionalMemberCard().map(MemberCard::getCardId).orElse(""))
        .collect(Collectors.toSet());
    System.out.println("cardIds = " + cardIds);
  }
}
