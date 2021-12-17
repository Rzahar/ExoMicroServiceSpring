package com.example.deplacementpatientinfirmier.controller;

import com.example.deplacementpatientinfirmier.model.Deplacement;
import com.example.deplacementpatientinfirmier.model.DeplacementInfirmierPatient;
import com.example.deplacementpatientinfirmier.service.DeplacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("deplacement")
public class DeplacementController {

    @Autowired
    DeplacementService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    //Renvoie l'ensemble des déplacements recensés dans la BDD
    public List<Deplacement> findAll() {return service.findAll();}

    //Recuperation des données d'un déplacement en fonction de son id
    @GetMapping("/{id}")
    public Deplacement findOne(@PathVariable String id) {
        return service.findOne(id);
    }

    //Recuperation des déplacements d'un infirmier en fonction de son id
    @GetMapping("/patient/{id}")
    public List<Deplacement> findByPatientId(@PathVariable String id) { return service.findByIdPatient(id);}

    //Recuperation des déplacements d'un infirmier en fonction de son id
    @GetMapping("/infirmier/{id}")
    public List<Deplacement> findByInfirmierId(@PathVariable String id) { return service.findByIdInfirmier(id);}

    //Affichage du déplacement suivant après la date indiquée
    @GetMapping("/next/")
    public List<Deplacement> findNext() { return service.findNext();}

    //Affichage des détails
    @GetMapping("/details/{id}")
    public DeplacementInfirmierPatient getDetail(@PathVariable String id ) { return service.getDetail(id);}

    //Create/Update/Date :
    //Creation d'un déplacement
    @PostMapping()
    public Deplacement create(@RequestBody Deplacement deplacement) {return service.save(deplacement);}

    //MAJ d'un déplacement
    @PutMapping()
    public Deplacement update(Deplacement deplacement){
        return service.save(deplacement);
    }

    //Suppression d'un déplacement
    @DeleteMapping()
    public ResponseEntity<String> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.ok("Supression réussie");
    }

}
