package com.example.deplacementpatientinfirmier.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("deplacement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deplacement {
    @Id
    private String id;
    private Date date;
    private int cout;
    private String idInfirmier;
    private String idPatient;
}
