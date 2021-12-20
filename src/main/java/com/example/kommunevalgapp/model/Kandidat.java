package com.example.kommunevalgapp.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="kandidater")
public class Kandidat {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String navn;

    @ManyToOne
    @JoinColumn(name = "parti_initialer")
    @JsonManagedReference
    private Parti parti;

    public Kandidat(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
