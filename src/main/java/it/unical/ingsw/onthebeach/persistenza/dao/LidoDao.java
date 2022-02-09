package it.unical.ingsw.onthebeach.persistenza.dao;

import java.util.List;

import it.unical.ingsw.onthebeach.model.Lido;

public interface LidoDao {

	public List<Lido> findAll();
	public Lido findByPrimaryKey(String nome);
	public List<Lido> findBest3();
	public boolean saveOrUpdate(Lido lido);
	public boolean delete(Lido lido);
	public Lido findByGestore(String username);
	public byte[] trovaImmagine(String username);
}
