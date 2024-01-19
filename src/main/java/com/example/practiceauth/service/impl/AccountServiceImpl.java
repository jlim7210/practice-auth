package com.example.practiceauth.service.impl;

import com.example.practiceauth.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final AccountService accountService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        return this.accountService.processOAuth2User(userRequest);
    }
}
