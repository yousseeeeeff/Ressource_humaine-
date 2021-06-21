package org.sid.teledeclaration.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String N_Num_Affilie ;
    private String N_Num_Assure ;
    private String N_CIN ;
    private String Nom;
    private String Prenom;
    private int   Nbr_Jours;
    private Double N_Sal_Reel;
    private Double N_Sal_Plaf;
    private double N_AF_A_Payer;
    private double N_AF_A_Deduire;
    private double N_AF_A_Net_A_Payer;
    private double N_AF_A_Reserve;
    private String Mdp;
    private String role = "{}";
    private String username ;
    @ManyToMany
    Collection<Declaration> declarations;
    @ManyToOne
    private SocieteF societeF;
}
