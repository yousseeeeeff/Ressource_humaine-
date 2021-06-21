package org.sid.teledeclaration.dao;

import org.sid.teledeclaration.entities.SocieteM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteMRepository extends JpaRepository<SocieteM,Long> {
    public Page<SocieteM> findByNomContains(String name, Pageable pageable);
}
