package org.sid.teledeclaration.controllers;

import org.sid.teledeclaration.dao.DeclarationRepository;
import org.sid.teledeclaration.dao.EmployerRepository;
import org.sid.teledeclaration.dao.SocieteFRepository;
import org.sid.teledeclaration.dao.SocieteMRepository;
import org.sid.teledeclaration.entities.Declaration;
import org.sid.teledeclaration.entities.SocieteM;
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

@Controller
public class DeclarationController {
    @Autowired
    private DeclarationRepository declarationRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SocieteMRepository societeMRepository;
    @Autowired
    private SocieteFRepository societeFRepository;
//    @GetMapping(path="/")
//    public String index()
//    {
//
//
//        return"template";
//    }
    @GetMapping(path = "/societemere")
    public String listSM(Model model , @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam (name = "size", defaultValue = "5") int size
            , @RequestParam (name = "keyword", defaultValue = "") String mc)
    {
        Page<SocieteM> societeMS = societeMRepository.findByNomContains(mc, PageRequest.of(page,size));
        model.addAttribute("societeM",societeMS.getContent());
        model.addAttribute("pages", new int[societeMS.getTotalPages()]);
        model.addAttribute("currentpages", page);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "societeM";
    }
    @GetMapping(path="/formSM")
    public String formpatient(Model model)
    {
        model.addAttribute("societeM", new SocieteM());
        model.addAttribute("mode","new");
        return "formsm";
    }
    @PostMapping("/saveSM")
    @Transactional
    public String savePatient(Model model , @Valid SocieteM societeM, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) return "formPatient";
        model.addAttribute("societeM" , societeM);
        societeMRepository.save(societeM);
        return "societeM";
    }
}
