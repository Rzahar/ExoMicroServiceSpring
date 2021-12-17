package com.example.deplacementpatientinfirmier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeplacementInfirmierPatient {
    private Deplacement deplacement;
    private Infirmier infirmier;
    private Patient patient;

}
