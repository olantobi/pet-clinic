package com.liferon.petclinic.controllers;

import com.liferon.petclinic.model.Vet;
import com.liferon.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/vets")
@AllArgsConstructor
public class VetController {

    private VetService vetService;

    @RequestMapping({"", "/", "index", "index.html"})
    public String listVets(Model model) {

        Set<Vet> vets = vetService.findAll();
        model.addAttribute("vets", vets);

        return "vets/index";
    }
}


