package org.sid.ressourcehumaine.controllers;

import org.sid.ressourcehumaine.dao.DeclarationRepository;
import org.sid.ressourcehumaine.dao.EmployerRepository;
import org.sid.ressourcehumaine.dao.SocieteFRepository;
import org.sid.ressourcehumaine.dao.SocieteMRepository;
import org.sid.ressourcehumaine.entities.SocieteF;
import org.sid.ressourcehumaine.entities.SocieteM;
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
public class SocietefContoller {
    @Autowired
    private DeclarationRepository declarationRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private SocieteMRepository societeMRepository;
    @Autowired
    private SocieteFRepository societeFRepository;
    @GetMapping(path = "/societefille")
    public String listSM(Model model , @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam (name = "size", defaultValue = "5") int size
            , @RequestParam (name = "keyword", defaultValue = "") String mc)
    {

        Page<SocieteF> societeFS = societeFRepository.findByNomContains(mc, PageRequest.of(page,size));

        model.addAttribute("societeFF",societeFS.getContent());
        model.addAttribute("pages", new int[societeFS.getTotalPages()]);
        model.addAttribute("currentpages", page);
        model.addAttribute("SM", societeMRepository);
        model.addAttribute("keyword", mc);
        model.addAttribute("size", size);
        return "societeFille";
    }
    @GetMapping(path="/formSF")
    public String formpatient(Model model)
    {
        List<SocieteM> societeMList= societeMRepository.findAll();

        model.addAttribute("societeFF", new SocieteF());
        model.addAttribute("societeMList",societeMList);
        model.addAttribute("mode","new");
        return "formsf";
    }
    @PostMapping("/saveSF")
    @Transactional
    public String savePatient(Model model , @Valid SocieteF societeFF, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()) return "formsf";
        model.addAttribute("societeFF" , societeFF);

        societeFRepository.save(societeFF);
        return "societefille";
    }
    @GetMapping(path="/deletesf")
    public String delete(long id , String keyword , int page ,int size)
    {
        societeFRepository.deleteById(id);

        return"redirect:/societefille?page="+page+"&size="+size+"&keyword="+keyword;
    }
    @GetMapping(path="/editsf")
    public String edit(Model model,long id )
    {

        SocieteF p= societeFRepository.findById(id).get();
        List<SocieteM> societeMList= societeMRepository.findAll();
        long id2 = p.getSocieteM().getId();
        p.setSocieteM(societeMRepository.findById(id).get());
        model.addAttribute("societeFF", p);
        model.addAttribute("societeMList",societeMList);
        model.addAttribute("mode","edit");
        return "formsf";
    }
}
