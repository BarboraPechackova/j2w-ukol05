package cz.czechitas.java2webapps.ukol5.controller;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.EnumSet;

public class RegistraceForm {

//    jméno (povinný údaj)
//    příjmení (povinný údaj)
//    datum narození (povinný údaj)
//    pohlaví (chlapec/dívka – povinný údaj)
//    zvolené sporty (např. plavání, běh, cyklistika, fotbal, basketbal – formou checkboxů)
//    turnus (např. 5. až 11. července, 12. až 18. července, 19. až 25. července – povinný údaj)
//    e-mail na rodiče (volitelný údaj)
//    telefon na rodiče (volitelný údaj)

    @NotBlank
private String jmeno;

    @NotBlank
private String prijmeni;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
private LocalDate narozeni;

    @NotNull
private Pohlavi pohlavi;

    @NotNull
private EnumSet<Sport> sport;

    @NotNull
private String turnus;

    @Email
private String email;
private String telefon;

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public LocalDate getNarozeni() {
        return narozeni;
    }

    public void setNarozeni(LocalDate narozeni) {
        this.narozeni = narozeni;
    }

    public Pohlavi getPohlavi() {
        return pohlavi;
    }

    public void setPohlavi(Pohlavi pohlavi) {
        this.pohlavi = pohlavi;
    }

    public EnumSet<Sport> getSport() {
        return sport;
    }

    public void setSport(EnumSet<Sport> sport) {
        this.sport = sport;
    }


    public String getTurnus() {
        return turnus;
    }

    public void setTurnus(String turnus) {
        this.turnus = turnus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

