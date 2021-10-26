package org.sid.ressourcehumaine.dao;

import org.sid.ressourcehumaine.entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface DeclarationRepository extends JpaRepository<Declaration,Long> {
}
