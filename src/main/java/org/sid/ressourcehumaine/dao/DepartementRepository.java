package org.sid.ressourcehumaine.dao;

import org.sid.ressourcehumaine.entities.Departement;
import org.sid.ressourcehumaine.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
    public Page<Departement> findByDesignationContains(String name, Pageable pageable);
}
