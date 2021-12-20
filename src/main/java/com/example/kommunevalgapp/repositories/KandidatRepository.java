package com.example.kommunevalgapp.repositories;

import com.example.kommunevalgapp.model.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KandidatRepository extends JpaRepository<Kandidat, Long> {

    List<Kandidat> getKandidatByPartiInitialer(String partiInitialer);
}
