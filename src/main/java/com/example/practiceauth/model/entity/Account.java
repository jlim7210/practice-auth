package com.example.practiceauth.model.entity;

import com.example.practiceauth.model.dto.AccountDto;
import com.example.practiceauth.model.entity.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {

  private String username;
  private String password;
  private String role;

  public AccountDto toDto() {
    return AccountDto.builder()
        .username(this.username)
        .password(this.password)
        .role(this.role)
        .build();
  }
}
