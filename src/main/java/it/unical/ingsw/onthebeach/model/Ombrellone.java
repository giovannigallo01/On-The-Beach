package it.unical.ingsw.onthebeach.model;

import java.util.Objects;

public class Ombrellone {

    private long idOmbrellone;
    private boolean occupato;
    private String nomeLido;
    private float prezzo;

    public Ombrellone(){
    }

    public Ombrellone(long idOmbrellone, boolean occupato, String nomeLido, float prezzo){
        this.idOmbrellone=idOmbrellone;
        this.occupato=occupato;
        this.nomeLido=nomeLido;
        this.prezzo=prezzo;
    }

    public long getIdOmbrellone() {
        return idOmbrellone;
    }

    public void setIdOmbrellone(long idOmbrellone) {
        this.idOmbrellone = idOmbrellone;
    }

    public boolean getOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public String getNomeLido() {
        return nomeLido;
    }

    public void setNomeLido(String nomeLido) {
        this.nomeLido = nomeLido;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ombrellone that = (Ombrellone) o;
        return idOmbrellone == that.idOmbrellone && occupato == that.occupato && Float.compare(that.prezzo, prezzo) == 0 && nomeLido.equals(that.nomeLido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOmbrellone, occupato, nomeLido, prezzo);
    }
}
