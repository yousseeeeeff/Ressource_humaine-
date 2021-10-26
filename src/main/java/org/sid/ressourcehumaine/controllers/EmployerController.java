package org.sid.ressourcehumaine.controllers;

import org.sid.ressourcehumaine.dao.*;
import org.sid.ressourcehumaine.dao.DepartementRepository;
import org.sid.ressourcehumaine.entities.Departement;
import org.sid.ressourcehumaine.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployerController {
    @Autowired
    private DeclarationRepository declarationRepository;

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private SocieteMRepository societeMRepository;
    @Autowired
    private SocieteFRepository societeFRepository;

    @GetMapping(path = "/employer")
    public String listSM(Model model, @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam(name = "size", defaultValue = "5") int size
            , @RequestParam(name = "keyword", defaultValue = "") String mc) {

        Page<Employe> employer = employerRepository.findByNomContains(mc, PageRequest.of(page, size));

        model.addAttribute("p", employer.getContent());
        model.addAttribute("pages", new int[employer.getTotalPages()]);
        model.addAttribute("currentpages", page);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "employer";
    }

    @GetMapping(path = "/formEm")
    public String formpatient(Model model) {
        List<Departement> societeFList = departementRepository.findAll();
        model.addAttribute("p", new Employe());
        model.addAttribute("societeMList", societeFList);
        model.addAttribute("mode", "new");
        return "formemf";
    }

    @PostMapping("/saveSE")
    @Transactional
    public String savePatient(Model model, @Valid Employe p, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "formemf";
        // employer.setId(null);
        // p.setId(null);
        p = employerRepository.save(p);
        model.addAttribute("p", p);
        return "confirmation_employer";
    }

    @GetMapping(path = "/deleteem")
    public String delete(long id, String keyword, int page, int size) {
        employerRepository.deleteById(id);

        return "redirect:/employer?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

    @GetMapping(path = "/editem")
    public String edit(Model model, long id) {
        Employe em = employerRepository.findById(id).get();
        List<Departement> societeFList = departementRepository.findAll();

        model.addAttribute("p", em);
        model.addAttribute("societeMList", societeFList);
        model.addAttribute("mode", "edit");
        return "formemf";
    }

    @GetMapping(path = "/depar")
    public String listdep(Model model, @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam(name = "size", defaultValue = "5") int size
            , @RequestParam(name = "keyword", defaultValue = "") String mc) {

        Page<Departement> departements = departementRepository.findByDesignationContains(mc, PageRequest.of(page, size));

        model.addAttribute("p", departements.getContent());
        model.addAttribute("pages", new int[departements.getTotalPages()]);
        model.addAttribute("currentpages", page);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "departement";
    }

    @GetMapping(path = "/formdep")
    public String formdepar(Model model) {
        //List<Departement> societeFList = departementRepository.findAll();
        model.addAttribute("p", new Departement());

        model.addAttribute("mode", "new");
        return "formdepart";
    }

    @PostMapping("/savedep")
    @Transactional
    public String saveDepart(Model model, @Valid Departement p, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) return "formdepart";
        p = departementRepository.save(p);
        model.addAttribute("p", p);
        return "confirmation_departement";
    }
    @GetMapping(path = "/deletedep")
    public String deletedep(long id, String keyword, int page, int size) {
        employerRepository.deleteById(id);

        return "redirect:/depar?page=" + page + "&size=" + size + "&keyword=" + keyword;
    }

}
