package org.sid.ressourcehumaine.dao;

import org.sid.ressourcehumaine.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employe,Long> {
    public Page<Employe> findByNomContains(String name, Pageable pageable);
}
