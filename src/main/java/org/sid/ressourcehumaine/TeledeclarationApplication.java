package org.sid.ressourcehumaine;

import org.sid.ressourcehumaine.dao.SocieteFRepository;
import org.sid.ressourcehumaine.dao.SocieteMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeledeclarationApplication implements CommandLineRunner {
    @Autowired
    SocieteMRepository societeMRepository;
    @Autowired
    SocieteFRepository societeFRepository;
    public static void main(String[] args) {

        SpringApplication.run(TeledeclarationApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
      //  societeMRepository.save(new SocieteM(null, "23534212", "hay al azhar ", "fontecelta", null));

    }
}