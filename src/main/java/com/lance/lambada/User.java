package com.lance.lambada;

import java.util.Optional;

public class User {

  private String name;
  private String id;
  private Boolean active;
  private MemberCard memberCard;

  public User() {}

  public User(String name, String id, Boolean active) {
    this.name = name;
    this.id = id;
    this.active = active;
  }

  public User(String name, String id, Boolean active, MemberCard memberCard) {
    this.name = name;
    this.id = id;
    this.active = active;
    this.memberCard = memberCard;
  }

  public static User of(String name, String id, boolean active) {
    return new User(name, id, active);
  }

  public static User of(String name, String id, boolean active, MemberCard card) {
    return new User(name, id, active, card);
  }

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public Boolean getActive() {
    return active;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MemberCard getMemberCard() {
    return memberCard;
  }

  public Optional<MemberCard> getOptionalMemberCard() {
    return Optional.ofNullable(memberCard);
  }


  public void setMemberCard(MemberCard memberCard) {
    this.memberCard = memberCard;
  }
}
