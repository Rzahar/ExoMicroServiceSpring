package com.example.deplacementpatientinfirmier.repository;

import com.example.deplacementpatientinfirmier.model.Deplacement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface DeplacementRepository extends MongoRepository<Deplacement, String> {
    List<Deplacement> findDeplacementsByIdPatientAndDateAfter(String idPatient,LocalDate currentDate);

    List<Deplacement> findDeplacementByDateAfter(LocalDate currentDate);

    List<Deplacement> findDeplacementsByIdInfirmierAndDateAfter(String idInfirmier, LocalDate currentDate);
}
