package it.unical.ingsw.onthebeach.model;

import java.util.Objects;

public class Recensione {
    private String testo;
    private String usernameCliente;
    private Long idPrenotazione;
    private Long idRecensione;
    private int star;

    public Recensione(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recensione that = (Recensione) o;
        return idPrenotazione == that.idPrenotazione && idRecensione == that.idRecensione && Objects.equals(testo, that.testo) && usernameCliente.equals(that.usernameCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testo, usernameCliente, idPrenotazione, idRecensione);
    }

    public Recensione(Long idRecensione, String testo, int star, String usernameCliente, Long idPrenotazione){
        this.idRecensione=idRecensione;
        this.testo=testo;
        this.usernameCliente=usernameCliente;
        this.idPrenotazione=idPrenotazione;
        this.star=star;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }


    public String getUsernameCliente() {
        return usernameCliente;
    }

    public void setUsernameCliente(String usernameCliente) {
        this.usernameCliente = usernameCliente;
    }

    public long getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(long idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public Long getIdRecensione() {
        return idRecensione;
    }

    public void setIdRecensione(Long idRecensione) {
        this.idRecensione = idRecensione;
    }

    public void setStar(int star){
        this.star=star;
    }

    public int getStar(){
        return star;
    }
}
