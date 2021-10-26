package org.sid.ressourcehumaine.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vaccance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date1 ;
    private Date date2;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    private Employe employe;

}
