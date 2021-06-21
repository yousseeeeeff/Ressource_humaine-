package org.sid.teledeclaration;

import org.sid.teledeclaration.dao.SocieteMRepository;
import org.sid.teledeclaration.entities.SocieteM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeledeclarationApplication implements CommandLineRunner {
    @Autowired
    SocieteMRepository societeMRepository;

    public static void main(String[] args) {

        SpringApplication.run(TeledeclarationApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        societeMRepository.save(new SocieteM(null, "23534212", "hay al azhar ", "fontecelta", null));

    }
}