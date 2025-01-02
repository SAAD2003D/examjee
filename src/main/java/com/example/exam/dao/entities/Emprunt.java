package com.example.exam.dao.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateEmprunt;
    private Date dateRetourPrevu;
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;
    @ManyToOne(fetch = FetchType.LAZY)
    private Livre livre;
}