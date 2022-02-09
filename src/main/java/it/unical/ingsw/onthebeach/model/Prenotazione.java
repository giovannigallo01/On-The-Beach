package it.unical.ingsw.onthebeach.model;

import java.sql.Date;
import java.util.Objects;

public class Prenotazione {

	private long idPrenotazione;
	private float prezzoTotale;
	private String descrizione;
	private String dataPrenotazione;
	private String dataInizio;
	private String dataFine;
	private String usernameCliente;
	private String nomeLido;

	public Prenotazione() {}

	public Prenotazione(float prezzoTotale, String descrizione, String dataPrenotazione, String dataInizio, String dataFine,
						String usernameCliente, String nomeLido) {
		super();
		this.prezzoTotale = prezzoTotale;
		this.descrizione = descrizione;
		this.dataPrenotazione = dataPrenotazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.usernameCliente = usernameCliente;
		this.nomeLido = nomeLido;
	}

	public long getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(long idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public float getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(String dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}

	public String getNomeLido() {
		return nomeLido;
	}

	public void setNomeLido(String nomeLido) {
		this.nomeLido = nomeLido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFine, dataInizio, dataPrenotazione, descrizione, idPrenotazione, nomeLido, prezzoTotale,
				usernameCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prenotazione other = (Prenotazione) obj;
		return Objects.equals(dataFine, other.dataFine) && Objects.equals(dataInizio, other.dataInizio)
				&& Objects.equals(dataPrenotazione, other.dataPrenotazione)
				&& Objects.equals(descrizione, other.descrizione) && idPrenotazione == other.idPrenotazione
				&& Objects.equals(nomeLido, other.nomeLido)
				&& Float.floatToIntBits(prezzoTotale) == Float.floatToIntBits(other.prezzoTotale)
				&& Objects.equals(usernameCliente, other.usernameCliente);
	}
}