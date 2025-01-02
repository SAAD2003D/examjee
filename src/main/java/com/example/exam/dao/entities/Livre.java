package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String auteur;
    private String isbn;
    private Date datPublication;
    private TypeStatus statut ;
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "livre")
    private List<Emprunt> emprunts = new ArrayList<>();

}
