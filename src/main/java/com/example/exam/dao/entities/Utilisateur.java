package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nom ;
    private String prenom ;
    private String email ;
    @OneToMany(mappedBy = "utilisateur")
    private List<Livre> livres = new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur")
    private List<Emprunt> emprunts = new ArrayList<>();

}