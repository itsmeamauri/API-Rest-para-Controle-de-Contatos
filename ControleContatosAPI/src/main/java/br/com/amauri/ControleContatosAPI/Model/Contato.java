package br.com.amauri.ControleContatosAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;

	@Column(nullable = false)
	private int tipo;

	@Column(length = 50, nullable = false)
	private String contato;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	@JsonIgnore 
	private Pessoa pessoa;

	public long getPessoaId() {
		return pessoa.getID();
	}

	public void setPessoaId(long ID) {
		pessoa = new Pessoa();
		pessoa.setID(ID);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

}
