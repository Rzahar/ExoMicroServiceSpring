package com.example.deplacementpatientinfirmier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String nom;
    private String prenom;
}
