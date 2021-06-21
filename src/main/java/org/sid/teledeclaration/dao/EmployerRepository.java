package org.sid.teledeclaration.dao;

import org.sid.teledeclaration.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employe,Long> {
}
