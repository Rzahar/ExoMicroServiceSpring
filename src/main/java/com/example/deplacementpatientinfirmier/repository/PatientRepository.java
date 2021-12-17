package com.example.deplacementpatientinfirmier.repository;

import com.example.deplacementpatientinfirmier.model.Infirmier;
import com.example.deplacementpatientinfirmier.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PatientRepository {
    @Autowired
    private WebClient webClient;
    @Value("${varPatient.port}")
    private String varPatient;
    //Définition d'un mono car on attend une sortie
    public Patient findPatientById(String id){
        Patient patient = webClient.get().uri(varPatient + "/patient/" + id)
                .retrieve()
                .bodyToMono(Patient.class)
                .block();
        return patient;
    }

}
