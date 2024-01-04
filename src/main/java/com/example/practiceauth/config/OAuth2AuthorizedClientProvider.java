package com.example.practiceauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2AuthorizedClientProvider {
    private final OAuth2AuthorizedClientService authorizedClientService;

    public OAuth2AuthorizedClient getAuthorizedClient(String clientRegistrationId, Authentication principal) {
        return authorizedClientService.loadAuthorizedClient(clientRegistrationId, principal.getName());
    }
}
