package com.example.kommunevalgapp.repositories;

import com.example.kommunevalgapp.model.Kandidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KandidatRepository extends JpaRepository<Kandidat, Long> {

    
}
