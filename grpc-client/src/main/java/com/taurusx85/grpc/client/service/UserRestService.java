package com.taurusx85.grpc.client.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserRestService {

    private RestTemplate restTemplate;

    public UserRestService() {
        this.restTemplate = new RestTemplate();
    }

    public Integer createUser(String userName) {
        Integer id = restTemplate.postForObject("http://localhost:9090/users-rest", userName, Integer.class);
        log.info("Created user with id - {}", id);
        return id;
    }
}
