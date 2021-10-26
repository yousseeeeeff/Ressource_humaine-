package org.sid.ressourcehumaine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocieteF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String N_Num_Affilie;
    private String adresse;
    private String nom;
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    private SocieteM societeM;
    @OneToMany(mappedBy = "societeF")
    private Collection<Employe> employes;
    @OneToMany(mappedBy = "societeF")
    private Collection<Declaration> declarations;
}
