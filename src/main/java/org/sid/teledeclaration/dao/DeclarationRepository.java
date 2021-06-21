package org.sid.teledeclaration.dao;

import org.sid.teledeclaration.entities.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface DeclarationRepository extends JpaRepository<Declaration,Long> {
}
