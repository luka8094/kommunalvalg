package com.example.kommunevalgapp.controllers;


import com.example.kommunevalgapp.exceptions.KandidatNotFoundException;
import com.example.kommunevalgapp.model.Kandidat;
import com.example.kommunevalgapp.model.Parti;
import com.example.kommunevalgapp.repositories.KandidatRepository;
import com.example.kommunevalgapp.repositories.PartiRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/")
public class RestApiController {

    //De
    KandidatRepository kandidatRepository;
    PartiRepository partiRepository;

    //Constructor injection
    public RestApiController(KandidatRepository kandidatRepository,
                             PartiRepository partiRepository)
    {
        this.kandidatRepository = kandidatRepository;
        this.partiRepository = partiRepository;
    }

    //Herunder håndteres REST API med diverse repositories

    //Få fat i alle kandidater fra databasen
    @GetMapping("kandidater")
    public List<Kandidat> getAllKandidater(){

        return kandidatRepository.findAll();
    }

    //Få fat på kandidater der tilhørende et bestemt parti
    @GetMapping("partier/{partiInitialer}")
    public ResponseEntity<List<Kandidat>> getKandidatByParti(@PathVariable String partiInitialer){

        List<Kandidat> partiKandidater = kandidatRepository.getKandidatByPartiInitialer(partiInitialer);

        if (partiKandidater.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else return ResponseEntity.status(HttpStatus.OK).body(partiKandidater);
    }

    //Opret en ny Kandidat i databsen
    //createKandidat
    @PostMapping ("create-kandidat")
    public ResponseEntity<Kandidat> createKandidat(@PathVariable String partiInitialer,
                                                   @PathVariable String navn,
                                                   @RequestBody Kandidat kandidat)
    {

        kandidatRepository.save(kandidat);

        return ResponseEntity.status(HttpStatus.CREATED).body(kandidat);

    }

    //Opdatere en Kandidater der allerede eksistere i databasen
    //updateKandidat
    @PutMapping("kandidater/{id}")
    public ResponseEntity<Kandidat> updateKandidat(@PathVariable Long id,
                                                    @PathVariable String navn,
                                                    @RequestBody Kandidat kandidat)
    {

        //
        kandidatRepository.findById(id).orElseThrow(
                () -> new KandidatNotFoundException("kandidaten med id: " + id + " blev ikke fundet." )
        );

        return ResponseEntity.status(HttpStatus.OK).body(kandidat);
    }


    //Fjern en Kandidat fra databasen
    //removeKandiat
    @DeleteMapping("kandidater/delete-kandidat")
    public ResponseEntity<Long> removeKandidat(@PathVariable Long id){

        //Tjekker om kandidaten overhovedet findes
        kandidatRepository.findById(id).orElseThrow(
                () -> new KandidatNotFoundException("kandidaten med id: " + id + " blev ikke fundet." )
        );

        //Fjener kandidaten per 'id' hvis denne gør
        kandidatRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    //--- herunder er kun en ekstra tilføjelse

    //Få fat i alle partiet
    @GetMapping("partier")
    public List<Parti> getAllPartier(){

        return partiRepository.findAll();
    }



}
