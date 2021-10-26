package org.sid.ressourcehumaine.dao;

import org.sid.ressourcehumaine.entities.SocieteM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteMRepository extends JpaRepository<SocieteM,Long> {
    public Page<SocieteM> findByNomContains(String name, Pageable pageable);

}
