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
public class SocieteM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String N_Num_Affilie;
    private String adresse;
    private String nom;
    @OneToMany(mappedBy = "societeM" ,fetch = FetchType.LAZY)
    private Collection<SocieteF> societeFS;
}
