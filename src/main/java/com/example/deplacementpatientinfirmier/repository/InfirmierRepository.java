package com.example.deplacementpatientinfirmier.repository;

import com.example.deplacementpatientinfirmier.model.Infirmier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class InfirmierRepository {
    @Autowired
    private WebClient webClient;
    @Value("${varInfirmier.port}")
    private String varInfirmier;
    public Infirmier getInfirmierById(String id) {
        Infirmier infirmier = webClient.get().uri(varInfirmier + "/infirmier/" + id)
                .retrieve()
                .bodyToMono(Infirmier.class)
                .block();
        return infirmier;
    }
}