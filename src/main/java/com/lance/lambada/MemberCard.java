package com.lance.lambada;

import lombok.Data;

@Data
public class MemberCard {
  String cardId;

  public MemberCard(String cardId) {
    this.cardId = cardId;
  }
}
