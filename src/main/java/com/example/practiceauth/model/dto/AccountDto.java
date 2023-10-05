package com.example.practiceauth.model.dto;

import com.example.practiceauth.model.entity.Account;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

  private String username;
  private String password;
  private String role;

  public Account toEntity() {
    return Account.builder()
        .username(this.username)
        .password(this.password)
        .role(this.role)
        .build();
  }
}
