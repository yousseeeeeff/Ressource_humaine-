package org.sid.ressourcehumaine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date Periode ;
    @Temporal(TemporalType.DATE)
    private Date date_Declaration;
    private String raison_Social;
    @ManyToMany(mappedBy = "declarations")
    Collection<Employe> employes;
    @ManyToOne
    private SocieteF societeF;

}
