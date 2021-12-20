package com.example.kommunevalgapp.controllers;


import com.example.kommunevalgapp.model.Kandidat;
import com.example.kommunevalgapp.model.Parti;
import com.example.kommunevalgapp.repositories.KandidatRepository;
import com.example.kommunevalgapp.repositories.PartiRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class RestApiController {

    KandidatRepository kandidatRepository;
    PartiRepository partiRepository;

    //Constructor injection
    public RestApiController(KandidatRepository kandidatRepository,
                             PartiRepository partiRepository)
    {
        this.kandidatRepository = kandidatRepository;
        this.partiRepository = partiRepository;
    }
    //Håndtere REST API med diverse repositories


    @GetMapping("kandidater")
    public List<Kandidat> getAllKandidater(){

        return kandidatRepository.findAll();
    }

    @GetMapping("partier")
    public List<Parti> getAllPartier(){

        return partiRepository.findAll();
    }



}
