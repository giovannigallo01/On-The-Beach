package it.unical.ingsw.onthebeach.persistenza.dao;
import it.unical.ingsw.onthebeach.model.Utente;

import java.util.List;

public interface UtenteDao {
    public List<Utente> findAll();
    public Utente findByPrimaryKey(String username);
    public boolean save(Utente utente);
    public boolean update(Utente utente);
    public boolean delete(String username);
    public boolean setPassword(String username, String password);
    public boolean setAdmin(String username);
    public List<Utente> findAllFromTipoUtente(String tipoUtente);
}
