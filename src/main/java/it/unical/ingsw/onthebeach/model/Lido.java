package it.unical.ingsw.onthebeach.model;

import java.util.Objects;

public class Lido {

	private String nome;
	private String posizione;
	private String numero;
	private String email;
	private String descrizione;
	private byte[] foto;
	private int numeroOmbrelloni;
	//private List<Ombrellone> listaOmbrelloni;
	private String usernameGestore;
	
	public Lido() {}
	
	public Lido(String nome, String posizione, String numero, String email, String descrizione, byte[] foto,
			int numeroOmbrelloni, String usernameGestore /*, List<Ombrellone> listaOmbrelloni*/) {
		super();
		this.nome = nome;
		this.posizione = posizione;
		this.numero = numero;
		this.email = email;
		this.descrizione = descrizione;
		this.foto = foto;
		this.numeroOmbrelloni = numeroOmbrelloni;
		this.usernameGestore = usernameGestore;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPosizione() {
		return posizione;
	}
	
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public byte[] getFoto() {
		return foto;
	}
	
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public int getNumeroOmbrelloni() {
		return numeroOmbrelloni;
	}
	
	public void setNumeroOmbrelloni(int numeroOmbrelloni) {
		this.numeroOmbrelloni = numeroOmbrelloni;
	}
	
	public String getUsernameGestore() {
		return usernameGestore;
	}
	
	public void setUsernameGestore(String usernameGestore) {
		this.usernameGestore = usernameGestore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descrizione, email, foto, nome, numero, numeroOmbrelloni, posizione, usernameGestore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lido other = (Lido) obj;
		return Objects.equals(descrizione, other.descrizione) && Objects.equals(email, other.email)
				&& Objects.equals(foto, other.foto) && Objects.equals(nome, other.nome)
				&& Objects.equals(numero, other.numero) && numeroOmbrelloni == other.numeroOmbrelloni
				&& Objects.equals(posizione, other.posizione) && Objects.equals(usernameGestore, other.usernameGestore);
	}
}

