package org.sid.ressourcehumaine.dao;

import org.sid.ressourcehumaine.entities.SocieteF;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteFRepository extends JpaRepository<SocieteF,Long> {
    public Page<SocieteF> findByNomContains(String name, Pageable pageable);

}
