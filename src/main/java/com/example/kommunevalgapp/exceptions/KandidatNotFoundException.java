package com.example.kommunevalgapp.exceptions;

//Custom exception i tilfælde af den pågældende Kandidat ikke findes
public class KandidatNotFoundException extends RuntimeException{

    public KandidatNotFoundException(String message ){ super(message);}
}
