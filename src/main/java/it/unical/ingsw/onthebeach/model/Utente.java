package it.unical.ingsw.onthebeach.model;

import java.sql.Date;
import java.util.Objects;

public class Utente {

    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String tipoUtente;
    private Date dataNascita;
    private String genere;

    public Utente(){
    }

    public Utente(String username, String nome, String cognome, String email, String password, String tipoUtente, Date dataNascita, String genere){
        super();
        this.username=username;
        this.nome=nome;
        this.cognome=cognome;
        this.email=email;
        this.password=password;
        this.tipoUtente=tipoUtente;
        this.dataNascita=dataNascita;
        this.genere=genere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utente utente = (Utente) o;
        return username.equals(utente.username) && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome) && email.equals(utente.email) && password.equals(utente.password) && Objects.equals(tipoUtente, utente.tipoUtente) && Objects.equals(dataNascita, utente.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, nome, cognome, email, password, tipoUtente, dataNascita);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipo_utente) {
        this.tipoUtente = tipo_utente;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
