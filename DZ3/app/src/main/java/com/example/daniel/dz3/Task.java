package com.example.daniel.dz3;

/**
 * Created by daniel on 10.4.2017..
 */

public class Task {
private String Naslov;
private String OpisZadatka;
private String Prioritet;

    public Task(String naslov, String opisZadatka, String prioritet) {
        Naslov = naslov;
        OpisZadatka = opisZadatka;
        Prioritet = prioritet;
    }

    public String getNaslov() {
        return Naslov;
    }

    public String getOpisZadatka() {
        return OpisZadatka;
    }

    public String getPrioritet() {
        return Prioritet;
    }
}
