package it.unical.ingsw.onthebeach.persistenza.dao;
import it.unical.ingsw.onthebeach.model.Recensione;

import java.util.List;

public interface RecensioneDao {
    public List<Recensione> findAll();
    public Recensione findByPrimaryKey(long id);
    public List<Recensione> findByUtente(String username);
    public List<Recensione> findByLido(String nome);
    public Recensione findByPrenotazione(long id);
    public boolean saveOrUpdate(Recensione recensione);
    public boolean delete(Recensione recensione);
    public boolean updateText(Recensione recensione) ;


}
