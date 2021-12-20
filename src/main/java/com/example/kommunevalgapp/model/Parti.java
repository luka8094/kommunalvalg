package com.example.kommunevalgapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="partier")
public class Parti {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String initialer;

    @NotNull
    private String navn;

    @OneToMany(mappedBy = "parti")
    @JsonBackReference
    private Set<Kandidat> kandidatList = new HashSet<>();

    public Parti(){ }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getInitialer() {
        return initialer;
    }

    public void setInitialer(String initialer) {
        this.initialer = initialer;
    }

    public Set<Kandidat> getKandidatList() {
        return kandidatList;
    }

    public void setKandidatList(Set<Kandidat> kandidatList) {
        this.kandidatList = kandidatList;
    }
}
