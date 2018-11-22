package com.liferon.petclinic.controllers;

import com.liferon.petclinic.model.Owner;
import com.liferon.petclinic.services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @RequestMapping({"", "/", "index", "index.html"})
    public String listOwners(Model model) {

        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model) {

        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);

        return "owners/index";
    }
}
