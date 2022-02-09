package it.unical.ingsw.onthebeach.persistenza.dao;

import it.unical.ingsw.onthebeach.model.Ombrellone;
import it.unical.ingsw.onthebeach.model.Utente;

import java.util.List;

public interface OmbrelloneDao {
    public boolean saveOrUpdate(Ombrellone ombrellone);
    public Ombrellone findByPrimaryKey(long id);
    public List<Ombrellone> findByLido(String nome);
    public boolean delete(Ombrellone ombrellone);
    public boolean switchOccupato(Ombrellone ombrellone);
    public List<Ombrellone> findAll();
}
