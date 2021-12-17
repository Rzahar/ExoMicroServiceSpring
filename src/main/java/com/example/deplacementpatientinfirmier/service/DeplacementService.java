package com.example.deplacementpatientinfirmier.service;

import com.example.deplacementpatientinfirmier.model.Deplacement;
import com.example.deplacementpatientinfirmier.model.DeplacementInfirmierPatient;
import com.example.deplacementpatientinfirmier.model.Infirmier;
import com.example.deplacementpatientinfirmier.model.Patient;
import com.example.deplacementpatientinfirmier.repository.DeplacementRepository;
import com.example.deplacementpatientinfirmier.repository.InfirmierRepository;
import com.example.deplacementpatientinfirmier.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeplacementService {
    public List<Deplacement> findDeplacementNext;
    @Autowired
    DeplacementRepository repository;

    @Autowired
    InfirmierRepository infirmierRepository;

    @Autowired
    PatientRepository patientRepository;

    //Permet d'afficher la liste de tous les déplacements
    public List<Deplacement> findAll() {
        return repository.findAll();
    }

    //Permet d'afficher un déplacement en fonction de l'id d'un déplacement
    public Deplacement findOne(String id){
        return repository.findById(id).get();
    }

    public List<Deplacement> findOneAndOnly(String id){
        return findByIdPatient(id);
    }

    // Afficher les déplacements futurs
    public List<Deplacement> findNext() {
        LocalDate currentDate = LocalDate.now();
        List<Deplacement> deplacements =
                repository.findDeplacementByDateAfter(currentDate);
        return deplacements;
    }

    //Permet d'afficher une liste de déplacement en fonction de l'id du patient
    public List<Deplacement> findByIdPatient(String idPatient){
        LocalDate currentDate = LocalDate.now();
        return repository.findDeplacementsByIdPatientAndDateAfter(idPatient, currentDate);
    }

    //Permet d'afficher une liste de déplacement en fonction de l'id de l'infirmier
    public List<Deplacement> findByIdInfirmier(String idInfirmier){
        LocalDate currentDate = LocalDate.now();
        return repository.findDeplacementsByIdInfirmierAndDateAfter(idInfirmier, currentDate);
    }

    public Deplacement save(Deplacement deplacement) {return repository.save(deplacement);}

    public Deplacement update(Deplacement deplacement) {return repository.save(deplacement);}

    public void delete(String id) {repository.deleteById(id);}

    //Permet d'afficher les détails d'un deplacement
   public DeplacementInfirmierPatient getDetail(String idDeplacement){
        DeplacementInfirmierPatient deplacementInfirmierPatient = null;
        Deplacement deplacement = repository.findById(idDeplacement).get();
        Infirmier infirmier = infirmierRepository.getInfirmierById(deplacement.getIdInfirmier());
        Patient patient = patientRepository.findPatientById(deplacement.getIdPatient());
        deplacementInfirmierPatient = new DeplacementInfirmierPatient(deplacement,infirmier,patient);


        return deplacementInfirmierPatient;
   }

}


