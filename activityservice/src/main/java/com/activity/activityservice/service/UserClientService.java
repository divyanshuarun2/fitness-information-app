package com.activity.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserClientService {
    private final WebClient userServiceWebClient;

    public Boolean trackActivity(String userId) {
        try{
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

        }
        catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

}
